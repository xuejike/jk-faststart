package com.github.xuejike.kotlin.views

import com.bidanet.springmvc.demo.jkbuilder.annotation.*
import com.bidanet.springmvc.demo.jkbuilder.annotation.type.JkButtonType


import com.bidanet.springmvc.demo.jkbuilder.annotation.JkTitle
import com.bidanet.springmvc.demo.jkbuilder.annotation.ext.JkHtmlFormField
import com.bidanet.springmvc.demo.jkbuilder.annotation.ext.JkTextAreaFormField
import com.bidanet.springmvc.demo.jkbuilder.annotation.ext.JkTextFormField
import kotlinx.html.a
import kotlinx.html.h2
import kotlinx.html.stream.createHTML

/**
 *
 * @author xuejike
 * @version $Id: AddSysConf.java, v 0.1 2018-01-13 16:27:24 xuejike Exp $$
 */

@JkTable
@JkDataSource(url = "./data")
class TableSysConfig(){
    @JkColumn(title = "配置名")
    var key: String? = null

    @JkColumn(title = "配置值")
    var `val`: String? = null

    @JkColumn(title = "配置描述")
    var describe: String? = null

    @JkColumn(title = "操作")
    @JkToolBar(btns = [(JkButton(value = "编辑", type = JkButtonType.dialog, url = "./edit?id={id}")), (JkButton(value = "删除", type = JkButtonType.confirm, url = "./del?id={id}", option = "'是否确认删除该配置？'"))])
    var tool: String? =null
        get() {
            return createHTML().a {

            }
        }
}

@JkForm(url = "/admin/config/add_save")
class AddSysConfigKt {

    @JkTitle("配置名")
    @JkTextFormField
     var key: String? = null

    @JkTitle("配置值")
    @JkTextAreaFormField
    var `val`: String? = null

    @JkTitle("配置描述")
    @JkTextAreaFormField
    var describe: String? = null

    @JkHtmlFormField
    var tpl:String? = null
        get() {
            return createHTML().h2 { +"ssss" }
        }

}



