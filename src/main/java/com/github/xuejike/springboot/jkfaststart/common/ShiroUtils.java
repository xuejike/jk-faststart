package com.github.xuejike.springboot.jkfaststart.common;

import com.github.xuejike.springboot.jkfaststart.domain.AdminUser;
import org.apache.shiro.SecurityUtils;

public class ShiroUtils {

    public static AdminUser getLoginUser(){
        return ((AdminUser) SecurityUtils.getSubject().getSession().getAttribute("user"));
    }
}
