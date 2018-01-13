package com.github.xuejike.springboot.jkfaststart.service.impl;


import com.github.xuejike.springboot.jkfaststart.JkConfig;
import com.github.xuejike.springboot.jkfaststart.domain.AdminPermission;
import com.github.xuejike.springboot.jkfaststart.domain.QAdminPermission;
import com.github.xuejike.springboot.jkfaststart.domain.type.PermissionType;
import com.github.xuejike.springboot.jkfaststart.repository.AdminPermissionRepository;
import com.github.xuejike.springboot.jkfaststart.service.AdminPermissionService;
import com.github.xuejike.springboot.jkfaststart.vo.Menu;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class AdminPermissionServiceImpl extends BaseServiceImpl<AdminPermission,Long> implements AdminPermissionService {
    @Autowired
    EntityManager entityManager;
    @Autowired
    AdminPermissionRepository adminPermissionRepository;

    @Override
    public List<Menu> getRootMenuTree(){
        QAdminPermission adminPermission = QAdminPermission.adminPermission;
        //根菜单
        Iterable<AdminPermission> rootMenu = adminPermissionRepository
                .findAll(adminPermission.pid.isNull()
                , adminPermission.sortIndex.asc());

        ArrayList<Menu> list = new ArrayList<>();
        rootMenu.forEach(m->{
            Menu menu = new Menu();
            menu.setText(m.getName());
            menu.setId(m.getId());
            menu.setHref(JkConfig.ADMIN_PATH+"/menu/left-menu?pid="+m.getId());
            menu.setTarget(false);
            menu.setIcon(m.getIcon());
            list.add(menu);
        });


        return list;
    }

    @Override
    public List<Menu> getSubMenu(Long pid) {
        Iterable<AdminPermission> all = adminPermissionRepository
                .findAll(QAdminPermission
                .adminPermission.pid.eq(pid),
                        QAdminPermission.adminPermission.sortIndex.asc());

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
                    end.setName("&nbsp;&nbsp;&nbsp;&nbsp;|---"+end.getName());
                    list.add(end);
                }

            }

        }
        return list;
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

}
