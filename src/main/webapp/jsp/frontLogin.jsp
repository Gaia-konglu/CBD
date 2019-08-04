<%--
  Created by IntelliJ IDEA.
  User: 18822
  Date: 2018/10/15
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="../css/frontlogin/main.css">
    <link rel="stylesheet" type="text/css" href="../css/frontlogin/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="../css/frontlogin/bootstrapValidator.min.css">
    <link rel="stylesheet" type="text/css" href="../css/frontlogin/bootstrap.min.css">
    <script src="../js/jquery.1.9.1.js"></script>
    <script src="../js/frontlogin/bootstrapValidator.min.js"></script>
    <script src="../js/frontlogin/layer/layer.js"></script>

    <title>CBDParking Front</title>
    <script>
        $(function () {
            var loginError='${loginError}';
            if (loginError!=''){
                layer.msg(loginError);
            };
            $('#frmLogin').bootstrapValidator({
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',//显示验证成功的图标
                    invalid: 'glyphicon glyphicon-remove',//验证失败的图标
                    validating: 'glyphicon glyphicon-refresh'//正在校验的图标
                },
                fields:{
                    name:{
                        validators:{
                            notEmpty:{
                                message:"用户名不能为空"
                            },
                            regexp: {
                                regexp: /^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\d{8}$/,
                                message: '非手机号码'
                            }
                        }
                    },
                    password:{
                        validators:{
                            notEmpty:{
                                message:"密码不能为空"
                            },
                            stringLength: {
                                min: 6,
                                max: 30,
                                message: '密码错误！！！'
                            }
                        }
                    },
                    verificationCode:{
                        validators:{
                            notEmpty:{
                                message:"验证码不能为空"
                            },
                            remote:{
                                url:'${pageContext.request.contextPath}/sms/checkVerificationCode.do',
                                message:"验证码不正确"
                            }
                        }
                    },
                    roleId:{
                        validators:{
                            notEmpty:{
                                message:"未选择登陆角色"
                            }
                        }
                    }
                }

            });
        });
        function getVerificationCode(btn) {
            $.post(
                '${pageContext.request.contextPath}/sms/sendVerificationCode.do',
                {'phone':$('#phone').val(),"roleId":$('#loginRoleId').val()},
                function (data) {
                    var obj=data;
                    if (obj.status==1){
                        var time=60;
                        var timer=setInterval(function () {
                            if (time>0){
                                $(btn).attr('disabled',true);
                                $(btn).html('重新发送('+time+')');
                                time--;
                            }
                            else {
                                $(btn).attr('disabled',false);
                                $(btn).html('重新发送');
                               window.location.href = "/CBDParkingManagementSystem/sessionColse.do";
                                clearInterval(timer);//停止计时器
                            }
                        },1000)
                    }
                    else {
                        layer.msg(obj.message);
                    }
                }
            )
        }
    </script>

</head>
<body>
<section class="material-half-bg">
    <div class="cover"></div>
</section>
<section class="login-content">
    <div class="logo" style="margin-bottom: 10px;">
        <h1 style="font-size: 35px;">蜗牛CBDParking欢迎您</h1>
    </div>
    <div class="login-box" style="width: 400px;height: 500px;">
        <form id="frmLogin" action="${pageContext.request.contextPath}/person/login.do" class="login-form" style="padding: 20px;" method="post">
            <h3 class="login-head"><i class="fa fa-lg fa-fw fa-user"></i>用户登陆</h3>
            <div class="form-group">
                <label class="control-label">用户名</label>
                <input id="phone" class="form-control" type="text" placeholder="请输入手机号" autofocus name="name">
            </div>
            <div class="form-group">
                <label class="control-label">密码</label>
                <input class="form-control" type="password" placeholder="请输入密码" name="password">
            </div>
            <div class="form-group">
                <select class="form-control" id="loginRoleId" name="roleId" style="height: 34px;">
                    <option value="1">--请选择登陆角色--</option>
                    <option value="1">包租婆/抢租客</option>
                    <option value="2">企业用户</option>
                </select>
            </div>
            <div class="form-group">
                <label class="control-label">验证码</label>
                <input id="verificationCode" name="verificationCode" class="form-control" type="text" placeholder="请输入验证码">
                <button onclick="getVerificationCode(this)" style="margin-top: 1.5em" class="btn btn-primary btn-block" type="button">获取验证码</button>
            </div>
            <div class="form-group btn-container" style="font-size: 18px;">
                <button class="btn btn-primary btn-block" type="submit"><i class="fa fa-sign-in fa-lg fa-fw"></i>登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;陆</button>
            </div>
            <div class="form-group" style="margin-bottom: 0;margin-top: 10px;float: right;">
                <div class="utility">
                    <p class="semibold-text mb-2"><a href="${pageContext.request.contextPath}/jsp/register.jsp">Welcome 注册!!!</a></p>
                </div>
            </div>
        </form>
    </div>
</section>
</body>
</html>
