package com.github.xuejike.kotlin.views

import com.github.xuejike.kotlin.utils.LayuiDataTableConfig
import com.github.xuejike.kotlin.utils.layuiDataTable
import com.github.xuejike.kotlin.utils.loadLayuiTable
import kotlinx.html.*
import kotlinx.html.stream.createHTML

fun table():String{
    return createHTML().div {
        layuiDataTable(LayuiDataTableConfig(
                id = "ss",
                height = "100"
        )){
            tr {
                td { +"ss" }
            }
        }
        loadLayuiTable {  }
    }.toString()
}