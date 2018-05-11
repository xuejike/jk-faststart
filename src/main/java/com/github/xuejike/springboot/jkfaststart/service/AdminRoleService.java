package com.github.xuejike.springboot.jkfaststart.service;

import com.github.xuejike.springboot.jkfaststart.domain.AdminRole;

public interface AdminRoleService extends BaseService<AdminRole,Long> {

    void addSave(AdminRole role,Long[] haveIds);
}
