package com.github.xuejike.springboot.jkfaststart.controller.admin;

import com.github.xuejike.springboot.jkfaststart.JkConfig;
import com.github.xuejike.springboot.jkfaststart.domain.QAdminPermission;
import com.github.xuejike.springboot.jkfaststart.domain.QAdminUser;
import com.mysema.query.jpa.impl.JPAQuery;
import lombok.extern.log4j.Log4j;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

/**
 * 后台主页
 * @author xuejike
 */
@RequestMapping(JkConfig.ADMIN_PATH)
@Controller
@Log4j
public class HomeAdminController {
    @Autowired
    EntityManager entityManager;

    @RequestMapping({"/","/index","/home"})
    public void home(){
        QAdminUser adminUser = QAdminUser.adminUser;
        JPAQuery jpaQuery = new JPAQuery(entityManager);
        jpaQuery.from(adminUser)
                .where(adminUser.nickName.like("sss")
                        .and(adminUser.roleId.eq(1L))
                        .or(adminUser.delete.eq(false)));

    }
    @RequestMapping("/kk")
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
        JPAQuery jpaQuery = new JPAQuery();


    }
    @RequestMapping(value = "/public/logout")
    public void loginError(HttpSession session){
        SecurityUtils.getSubject().logout();
        Session session1 = SecurityUtils.getSubject().getSession();

//        return "login";
    }
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String error(Exception ex){
        ex.printStackTrace();
        return "error";
    }
}
