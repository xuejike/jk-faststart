package com.github.xuejike.springboot.jkfaststart.common;

import com.github.xuejike.springboot.jkfaststart.domain.AdminPermission;
import com.github.xuejike.springboot.jkfaststart.domain.AdminUser;
import org.apache.shiro.SecurityUtils;

import java.util.List;

public class ShiroUtils {

    public static String userKey = "user";
    public static String permissionKey="permission";

    public static AdminUser getLoginUser(){
        return ((AdminUser) SecurityUtils.getSubject().getSession().getAttribute(userKey));
    }
    public static List<AdminPermission> getAllPermission(){
        return ((List<AdminPermission>) SecurityUtils.getSubject()
                .getSession().getAttribute(permissionKey));
    }
}
