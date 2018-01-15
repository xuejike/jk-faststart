package com.github.xuejike.springboot.jkfaststart.controller.admin.view.config;

import com.bidanet.springmvc.demo.jkbuilder.annotation.JkForm;
import com.bidanet.springmvc.demo.jkbuilder.annotation.ext.JkTextAreaFormField;
import com.bidanet.springmvc.demo.jkbuilder.annotation.ext.JkTextFormField;
import lombok.Data;
import org.hibernate.annotations.Type;
import lombok.Getter;
import com.bidanet.springmvc.demo.jkbuilder.annotation.JkTitle;
import lombok.Setter;

/**
 *
 * @author xuejike
 * @version $Id: SysConf.java, v 0.1 2018-01-13 16:19:59 xuejike Exp $$
 */
@Data
@JkForm(url = "/admin/config/add_save")
public class AddSysConfig {

    @JkTitle("配置名")
    @JkTextFormField
    private String key;

    @JkTitle("配置值")
    @JkTextAreaFormField
    private String val;

    @JkTitle("配置描述")
    @JkTextAreaFormField
    private String describe;

}
