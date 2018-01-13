package com.github.xuejike.springboot.jkfaststart.service.impl;

import com.bidanet.springmvc.demo.jkbuilder.JkVerifyUtils;
import com.github.xuejike.springboot.jkfaststart.controller.admin.view.user.AddAdminUser;
import com.github.xuejike.springboot.jkfaststart.domain.AdminUser;
import com.github.xuejike.springboot.jkfaststart.domain.QAdminUser;
import com.github.xuejike.springboot.jkfaststart.domain.type.Status;
import com.github.xuejike.springboot.jkfaststart.repository.AdminUserRepository;
import com.github.xuejike.springboot.jkfaststart.service.AdminUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserServiceImpl extends BaseServiceImpl<AdminUser,Long> implements AdminUserService {
    @Autowired
    AdminUserRepository adminUserRepository;
    @Override
    public void saveUser(AddAdminUser addAdminUser){
        JkVerifyUtils.verify(addAdminUser);
        AdminUser adminUser = new AdminUser();
        BeanUtils.copyProperties(addAdminUser,adminUser);
//        DigestUtils
        adminUser.setPwd(DigestUtils.md5Hex(adminUser.getPwd()));
        adminUser.setDelete(false);
        adminUser.setStatus(Status.open);
        adminUserRepository.save(adminUser);


    }
}
