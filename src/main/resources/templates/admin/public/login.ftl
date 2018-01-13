<!DOCTYPE html>
<html lang="en">
<head>
     <title>登录</title>
    <#include "/head_css_tpl.ftl"/>
</head>
<body>

<div class="login-main">
    <header class="layui-elip">后台登录</header>
    <form class="layui-form" action="login" method="post">
        <div class="layui-input-inline">
            <input type="text" name="username" required
                   lay-verify="required"
                   value="${username!""}"
                   placeholder="用户名" autocomplete="off"
                   class="layui-input">
        </div>
        <div class="layui-input-inline">
            <input type="password" name="pwd" required
                   lay-verify="required" placeholder="密码"
                   autocomplete="off"
                   value="${pwd!""}"
                   class="layui-input">
        </div>
        <div class="layui-inline">
            <span style="color: red">${msg!""}</span>
        </div>
        <div class="layui-input-inline login-btn">
            <button type="submit" class="layui-btn">登录</button>
        </div>
        <hr/>

        <#--<p>-->
            <#--<a href="javascript:;" class="fl">立即注册</a>-->
            <#--<a href="javascript:;" class="fr">忘记密码？</a>-->
        <#--</p>-->
    </form>
</div>
    <#include "/body_js_tpl.ftl"/>

<script type="text/javascript">
    // layui.use(['form'], function () {
    //
    //     // 操作对象
    //     var form = layui.form
    //             , $ = layui.jquery;
    //
    //     // you code ...
    //
    //
    // });
</script>
</body>
</html>