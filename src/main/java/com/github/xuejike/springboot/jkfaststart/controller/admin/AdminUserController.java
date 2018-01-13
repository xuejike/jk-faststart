package com.github.xuejike.springboot.jkfaststart.controller.admin;

import com.bidanet.springmvc.demo.jkbuilder.JkTableBuilder;
import com.github.xuejike.springboot.jkfaststart.JkConfig;
import com.github.xuejike.springboot.jkfaststart.controller.admin.view.user.AdminUserTable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(JkConfig.ADMIN_PATH+"/user")
public class AdminUserController {
    @RequestMapping("/index")
    public String index(Model model){

        return JkTableBuilder.create(AdminUserTable.class).build(model);
    }
}
