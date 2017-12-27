package com.github.xuejike.springboot.jkfaststart.controller.admin;

import com.github.xuejike.springboot.jkfaststart.JkConfig;
import lombok.extern.log4j.Log4j;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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

    }
    @RequestMapping("/qq")
    public void qq(){

    }
    @RequestMapping(value = "/public/login",method = RequestMethod.GET)
    public void login(){

    }
    @RequestMapping(value = "/public/login",method = RequestMethod.POST)
    public void loginPost(String username,String pwd){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, pwd);
        subject.login(token);

    }
    @RequestMapping(value = "/public/logout")
    public void loginError(HttpSession session){
//        SecurityUtils.getSubject().logout();

//        return "login";
    }
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String error(Exception ex){
        ex.printStackTrace();
        return "error";
    }
}
