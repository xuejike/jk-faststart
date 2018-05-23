package com.github.xuejike.springboot.jkfaststart.controller.admin;

import com.bidanet.bdcms.core.bean.AjaxCallBack;
import com.bidanet.bdcms.core.vo.Page;
import com.bidanet.springmvc.demo.jkbuilder.JkFormBuilder;
import com.bidanet.springmvc.demo.jkbuilder.JkTableBuilder;
import com.github.xuejike.springboot.jkfaststart.JkConfig;
import com.github.xuejike.springboot.jkfaststart.common.AjaxPage;
import com.github.xuejike.springboot.jkfaststart.controller.admin.view.user.*;
import com.github.xuejike.springboot.jkfaststart.domain.AdminUser;
import com.github.xuejike.springboot.jkfaststart.service.AdminUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping(JkConfig.ADMIN_PATH+"/user")
public class AdminUserController {

    @Autowired
    AdminUserService adminUserService;

    @RequestMapping("/index")
    public String index(Model model){

        return JkTableBuilder.create(AdminUserTable.class)
                .addHeaderTool(new AdminUserHeader()).build(model);
    }

    @RequestMapping("/add")
    public String add(AddAdminUser addAdminUser,Model model){

        return JkFormBuilder.create(addAdminUser).build(model);
    }

    @RequestMapping("add_save")
    @ResponseBody
    public AjaxCallBack addSave(AddAdminUser addAdminUser,UpdateAdminUser updateAdminUser){
        adminUserService.saveUser(addAdminUser,updateAdminUser);
        return AjaxCallBack.saveSuccess();
    }

    @RequestMapping("/edit")

    public String edit(Long id,Model model){
        AdminUser user = adminUserService.get(id);
        AddAdminUser addAdminUser = new AddAdminUser();
        UpdateAdminUser updateAdminUser = new UpdateAdminUser();
        BeanUtils.copyProperties(user,addAdminUser);
        BeanUtils.copyProperties(user,updateAdminUser);
        return JkFormBuilder.create(addAdminUser)
                .addForm(updateAdminUser).build(model);
    }
    @RequestMapping("/data")
    @ResponseBody
    public AjaxPage<AdminUserTable> data(AdminUser adminUser, Page<AdminUser> page){
        adminUserService.eqPage(adminUser,page);
        Page<AdminUserTable> tablePage = new Page<>();
        tablePage.setList(new ArrayList<>());
        tablePage.setTotal(page.getTotal());
        tablePage.setPageSize(page.getPageSize());
        tablePage.setPageCurrent(page.getPageCurrent());

        for (AdminUser user : page.getList()) {
            AdminUserTable userTable = AdminUserTableConverter.convertToAdminUserTable(user);
            tablePage.getList().add(userTable);
        }

        return AjaxPage.success(tablePage);

    }

}
