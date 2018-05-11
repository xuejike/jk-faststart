package com.github.xuejike.springboot.jkfaststart.views.admin

import com.bidanet.springmvc.demo.jkbuilder.data.JkNameValueData
import com.bidanet.springmvc.demo.jkbuilder.data.JkNameValueDataImpl
import com.github.xuejike.springboot.jkfaststart.controller.admin.view.menu.AddMenu
import com.github.xuejike.springboot.jkfaststart.domain.AdminPermission
import kotlinx.html.*
import kotlinx.html.stream.createHTML
import vip.xuejike.ktpl.PageJkKtView
import vip.xuejike.ktpl.libs.*

class MenuIndex (var page:List<AdminPermission>): PageJkKtView() {
    override fun content(): String {

        return createHTML().div {
            jkButton("刷新"){
                val button = this as BUTTON
                button.onClick="window.location.reload()";
            }
            jkButton("新增菜单",
                    type = JkButtonType.dialog.name,url = "./menu/add")
            jkTable(linkedMapOf(
                    "菜单名称" to JkTableCol(value =AdminPermission::getName),
                    "菜单描述" to JkTableCol(AdminPermission::getDescription),
                    "菜单地址" to JkTableCol(AdminPermission::getUrl),
                    "菜单图标" to JkTableCol(AdminPermission::getIcon),
                    "操作" to JkTableCol(){
                        jkButton(title = "编辑",type = JkButtonType.dialog.name
                                ,url = "./menu/edit?id=${it.id}")
                        jkButton(title = "删除",url = "/admin/menu/del?id=${it.id}",type = JkButtonType.doAjax.name){
                            var btn=this as BUTTON
                            btn.classes+="layui-btn-danger"
                        }
                    }
            ),dataList = page)
        }
    }

}

class MenuEdit(var vo:AddMenu,var parentList: List<JkNameValueData>):PageJkKtView(){
    override fun content(): String {
       return createHTML().div {
            jkForm(action = "./edit_save"){
                jkInput (type = InputType.hidden,bind = vo::id)
                jkSelect("父菜单",bind = vo::pid,dataList =parentList )
                jkInput ("菜单名称",bind = vo::name)
                jkTextArea ("菜单描述",bind = vo::description)
                jkInput ("菜单地址",bind = vo::url)
                jkInput ("菜单图标",bind = vo::icon)
                jkSelect ("菜单类型",bind = vo::type,
                        dataList = listOf(
                                JkNameValueDataImpl("菜单","menu"),
                                JkNameValueDataImpl("按钮","button")))
                jkInput ("菜单排序",bind = vo::sortIndex)
                jkFormTitle {
                    jkButton("保存",type = JkButtonType.ajax_submit.name)
                }
            }
        }
    }

}