package com.github.xuejike.springboot.jkfaststart.service;

import com.github.xuejike.springboot.jkfaststart.controller.admin.view.user.AddAdminUser;
import com.github.xuejike.springboot.jkfaststart.domain.AdminUser;

public interface AdminUserService extends BaseService<AdminUser,Long> {
    void saveUser(AddAdminUser addAdminUser);


}
