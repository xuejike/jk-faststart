package com.github.xuejike.springboot.jkfaststart.service.impl;

import com.bidanet.bdcms.core.common.SpringWebTool;
import com.bidanet.springmvc.demo.jkbuilder.JkVerifyUtils;
import com.github.xuejike.springboot.jkfaststart.controller.admin.view.user.AddAdminUser;
import com.github.xuejike.springboot.jkfaststart.controller.admin.view.user.UpdateAdminUser;
import com.github.xuejike.springboot.jkfaststart.domain.AdminUser;
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
    public void saveUser(AddAdminUser addAdminUser, UpdateAdminUser updateAdminUser){
        JkVerifyUtils.verify(addAdminUser);
        AdminUser adminUser = new AdminUser();
        if (updateAdminUser.getId()==null){
            BeanUtils.copyProperties(addAdminUser,adminUser);

            adminUser.setPwd(DigestUtils.md5Hex(adminUser.getPwd()));
            adminUser.setDelete(false);
            adminUser.setStatus(Status.open);
        }else{
            adminUser = adminUserRepository.getOne(updateAdminUser.getId());
            BeanUtils.copyProperties(addAdminUser,adminUser,"pwd");

            adminUser.setStatus(updateAdminUser.getStatus());
            if ( ! adminUser.getPwd().equals(addAdminUser.getPwd())){
                adminUser.setPwd(DigestUtils.md5Hex(addAdminUser.getPwd()));
            }
        }




        adminUserRepository.save(adminUser);


    }

    @Override
    public void resetPwd(String pwd) {
        AdminUser user = (AdminUser) SpringWebTool.getSession().getAttribute("user");
        checkNull(pwd,"密码不能为空");
        AdminUser adminUser = adminUserRepository.findOne(user.getId());
        adminUser.setPwd(DigestUtils.md5Hex(pwd));
        adminUserRepository.save(adminUser);
    }
}
