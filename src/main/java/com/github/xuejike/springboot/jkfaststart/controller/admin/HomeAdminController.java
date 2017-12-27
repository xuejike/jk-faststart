package com.github.xuejike.springboot.jkfaststart.controller.admin;

import com.github.xuejike.springboot.jkfaststart.JkConfig;
import lombok.extern.log4j.Log4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 后台主页
 * @author xuejike
 */
@RequestMapping(JkConfig.ADMIN_PATH)
@Controller
@Log4j
public class HomeAdminController {

    @RequestMapping({"/","/index","/home"})
    public void home(){
//        SecurityContextHolder.getContext().getAuthentication()
//        return "index";
    }
    @RequestMapping("/qq")
    public void qq(){

    }
    @RequestMapping(value = "/public/login",method = RequestMethod.GET)
    public void login(){

    }
    @RequestMapping(value = "/public/login-error")
    public String loginError(HttpSession session){
        Exception exception = (Exception) session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");

        log.error("error--",exception);
        return "login";
    }
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String error(Exception ex){

        return "error";
    }
}
