package com.github.xuejike.springboot.jkfaststart.service.impl;


import com.bidanet.bdcms.core.common.SpringWebTool;
import com.bidanet.springmvc.demo.jkbuilder.data.JkNameValueData;
import com.bidanet.springmvc.demo.jkbuilder.data.JkNameValueDataImpl;
import com.github.xuejike.springboot.jkfaststart.JkConfig;
import com.github.xuejike.springboot.jkfaststart.domain.AdminPermission;
import com.github.xuejike.springboot.jkfaststart.domain.AdminRole;
import com.github.xuejike.springboot.jkfaststart.domain.AdminUser;
import com.github.xuejike.springboot.jkfaststart.domain.QAdminPermission;
import com.github.xuejike.springboot.jkfaststart.repository.AdminPermissionRepository;
import com.github.xuejike.springboot.jkfaststart.repository.AdminRoleRepository;
import com.github.xuejike.springboot.jkfaststart.service.AdminPermissionService;
import com.github.xuejike.springboot.jkfaststart.vo.Menu;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AdminPermissionServiceImpl extends BaseServiceImpl<AdminPermission,Long> implements AdminPermissionService {
    @Autowired
    EntityManager entityManager;
    @Autowired
    AdminPermissionRepository adminPermissionRepository;
    @Autowired
    AdminRoleRepository adminRoleRepository;

    @Override
    public List<Menu> getRootMenuTree(Long roleId){

        QAdminPermission adminPermission = QAdminPermission.adminPermission;
        //根菜单
        Iterable<AdminPermission> rootMenu = adminPermissionRepository
                .findAll(adminPermission.pid.isNull()
                , adminPermission.sortIndex.asc());
        ArrayList<Long> permissionIds=new ArrayList<>(1);
        if (roleId!=ROOT_ADMIN_ROLE_ID){
            AdminRole roleInfo = adminRoleRepository.getOne(roleId);
            Set<AdminPermission> permissionSet = roleInfo.getPermissionSet();
            permissionIds = new ArrayList<>(permissionSet.size());
            ArrayList<Long> finalPermissionIds = permissionIds;
            permissionSet.forEach(p-> finalPermissionIds.add(p.getId()));
        }
        ArrayList<Menu> list = new ArrayList<>();
        ArrayList<Long> finalPermissionIds1 = permissionIds;
        rootMenu.forEach(m->{
            Long id = m.getId();
            if (finalPermissionIds1.contains(id)||roleId==ROOT_ADMIN_ROLE_ID){
                Menu menu = new Menu();
                menu.setText(m.getName());
                menu.setId(id);
                menu.setHref(JkConfig.ADMIN_PATH+"/menu/left-menu?pid="+ id);
                menu.setTarget(false);
                menu.setIcon(m.getIcon());
                list.add(menu);
            }

        });


        return list;
    }

    @Override
    public List<Menu> getSubMenu(Long pid, Long roleId) {
        BooleanExpression eq = QAdminPermission.adminPermission.pid.eq(pid);
        if (roleId!=ROOT_ADMIN_ROLE_ID){
            AdminRole role = adminRoleRepository.getOne(roleId);
            List<Long> permIds = role.getPermissionSet().stream().map(p -> p.getId()).collect(Collectors.toList());
            eq=eq.and(QAdminPermission.adminPermission.id.in(permIds));
        }
        Iterable<AdminPermission> all = adminPermissionRepository
                .findAll(eq, QAdminPermission.adminPermission.sortIndex.asc());

        ArrayList<Menu> menus = new ArrayList<>();
        all.forEach(q->{
            Menu menu = createMenu(q);
            menus.add(menu);
            if (q.getSubMenu().size()>0){
                List<Menu> list = q.getSubMenu().stream().map(p -> createMenu(p)).collect(Collectors.toList());
                menu.setSubset(list);
            }
        });



        return menus;
    }

    @Override
    public List<AdminPermission> listShow() {
        ArrayList<AdminPermission> list = new ArrayList<>();
        Iterable<AdminPermission> all = adminPermissionRepository.
                findAll(QAdminPermission.adminPermission.pid.isNull());

        for (AdminPermission adminPermission : all) {
            list.add(adminPermission);
            for (AdminPermission permission : adminPermission.getSubMenu()) {
                permission.setName("|--"+permission.getName());
                list.add(permission);
                for (AdminPermission end : permission.getSubMenu()) {
                    end.setName("|--------"+end.getName());
                    list.add(end);
                }

            }

        }
        return list;
    }

    @Override
    public List<JkNameValueData> getParentList() {
        Iterable<AdminPermission> list = adminPermissionRepository.findAll(QAdminPermission.adminPermission.pid.isNull(), QAdminPermission.adminPermission.sortIndex.asc());
//        List<AdminPermission> list = adminPermissionService.getList();
        ArrayList<JkNameValueData> data = new ArrayList<>();
        data.add(new JkNameValueDataImpl("根菜单",""));
        for (AdminPermission adminPermission : list) {
            data.add(new JkNameValueDataImpl(adminPermission.getName(),adminPermission.getId().toString()));
            if (adminPermission.getSubMenu().size()>0){
                for (AdminPermission permission : adminPermission.getSubMenu()) {
                    data.add(new JkNameValueDataImpl("|--"+permission.getName(),permission.getId().toString()));
                }

            }
        }
        return data;
    }

    private Menu createMenu(AdminPermission q) {
        Menu menu = new Menu();
        menu.setId(q.getId());
        menu.setText(q.getName());
        menu.setHref(q.getUrl());
        menu.setIcon(q.getIcon()==null?"":q.getIcon());
        menu.setPid(q.getPid());
        return menu;
    }

    @Override
    public void delMenu(Long id) {

    }

    @Override
    public boolean checkRoleByAdmin() {
        AdminUser user = (AdminUser) SpringWebTool.getSession().getAttribute("user");
        if (user.getRoleId()==ROOT_ADMIN_ROLE_ID){
            return true;
        }
            return false;
    }

}
