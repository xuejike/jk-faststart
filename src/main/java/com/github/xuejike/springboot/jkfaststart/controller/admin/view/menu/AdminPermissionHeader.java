package com.github.xuejike.springboot.jkfaststart.controller.admin.view.menu;

import com.bidanet.springmvc.demo.jkbuilder.annotation.JkButton;
import com.bidanet.springmvc.demo.jkbuilder.annotation.JkForm;
import com.bidanet.springmvc.demo.jkbuilder.annotation.JkTitle;
import com.bidanet.springmvc.demo.jkbuilder.annotation.ext.JkTextFormField;
import com.bidanet.springmvc.demo.jkbuilder.annotation.type.JkButtonType;
import lombok.Data;

@Data
@JkForm(btns = {
        @JkButton(type = JkButtonType.submit,value = "搜索"),
        @JkButton(value = "新增菜单",type = JkButtonType.dialog,url = "/admin/menu/add")
})
public class AdminPermissionHeader {
//    @JkTitle("菜单名称")
//    @JkTextFormField
//    private String name;
//    @JkTitle("菜单地址")
//    @JkTextFormField
//    private String url;
}
