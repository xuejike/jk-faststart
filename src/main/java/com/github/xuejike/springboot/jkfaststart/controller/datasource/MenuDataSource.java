package com.github.xuejike.springboot.jkfaststart.controller.datasource;

import com.bidanet.springmvc.demo.jkbuilder.data.JkNameValueData;
import com.bidanet.springmvc.demo.jkbuilder.data.JkNameValueDataImpl;
import com.bidanet.springmvc.demo.jkbuilder.type.JkTypeDataSource;
import com.github.xuejike.springboot.jkfaststart.domain.AdminPermission;
import com.github.xuejike.springboot.jkfaststart.domain.QAdminPermission;
import com.github.xuejike.springboot.jkfaststart.repository.AdminPermissionRepository;
import com.github.xuejike.springboot.jkfaststart.service.AdminPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MenuDataSource implements JkTypeDataSource {

    @Autowired
    AdminPermissionRepository adminPermissionRepository;

    @Override
    public List<JkNameValueData> search(String s) {
        Iterable<AdminPermission> list = adminPermissionRepository.findAll(QAdminPermission.adminPermission.pid.isNull(), QAdminPermission.adminPermission.sortIndex.asc());
//        List<AdminPermission> list = adminPermissionService.getList();
        ArrayList<JkNameValueData> data = new ArrayList<>();
        for (AdminPermission adminPermission : list) {
            data.add(new JkNameValueDataImpl(adminPermission.getName(),adminPermission.getId().toString()));
            if (adminPermission.getSubMenu().size()>0){
                for (AdminPermission permission : adminPermission.getSubMenu()) {
                    data.add(new JkNameValueDataImpl("-->"+permission.getName(),permission.getId().toString()));
                }

            }
        }


        return data;
    }

    @Override
    public String getText(String val) {
        return adminPermissionRepository.getOne(Long.valueOf(val)).getName();
    }
}
