package com.github.xuejike.springboot.jkfaststart.controller.admin;

import com.bidanet.bdcms.core.bean.AjaxCallBack;
import com.bidanet.springmvc.demo.jkbuilder.JkTableBuilder;
import com.github.xuejike.springboot.jkfaststart.JkConfig;
import com.github.xuejike.springboot.jkfaststart.controller.admin.view.role.TableRole;
import com.github.xuejike.springboot.jkfaststart.domain.AdminPermission;
import com.github.xuejike.springboot.jkfaststart.domain.AdminRole;
import com.github.xuejike.springboot.jkfaststart.service.AdminPermissionService;
import com.github.xuejike.springboot.jkfaststart.service.AdminRoleService;
import com.github.xuejike.springboot.jkfaststart.views.admin.RoleEditView;
import com.github.xuejike.springboot.jkfaststart.views.admin.RoleIndexView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@RequestMapping(JkConfig.ADMIN_PATH+"/role")
@Controller()
public class RoleController {
    @Autowired
    AdminRoleService adminRoleService;

    @Autowired
    AdminPermissionService adminPermissionService;

    @RequestMapping("/index")
    @ResponseBody
    public String index(Model model){
        List<AdminRole> list = adminRoleService.getList();

//        return JkTableBuilder.create(TableRole.class).build(model);
        return new RoleIndexView(list).toHtml();
    }

    @RequestMapping("/edit")
    @ResponseBody
    public String edit(Long id){
        AdminRole adminRole = adminRoleService.get(id);
        adminRole.getPermissionSet();
        List<AdminPermission> listShow = adminPermissionService.listShow();
        return new RoleEditView(adminRole,listShow,true).toHtml();
    }
    @RequestMapping("/editSave")
    @ResponseBody
    public AjaxCallBack editSave(AdminRole role,Long[] have){
        adminRoleService.addSave(role, have);
        return AjaxCallBack.saveSuccess();
    }
    @RequestMapping("/add")
    @ResponseBody
    public String add(){
        List<AdminPermission> listShow = adminPermissionService.listShow();
        return new RoleEditView(new AdminRole(),listShow,false).toHtml();
    }
}
