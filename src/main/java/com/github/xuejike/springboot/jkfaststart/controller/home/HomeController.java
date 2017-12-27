package com.github.xuejike.springboot.jkfaststart.controller.home;

import com.github.xuejike.springboot.jkfaststart.domain.AdminPermission;
import com.github.xuejike.springboot.jkfaststart.domain.AdminRole;
import com.github.xuejike.springboot.jkfaststart.domain.AdminUser;
import com.github.xuejike.springboot.jkfaststart.repository.AdminPermissionRepository;
import com.github.xuejike.springboot.jkfaststart.repository.AdminRoleRepository;
import com.github.xuejike.springboot.jkfaststart.repository.AdminUserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;

@Controller
public class HomeController {
    @Autowired
    AdminUserRepository adminUserRepository;
    @Autowired
    AdminPermissionRepository adminPermissionRepository;

    @Autowired
    AdminRoleRepository adminRoleRepository;

    @RequestMapping("/")
    public String home(){
//        for (int i = 0; i < 10; i++) {
//            AdminPermission adminPermission = new AdminPermission();
//            adminPermission.setUrl("/admin/url-"+i);
//            adminPermission.setName("admin_url_"+i);
//
//            adminPermissionRepository.save(adminPermission);
//        }
//        AdminRole adminRole = new AdminRole();
//        adminRole.setName("角色1");
//        HashSet<AdminPermission> set = new HashSet<>();
//        set.add(adminPermissionRepository.findOne(1L));
//        set.add(adminPermissionRepository.findOne(2L));
//        adminRole.setPermissionSet(set);
//
//        adminRoleRepository.save(adminRole);
//
//        AdminUser user = new AdminUser();
//        user.setUsername("xuejike");
//        user.setPwd(DigestUtils.md5Hex("123456"));
//        user.setAdminRole(adminRole);
//        adminUserRepository.save(user);
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
        return "home";
    }


}
