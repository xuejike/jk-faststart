package com.github.xuejike.springboot.jkfaststart.controller.admin;

import com.bidanet.springmvc.demo.jkbuilder.JkTableBuilder;
import com.github.xuejike.springboot.jkfaststart.controller.admin.view.role.TableRole;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/role")
@Controller()
public class RoleController {
    @RequestMapping("/index")
    public String index(Model model){
        return JkTableBuilder.create(TableRole.class).build(model);
    }
}
