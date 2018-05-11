package com.github.xuejike.springboot.jkfaststart.service.impl;

import com.github.xuejike.springboot.jkfaststart.domain.AdminPermission;
import com.github.xuejike.springboot.jkfaststart.domain.AdminRole;
import com.github.xuejike.springboot.jkfaststart.service.AdminRoleService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;

@Service
public class AdminRoleServiceImpl extends BaseServiceImpl<AdminRole,Long> implements AdminRoleService {
    @Override
    public void addSave(AdminRole role, Long[] haveIds) {
        if (Objects.nonNull(role.getId())){
            role=get(role.getId());
        }

        HashSet<AdminPermission> hashSet = new HashSet<>();
        Optional.ofNullable(haveIds).ifPresent(v->{
            for (Long id : haveIds) {
                AdminPermission permission = new AdminPermission();
                permission.setId(id);
                hashSet.add(permission);
            }
        });

        role.setPermissionSet(hashSet);
        save(role);
    }
}
