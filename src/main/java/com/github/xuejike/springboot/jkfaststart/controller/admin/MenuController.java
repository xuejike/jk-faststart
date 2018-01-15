package com.github.xuejike.springboot.jkfaststart.controller.admin;

import com.bidanet.bdcms.core.bean.AjaxCallBack;
import com.bidanet.bdcms.core.bean.ApiResult;
import com.bidanet.bdcms.core.vo.Page;
import com.bidanet.springmvc.demo.jkbuilder.JkFormBuilder;
import com.bidanet.springmvc.demo.jkbuilder.JkTableBuilder;
import com.github.xuejike.kotlin.views.MenuKt;
import com.github.xuejike.springboot.jkfaststart.JkConfig;
import com.github.xuejike.springboot.jkfaststart.common.AjaxPage;
import com.github.xuejike.springboot.jkfaststart.controller.admin.view.menu.AddMenu;
import com.github.xuejike.springboot.jkfaststart.controller.admin.view.menu.HeaderMenu;
import com.github.xuejike.springboot.jkfaststart.controller.admin.view.menu.TableMenu;
import com.github.xuejike.springboot.jkfaststart.controller.admin.view.menu.UpdateMenu;
import com.github.xuejike.springboot.jkfaststart.domain.AdminPermission;
import com.github.xuejike.springboot.jkfaststart.service.AdminPermissionService;
import com.github.xuejike.springboot.jkfaststart.vo.Menu;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(JkConfig.ADMIN_PATH +"/menu")
public class MenuController {
    @Autowired
    AdminPermissionService adminPermissionService;
    @RequestMapping("/left-menu")
    @ResponseBody
    public ApiResult<List<Menu>> leftMenu(Long pid){
//        new LayuiDataTableConfig();
        return ApiResult.success(adminPermissionService.getSubMenu(pid));
    }

    @RequestMapping("/index")
    public String index(Model model){
        String table = MenuKt.table();
        model.addAttribute("content",table);
        return JkTableBuilder.create(TableMenu.class).addHeaderTool(new HeaderMenu()).build(model);
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(AddMenu addMenu, Model model){
        return JkFormBuilder.create(addMenu).build(model);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public AjaxCallBack addSave(AddMenu addAdminPermission, Model model){
        AdminPermission save=new AdminPermission();
        BeanUtils.copyProperties(addAdminPermission,save);
        adminPermissionService.save(save);
        return AjaxCallBack.saveSuccess();
    }

    @RequestMapping("/edit")
    public String edit(Long id,Model model){
        AdminPermission adminPermission = adminPermissionService.get(id);
        AddMenu addMenu = new AddMenu();
        BeanUtils.copyProperties(adminPermission,addMenu);
        return JkFormBuilder.create(addMenu)
                .addForm(new UpdateMenu(adminPermission.getId())).setActionUrl("./edit_save").build(model);
    }
    @RequestMapping("/edit_save")
    @ResponseBody
    public AjaxCallBack editSave(Long id,AddMenu addMenu){

        adminPermissionService.update(id,addMenu);
        return AjaxCallBack.saveSuccess();
    }

    @RequestMapping("/top-menu")
    @ResponseBody
    public ApiResult<List<Menu>> topMenu(){
        return ApiResult.success(adminPermissionService.getRootMenuTree());
    }
    @RequestMapping("/data")
    @ResponseBody
    public AjaxPage<AdminPermission> data(AdminPermission query, Page<AdminPermission> page){


        List<AdminPermission> list = adminPermissionService.listShow();
        page.setList(list);

        return AjaxPage.success(page);
    }
}
