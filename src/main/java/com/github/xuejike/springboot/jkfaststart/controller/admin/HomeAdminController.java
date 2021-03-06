package com.github.xuejike.springboot.jkfaststart.controller.admin;

import com.github.xuejike.springboot.jkfaststart.JkConfig;

import com.github.xuejike.springboot.jkfaststart.common.QueryDslTool;
import com.github.xuejike.springboot.jkfaststart.common.ShiroUtils;
import com.github.xuejike.springboot.jkfaststart.domain.AdminUser;
import com.github.xuejike.springboot.jkfaststart.domain.QAdminUser;
import com.github.xuejike.springboot.jkfaststart.repository.AdminUserRepository;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vip.xuejike.ktpl.AdminJkKtView;

import javax.persistence.EntityManager;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 后台主页
 * @author xuejike
 */
@RequestMapping(JkConfig.ADMIN_PATH)
@Controller
@Slf4j
public class HomeAdminController {
    @Autowired
    QueryDslTool queryDslTool;

    @Autowired
    AdminUserRepository adminUserRepository;
    @RequestMapping({"/","/index","/home"})
    @ResponseBody
    public String home(Model model,String cc){
        Subject subject = SecurityUtils.getSubject();

        String nickName = ShiroUtils.getLoginUser().getNickName();
        model.addAttribute("nickName",nickName);
        AdminJkKtView testView = new AdminJkKtView();


        AdminJkKtView.AdminInfo info = testView.getInfo();
        info.setTitle("必答-账号管理系统");
        info.setWelcomeUrl("./qq");
        info.setUsername(nickName);
        return testView.toHtml();
    }
    @RequestMapping("/qq")
    public void qq(){

    }

    @RequestMapping(value = "/public/login",method = RequestMethod.GET)
    public void login(){

    }
    @RequestMapping(value = "/public/login",method = RequestMethod.POST)
    public void loginPost(@ModelAttribute("username") String username,
                            @ModelAttribute("pwd")String pwd, Model model,
                            ServletRequest request){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, pwd);
        try {
//            WebUtils.getSavedRequest()

            subject.login(token);


        }catch (Exception ex){
            model.addAttribute("msg",ex.getMessage());
//            ex.printStackTrace();
        }


//        JPAQuery jpaQuery = new JPAQuery();


    }
    @RequestMapping(value = "/public/logout")
    public String loginError(HttpSession session){
        SecurityUtils.getSubject().logout();
        return "redirect:/admin/index";
//        Session session1 = SecurityUtils.getSubject().getSession();

//        return "login";
    }
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String error(Exception ex){
        ex.printStackTrace();
        return "error";
    }
}
