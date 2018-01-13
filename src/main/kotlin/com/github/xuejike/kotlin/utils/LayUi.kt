package com.github.xuejike.kotlin.utils

import com.alibaba.fastjson.JSON
import kotlinx.html.*


fun FlowContent.layuiDataTable(config:LayuiDataTableConfig,block : TABLE.() -> Unit = {}){

    table {
        classes+="layui-table"
        attributes["lay-data"]=JSON.toJSONString(config)
        block(this)
    }
}
fun TABLE.ajaxUrl(block : TABLE.() -> Unit = {}){
    this.classes+=" sss";

}
fun FlowContent.loadLayuiTable(block : FlowContent.() -> Unit = {}){
    script {
        unsafe {
            +"""
                layui.use(["table"],function(){

                })
            """.trimIndent()
        }
    }
}
/**
 * Form表单的Item
 */
fun FlowContent.formItem(title:String="",block : FlowContent.() -> Unit = {}){
    div {
        this.classes.plus("layui-form-item")
        if (title !=""){
            label {
                this.classes= setOf("layui-form-label")
                +title
            }
        }
        block(this)

    }
}

/**
 * Input的包裹Div
 */
fun FlowContent.InputDiv(inline:Boolean=false,block: FlowContent.() -> Unit={}){
    div {
        if (inline){
            this.classes= setOf("layui-input-inline")
        }else{
            this.classes= setOf("layui-input-block")
        }
        block(this)
    }
}