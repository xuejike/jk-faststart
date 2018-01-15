package com.github.xuejike.springboot.jkfaststart.controller.admin.view.user;

import com.bidanet.springmvc.demo.jkbuilder.annotation.*;
import com.bidanet.springmvc.demo.jkbuilder.annotation.ext.JkSelectFormField;
import com.bidanet.springmvc.demo.jkbuilder.annotation.ext.JkTextFormField;
import com.bidanet.springmvc.demo.jkbuilder.annotation.type.JkButtonType;
import com.bidanet.springmvc.demo.jkbuilder.annotation.type.JkSourceType;
import com.bidanet.springmvc.demo.jkbuilder.annotation.type.JkVerifyType;
import com.github.xuejike.springboot.jkfaststart.controller.datasource.RoleDataSource;
import lombok.Data;

@Data
@JkForm(btns = {
        @JkButton(type = JkButtonType.submit,value = "搜索"),
        @JkButton(type = JkButtonType.reset,value = "清空",cssClass = " layui-btn-primary"),
        @JkButton(value = "新增用户",type = JkButtonType.dialog,url = "/admin/user/add")
})
public class AdminUserHeader {
    @JkTitle("用户名")
    @JkTextFormField
    private String username;

    @JkTitle("昵称")
    @JkTextFormField
    private String nickName;


    @JkTitle("角色")
    @JkSelectFormField
    @JkDataSource(type = JkSourceType.beanClass,beanCls = RoleDataSource.class)
    private Long roleId;

}
