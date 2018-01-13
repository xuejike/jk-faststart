layui.use(["jquery","layer"],function () {
    var $=layui.$;
    var layer=layui.layer;
    layui.$(document).on("click",".jk-btn[lay-filter=doAjax]",function (e) {
        // console.log(e)
        ajaxPost($(e.currentTarget).attr("href"),{});
        e.preventDefault();
    });

    layui.$(document).on("click",".jk-btn[lay-filter=dialog]",function (e) {
        var dom=$(e.currentTarget);
        var width= dom.data("width");
        var height= dom.data("height");
        var title= dom.data("title");
        var area=["800px","500px"];
        if(height){
            area[1]=height+"px";
        }
        if(width){
            area[0]=width+"px";
        }
        var href= dom.attr("href");
        openUrlDialog(href,{
            area:[width,height],
            title:title
        });
        e.preventDefault();
    });
});

layui.use(["jquery","form"],function () {
    var $=layui.$;
    setInputKeUp();
    function setInputKeUp() {

        //搜索
        layui.$(".jk-search-select  .layui-input").on("keyup",function (event) {
            var elBody=layui.$(event.currentTarget).parents(".jk-search-select");
            if((event.keyCode>=48&&event.keyCode<=105)||(event.keyCode==8)){
                var v=$(event.currentTarget).val();
                var opt="";


                var url= elBody.find("select").data("url");
                var beanCls= elBody.find("select").data("bean-cls");
                $.post(url,{key:v,beanCls:beanCls},function (data) {
                    for(var i=0;i<data.length;i++){
                        opt+="<option value='"+data[i].value+"'>"+data[i].name+"</option>"
                    }
                    elBody.find("select").html(opt);
                    layui.form.render();
                    elBody.find(".layui-input").click().focus().val(v);
                    setInputKeUp();
                });

                return;
            }


//            $('input').click().focus().val(val)
        })

        layui.$(".layui-form-select input").on("keyup",function (event) {
            var elBody=layui.$(event.currentTarget).parents(".layui-form-select").parent();
            var selectOpt= elBody.find(".layui-this");
            var code=event.keyCode;
            if(code==13||code==38||code==40){
                //Enter
                if(event.keyCode==13){
                    var val=selectOpt.attr("lay-value");
                    var txt=selectOpt.text();
                    elBody.find("input").val(txt);
//                    console.log("-->"+val+"->"+txt);
                    elBody.find("select").val(val);
                    //关闭
                    elBody.find(".layui-form-select").removeClass("layui-form-selected layui-form-selectup")
                    return;
                }
                var nextSelectOpt;
                var selectDl=elBody.find("dl");
                if(selectOpt.length==0){
                    selectOpt= $(elBody.find("dd")[0]);
                    nextSelectOpt=selectOpt;
                    selectDl.scrollTop(0);
                }else{
                    //up
                    if(event.keyCode==38){
                        nextSelectOpt=selectOpt.prev();
                        if(nextSelectOpt.length==0){
                            nextSelectOpt=selectOpt;
                        }

                    }
                    //down
                    if(event.keyCode==40){
                        nextSelectOpt=selectOpt.next();
                        if(nextSelectOpt.length==0){
                            nextSelectOpt=selectOpt;
                        }
                    }
                }
                selectOpt.removeClass("layui-this");
                nextSelectOpt.addClass("layui-this");


                if(nextSelectOpt.position().top<0){
                    selectDl.scrollTop(selectDl.scrollTop()
                        -selectOpt.height());
                }
                if(nextSelectOpt.position().top>(selectDl.height()-selectOpt.height())){
                    selectDl.scrollTop(selectDl.scrollTop()
                        +selectOpt.height());
                }
            }

        })
    }

    layui.$(".layui-form-checkbox").attr("contenteditable","true");
    layui.$(".layui-form-radio").attr("contenteditable","true");
    layui.$(".layui-form-checkbox").on("keydown",function (event) {
        if(event.keyCode==32){
            $(event.currentTarget).click();
        }
        if(event.keyCode==9){
            return true;
        }
        return false;
    });
    layui.$(".layui-form-radio").on("keydown",function (event) {
        if(event.keyCode==32){
            $(event.currentTarget).click();
        }
        if(event.keyCode==9){
            return true;
        }
        return false;
    });
});

layui.use(['form'], function(){
    var form = layui.form;
    var $ = layui.$;

    //监听提交
    form.on('submit(ajax_submit)', function(data){
        setTimeout(function(){
            ajaxPost(data.form.action,layui.$(data.form).serialize());
        },1);


        return false;
    });
    form.verify({
        regExp:function (value, item) {
            var inputItem=$(item);
            var index=0;
            while(reg=inputItem.data('verify-'+index)){
                if(!new RegExp(reg).test(value)){
                    return inputItem.data('verify-'+index+'-msg');
                }
                index++;
            }
        },
        ajax:function (value, item) {
            var inputItem=$(item);
            var url=inputItem.data("verify-ajax-url");
            var cls=inputItem.data("verify-ajax-cls");
            var msg="";
            $.ajax({ url: url,data:{value:value,beanCls:cls},
                dataType:"json",
                async:false,
                error:function () {
                  msg="网络异常";
                },
                success: function(data){
                    if(data.statusCode!=200){
                        msg=data.message;
                    }
                }
            });
            if(msg!=""){
                return msg;
            }
        }
    })
});