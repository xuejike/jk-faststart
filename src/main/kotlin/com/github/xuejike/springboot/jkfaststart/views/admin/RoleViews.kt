package com.github.xuejike.springboot.jkfaststart.views.admin

import com.github.xuejike.springboot.jkfaststart.domain.AdminPermission
import com.github.xuejike.springboot.jkfaststart.domain.AdminRole
import kotlinx.html.*
import kotlinx.html.stream.createHTML
import vip.xuejike.ktpl.PageJkKtView
import vip.xuejike.ktpl.libs.*

class RoleIndexView(var list:List<AdminRole>) : PageJkKtView() {
    override fun content(): String {
        return createHTML()
                .div {
                    div{
                        jkButton("新增角色",type = JkButtonType.dialog.name,url = "/admin/role/add")
                    }
                    jkTable(linkedMapOf(
                            "ID" to JkTableCol(value = AdminRole::id),
                            "角色名称" to JkTableCol(AdminRole::name),
                            "角色描述" to JkTableCol(AdminRole::info),
                            "操作" to JkTableCol{
                                jkButton("编辑",url = "/admin/role/edit?id=${it.id}",type = JkButtonType.dialog.name)
                                jkButton("删除",url = "/admin/role/del?id=${it.id}"
                                        ,type = JkButtonType.confirm.name,option = mapOf("content" to "确认删除？") ){
                                    val button = this as BUTTON
                                    button.classes+="layui-btn-warm"
                                }
                            }

                    ),list)
                }
    }

}

class RoleEditView(var vo:AdminRole,var menuList:List<AdminPermission>,var edit:Boolean=true) : PageJkKtView() {
    override fun content(): String {
        val permissionSet = vo.permissionSet;
        val haveMap = hashMapOf<Long, AdminPermission>()
        if (edit){
            permissionSet.forEach { haveMap[it.id]=it }
        }

//        var url:String= if (edit) "./editSave" else "./addSave"

        return createHTML().div {
            jkForm(action = "./editSave") {
                jkInput(formItem = false,type = InputType.hidden,bind = vo::id)
                jkInput(title = "角色名称",type = InputType.text,bind = vo::name)
                jkInput(title = "角色描述",type = InputType.text,bind = vo::info)
                jkFormTitle(title = "权限") {
                    jkTable(
                            linkedMapOf("菜单名称" to JkTableCol(AdminPermission::name)
                                    ,"是否拥有权限" to JkTableCol{
                                input(type = InputType.checkBox,name = "have") {
                                    this.value=it.id.toString()
                                    if(edit){
                                        this.checked=haveMap.containsKey(it.id);
                                    }

                                }
                            }
                    ),menuList)
                }

                jkFormItem {
                    jkButton("保存",type = JkButtonType.ajax_submit.name)
                }
            }

        }
    }

}
