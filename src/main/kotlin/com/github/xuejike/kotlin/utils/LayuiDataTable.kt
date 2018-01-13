package com.github.xuejike.kotlin.utils

data class LayuiDataTableConfig(
        var url:String?=null,
        var width: String?=null,
        var height:String,
        var cellMinWidth:Float=60f,
        var done:String?=null,
        var data:Array<Any>?=null,
        var page:Boolean=false,
        var limit:Int=30,
        var limits:Array<Int>?=null,
        var loading:Boolean=false,
        var text:String?=null,
        var initSort:String?=null,
        var id:String
)
data class LayuiDataTableColConfig(
        var field:String,
        var title:String,
        var width:String?=null,
        var minWidth:String?=null,
        var type:LayuiDataTableType=LayuiDataTableType.normal,
        var LAY_CHECKED:Boolean=false,
        var fixed:LayuiDataTableFixed=LayuiDataTableFixed.left,
        var sort:Boolean=false
)
enum class LayuiDataTableType{
    normal,checkbox,numbers,space
}
enum class LayuiDataTableFixed{
    left,right
}