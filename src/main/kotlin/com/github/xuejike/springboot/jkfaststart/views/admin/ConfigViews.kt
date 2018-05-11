package com.github.xuejike.springboot.jkfaststart.views.admin

import com.bidanet.bdcms.core.vo.Page
import com.github.xuejike.springboot.jkfaststart.domain.SysConfig
import kotlinx.html.BUTTON
import kotlinx.html.InputType
import kotlinx.html.classes
import kotlinx.html.div
import kotlinx.html.dom.createHTMLDocument
import kotlinx.html.stream.createHTML
import vip.xuejike.ktpl.PageJkKtView
import vip.xuejike.ktpl.libs.*

class ConfigListView(var page:Page<SysConfig>,var query:SysConfig?=null): PageJkKtView() {


    override fun content(): String {
            return createHTML().div {
                jkForm{
                    jkFormItem(){
                        jkInput("配置名称",formItem = false,inline = true,bind = query!!::key )
                        jkButton("搜索")
                    }
                }
                jkTable(
                        linkedMapOf(
                                "ID" to JkTableCol(SysConfig::id),
                                "配置名称" to JkTableCol(SysConfig::key),
                                "配置值" to JkTableCol(SysConfig::`val`),
                                "配置描述" to JkTableCol(SysConfig::describe),
                                "操作" to JkTableCol(){
//                                    attributes.put("width","200px")
                                    jkButton("编辑",type=JkButtonType.dialog.name,
                                            url = "/admin/config/edit?id=${it.id}",
                                            option = mapOf("title" to "编辑配置"))
                                }
                        ),dataList = page.list)
                jkPage(page.pageCurrent,page.pageCount)
            }
    }

}
class ConfigEditView(var vo:SysConfig):PageJkKtView(){
    override fun content(): String {

       return createHTML().div {
            jkForm(action = "./editSave"){
                jkInput(formItem = false,bind = vo::id,type = InputType.hidden)
                jkInput(title = "配置名称",bind = vo::key)
                jkInput(title = "配置值",bind = vo::`val`)
                jkInput(title = "配置描述",bind = vo::describe)
                jkFormTitle (){
                    jkButton(title = "保存",type = JkButtonType.ajax_submit.name){

                    }

                }
            }
        }
    }

}

