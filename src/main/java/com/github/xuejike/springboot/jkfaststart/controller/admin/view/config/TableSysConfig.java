package com.github.xuejike.springboot.jkfaststart.controller.admin.view.config;

import com.bidanet.springmvc.demo.jkbuilder.annotation.*;
import com.bidanet.springmvc.demo.jkbuilder.annotation.ext.JkTextAreaFormField;
import com.bidanet.springmvc.demo.jkbuilder.annotation.ext.JkTextFormField;
import com.bidanet.springmvc.demo.jkbuilder.annotation.type.JkButtonType;
import lombok.Data;
import org.hibernate.annotations.Type;
import lombok.Getter;
import lombok.Setter;
import lombok.Getter;
import com.bidanet.springmvc.demo.jkbuilder.annotation.JkTitle;
import lombok.Setter;

/**
 *
 * @author xuejike
 * @version $Id: AddSysConf.java, v 0.1 2018-01-13 16:27:24 xuejike Exp $$
 */
@Data
@JkTable
@JkDataSource(url = "./data")
public class TableSysConfig {

     @JkColumn(title = "配置名")
    private String key;

     @JkColumn(title = "配置值")
    private String val;

     @JkColumn(title = "配置描述")
    private String describe;
     @JkColumn(title = "操作")
     @JkToolBar(btns = {
             @JkButton(value = "编辑",type = JkButtonType.dialog,url = "./edit?id={id}"),
             @JkButton(value = "删除",type = JkButtonType.confirm,url = "./del?id={id}",option = "'是否确认删除该配置？'")
     })
     private String tool;
}
