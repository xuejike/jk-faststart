package com.github.xuejike.springboot.jkfaststart.service;

import com.github.xuejike.springboot.jkfaststart.controller.admin.view.user.AddAdminUser;
import com.github.xuejike.springboot.jkfaststart.controller.admin.view.user.UpdateAdminUser;
import com.github.xuejike.springboot.jkfaststart.domain.AdminUser;

public interface AdminUserService extends BaseService<AdminUser,Long> {
    void saveUser(AddAdminUser addAdminUser, UpdateAdminUser updateAdminUser);

    /**
     * 重置密码
     * @param pwd
     */
    void resetPwd(String pwd);


}
