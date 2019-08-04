<%--
  Created by IntelliJ IDEA.
  User: 18822
  Date: 2018/10/11
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>CBD Parking Backend</title>

    <link href="../css/backendlogin/bootstrap.min.css" rel="stylesheet">
    <link href="../css/backendlogin/font-awesome.min.css" rel="stylesheet">
    <link href="../css/backendlogin/nprogress.css" rel="stylesheet">
    <link href="../css/backendlogin/animate.min.css" rel="stylesheet">
    <link href="../css/backendlogin/custom.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../css/frontlogin/bootstrapValidator.min.css">
    <link rel="stylesheet" type="text/css" href="../css/frontlogin/bootstrap.min.css">
    <script src="../js/jquery.1.9.1.js"></script>
    <script src="../js/frontlogin/bootstrapValidator.min.js"></script>
    <script src="../js/frontlogin/layer/layer.js"></script>
    <script>
        function reloadImage() {
            $('#codeImage').attr('src','${pageContext.request.contextPath}/code/getImage.do?time='+new Date().getTime());
            $('#code').val('');
        }
        $(function () {
            var loginError='${loginError}';
            if (loginError!=''){
                layer.msg(loginError)
            };
            $('#frmLogin').bootstrapValidator({
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',//显示验证成功的图标
                    invalid: 'glyphicon glyphicon-remove',//验证失败的图标
                    validating: 'glyphicon glyphicon-refresh'//正在校验的图标
                },
                fields:{
                    num:{
                        validators:{
                            notEmpty:{
                                message:"账号不能为空"
                            }
                        }
                    },
                    pass:{
                        validators:{
                            notEmpty:{
                                message:"密码不能为空"
                            }
                        }
                    },
                    code:{
                        validators:{
                            notEmpty:{
                                message:"验证码不能为空"
                            },
                            remote:{
                                url:'${pageContext.request.contextPath}/code/checkCode.do',
                                message:"验证码错误"
                            }
                        }
                    }
                }
            })
        })
    </script>
</head>

<body class="login">
    <div class="login_wrapper">
        <div class="animate form login_form" style="left: -2em;">
            <section class="login_content" style="min-width: 480px">
                <form id="frmLogin" action="${pageContext.request.contextPath}/backStage/login.do" method="post">
                    <h1>后台登陆</h1>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">用户名：</label>
                        <div class="col-sm-9">
                            <input name="num" class="form-control" type="text" placeholder="请输入用户名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
                        <div class="col-sm-9">
                            <input name="pass" class="form-control" type="password" placeholder="请输入密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">验证码：</label>
                        <div class="col-sm-4">
                            <input name="code" id="code" class="form-control" type="text" placeholder="验证码">
                        </div>
                        <div class="col-sm-2">
                            <!-- 验证码 -->
                            <img id="codeImage" class="img-rounded" src="${pageContext.request.contextPath}/code/getImage.do" style="height: 32px; width: 70px;">
                        </div>
                        <div class="col-sm-2">
                            <button type="button" class="btn btn-link" onclick="reloadImage()">看不清</button>
                        </div>
                    </div>

                    <div class="col-sm-9 padding-left-0">
                        <div class="col-sm-4">
                            <button type="submit" class="btn btn-primary btn-block">登&nbsp;&nbsp;陆</button>
                        </div>
                        <div class="col-sm-4">
                            <button type="reset" class="btn btn-primary btn-block">重&nbsp;&nbsp;置</button>
                        </div>
                       
                    </div>
                    <div class="clearfix"></div>
                    <div class="separator">
                        <div>
                            <h1><i class="fa fa-database"></i><span style="margin-left: 10px">蜗牛CDB Parking Backend</span></h1>
                            <p>©2016 All Rights Reserved. Gentelella Alela! is a Bootstrap 3 template. Privacy and
                                Terms</p>
                        </div>
                    </div>
                </form>
            </section>
            
        </div>
    </div>
</body>
</html>
