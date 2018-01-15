package com.github.xuejike.springboot.jkfaststart.controller.admin.view.menu;

import com.bidanet.springmvc.demo.jkbuilder.annotation.*;
import com.bidanet.springmvc.demo.jkbuilder.annotation.ext.JkTextAreaFormField;
import com.bidanet.springmvc.demo.jkbuilder.annotation.ext.JkTextFormField;
import com.bidanet.springmvc.demo.jkbuilder.annotation.type.JkButtonType;
import com.bidanet.springmvc.demo.jkbuilder.annotation.type.JkSourceType;
import com.github.xuejike.springboot.jkfaststart.domain.type.PermissionType;
import lombok.Data;

/**
 *
 * @author xuejike
 * @version $Id: AdminPermissi.java, v 0.1 2018-01-10 16:32:23 xuejike Exp $$
 */
@Data
@JkTable
@JkDataSource(url = "/admin/menu/data")
public class TableMenu {

    @JkColumn(title = "菜单名称")
    private String name;

    @JkColumn(title = "菜单描述")
    private String description;

    @JkColumn(title = "菜单地址")
    private String url;

    @JkColumn(title = "菜单图标")
    private String icon;

  
    private String method;

    @JkTitle("菜单类型")
    private PermissionType type;

    @JkTitle("菜单排序")
    private Integer sortIndex;

    @JkColumn(title = "操作")
    @JkToolBar(btns = {
            @JkButton(value = "编辑",type = JkButtonType.dialog,
                    url = "/admin/menu/edit?id={id}"),
            @JkButton(value = "删除",type = JkButtonType.confirm,url = "./del?id={id}",option = "")
    })
    private String tool;



}
