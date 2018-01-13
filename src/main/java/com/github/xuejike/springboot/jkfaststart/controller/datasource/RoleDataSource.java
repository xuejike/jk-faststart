package com.github.xuejike.springboot.jkfaststart.controller.datasource;

import com.bidanet.springmvc.demo.jkbuilder.data.JkNameValueData;
import com.bidanet.springmvc.demo.jkbuilder.data.JkNameValueDataImpl;
import com.bidanet.springmvc.demo.jkbuilder.type.JkTypeDataSource;
import com.github.xuejike.springboot.jkfaststart.repository.AdminRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleDataSource implements JkTypeDataSource {
    @Autowired
    AdminRoleRepository adminRoleRepository;
    @Override
    public List<JkNameValueData> search(String s) {
        List<JkNameValueData> collect = adminRoleRepository.findAll().stream().map(r ->
                new JkNameValueDataImpl(r.getName(), r.getId().toString())).collect(Collectors.toList());
        return collect;
    }

    @Override
    public String getText(String val) {
        if (val!=null){
            return adminRoleRepository.findOne(Long.parseLong(val)).getName();
        }
        return null;
    }
}
