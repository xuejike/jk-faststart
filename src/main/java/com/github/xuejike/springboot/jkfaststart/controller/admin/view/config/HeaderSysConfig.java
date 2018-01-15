package com.github.xuejike.springboot.jkfaststart.controller.admin.view.config;

import com.bidanet.springmvc.demo.jkbuilder.annotation.JkButton;
import com.bidanet.springmvc.demo.jkbuilder.annotation.JkForm;
import com.bidanet.springmvc.demo.jkbuilder.annotation.JkTitle;
import com.bidanet.springmvc.demo.jkbuilder.annotation.ext.JkTextFormField;
import com.bidanet.springmvc.demo.jkbuilder.annotation.type.JkButtonType;
import lombok.Data;

@JkForm(btns = {
        @JkButton(value = "搜索",type = JkButtonType.submit),
        @JkButton(value = "清空",type = JkButtonType.reset),
        @JkButton(value = "新增",type = JkButtonType.dialog,url = "/admin/config/add")
})
@Data
public class HeaderSysConfig {
    @JkTitle("配置名称")
    @JkTextFormField
    private String key;
    @JkTitle("配置描述")
    @JkTextFormField
    private String describe;
}
