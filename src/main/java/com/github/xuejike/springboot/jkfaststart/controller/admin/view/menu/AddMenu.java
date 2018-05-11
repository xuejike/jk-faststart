package com.github.xuejike.springboot.jkfaststart.controller.admin.view.menu;

import com.bidanet.springmvc.demo.jkbuilder.annotation.JkButton;
import com.bidanet.springmvc.demo.jkbuilder.annotation.JkDataSource;
import com.bidanet.springmvc.demo.jkbuilder.annotation.JkForm;
import com.bidanet.springmvc.demo.jkbuilder.annotation.JkTitle;
import com.bidanet.springmvc.demo.jkbuilder.annotation.ext.JkSelectFormField;
import com.bidanet.springmvc.demo.jkbuilder.annotation.ext.JkTextAreaFormField;
import com.bidanet.springmvc.demo.jkbuilder.annotation.ext.JkTextFormField;
import com.bidanet.springmvc.demo.jkbuilder.annotation.type.JkButtonType;
import com.bidanet.springmvc.demo.jkbuilder.annotation.type.JkSourceType;
import com.github.xuejike.springboot.jkfaststart.controller.datasource.MenuDataSource;
import com.github.xuejike.springboot.jkfaststart.domain.AdminPermission;
import com.github.xuejike.springboot.jkfaststart.domain.type.PermissionType;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author xuejike
 * @version $Id: AdminPermissi.java, v 0.1 2018-01-10 16:32:23 xuejike Exp $$
 */
@Data
@JkForm(url = "/admin/menu/add",btns = {
        @JkButton(type = JkButtonType.submit,value = "保存")
})
public class AddMenu {
    public Long id;
    @JkSelectFormField
    @JkDataSource(type = JkSourceType.beanClass,beanCls = MenuDataSource.class)
    @JkTitle("父菜单")
    public Long pid;

    @JkTextFormField
    @JkTitle("菜单名称")
    public String name;

    @JkTextAreaFormField
    @JkTitle("菜单描述")
    public String description;

    @JkTextFormField
    @JkTitle("菜单地址")
    public String url;
    @JkTextFormField
    @JkTitle("菜单图标")
    public String icon;


    public String method;
    @JkSelectFormField
    @JkDataSource(type = JkSourceType.enumType)
    @JkTitle("菜单类型")
    public PermissionType type;

    @JkTitle("菜单排序")
    @JkTextFormField
    public Integer sortIndex;




}
