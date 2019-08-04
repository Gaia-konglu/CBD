<%--
  Created by IntelliJ IDEA.
  User: 18822
  Date: 2018/7/25
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" href="../css/frontlogin/account_register.css">
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
        $(function () {
            var registerMsg='${registerMsg}';
            if (registerMsg!=''){
                layer.msg(registerMsg);
            }
            $('#frmRegister').bootstrapValidator({
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',//显示验证成功的图标
                    invalid: 'glyphicon glyphicon-remove',//验证失败的图标
                    validating: 'glyphicon glyphicon-refresh'//正在校验的图标
                },
                fields:{
                    name:{
                        validators:{
                            notEmpty:{
                                message:"账号不能为空"
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
                                message: '用户名长度不能小于6位或超过30位'
                            },
                            identical: {
                                field: 'confirmPassword',
                                message: '请输入确认密码'
                            }
                        }
                    },
                    confirmPassword:{
                        validators:{
                            notEmpty:{
                                message:"请输入确认密码"
                            },
                            identical: {
                                field: 'password',
                                message: '两次密码输入不一致'
                            }
                        }
                    },
                    roleId:{
                        validators:{
                            notEmpty:{
                                message:"请选择角色"
                            }
                        }
                    },
                    realName:{
                        validators:{
                            notEmpty:{
                                message:"不能为空"
                            }
                        }
                    },
                    addr:{
                        validators:{
                            notEmpty:{
                                message:"不能为空"
                            }
                        }
                    },
                    phone:{
                        validators:{
                            notEmpty:{
                                message:"不能为空"
                            },
                            regexp: {
                                regexp: /^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\d{8}$/,
                                message: '非手机号码'
                            }
                        }
                    },
                    idCard:{
                        validators:{
                            notEmpty:{
                                message:"不能为空"
                            },
                            regexp:{
                                regexp:/(^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx])|([1−9]\d5\d2((0[1−9])|(10|11|12))(([0−2][1−9])|10|20|30|31)\d2[0−9Xx])/,
                                message:'请输入正确身份证'
                            }
                        }
                    },
                    job:{
                        validators:{
                            notEmpty:{
                                message:"不能为空"
                            }
                        }
                    },
                    email:{
                        validators:{
                            notEmpty:{
                                message:"不能为空"
                            },
                            emailAddress: {
                                message: '邮箱格式不正确'
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
<body class="l_register" style="background: #F7F7F7">
<div class="header">
    <h1><i class="fa fa-database"></i>蜗牛CBD Parking</h1>
</div>
<div class="login_wrapper" style="margin: 0 auto;">
        <div class="animate form login_form" style="left: -2em;">
            <section class="login_content" style="min-width: 480px">
                <form id="frmRegister" action="${pageContext.request.contextPath}/person/register.do" method="post">
                    <h1>已有账号？现在去/<a href="${pageContext.request.contextPath}/jsp/frontLogin.jsp">登录</a></h1>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">用户名：</label>
                        <div class="col-sm-9">
                            <input value="${personVo.name}" name="name" class="form-control" type="text" placeholder="请输入用户名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
                        <div class="col-sm-9">
                            <input name="password" class="form-control" type="password" placeholder="请输入密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">确认密码：</label>
                        <div class="col-sm-9">
                            <input name="confirmPassword" class="form-control" type="password" placeholder="请确认密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">角色：</label>
                        <div class="col-sm-9">
                            <select class="form-control" name="roleId" style="height: 34px;">
                                <option value="">--请选择角色--</option>
                                <option value="1">包租婆</option>
                                <option value="2">抢租客</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">真实姓名：</label>
                        <div class="col-sm-9">
                            <input value="${personVo.realName}" name="realName" class="form-control" type="text" placeholder="请输入真实姓名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">地址：</label>
                        <div class="col-sm-9">
                            <input value="${personVo.addr}" name="addr" class="form-control" type="text" placeholder="请输入地址">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">电话：</label>
                        <div class="col-sm-9">
                            <input value="${personVo.phone}" name="phone" class="form-control" type="text" placeholder="请输入电话">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">身份证：</label>
                        <div class="col-sm-9">
                            <input value="${personVo.idCard}" name="idCard" class="form-control" type="text" placeholder="请输入身份证">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">工作：</label>
                        <div class="col-sm-9">
                            <input value="${personVo.job}" name="job" class="form-control" type="text" placeholder="请输入工作">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">邮箱：</label>
                        <div class="col-sm-9">
                            <input value="${personVo.email}" name="email" class="form-control" type="text" placeholder="请输入邮箱">
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
                            <button type="submit" class="btn btn-primary btn-block">注&nbsp;&nbsp;册</button>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                    <div class="separator">
                        <div>
                            <h1><i class="fa fa-database"></i><span style="margin-left: 10px">蜗牛CDB Parking Welcome to Join</span></h1>
                            <p>©2016 All Rights Reserved. Gentelella Alela! is a Bootstrap 3 template. Privacy and
                                Terms</p>
                        </div>
                    </div>
                </form>
            </section>
        </div>
    </div>
    
    
    <script>
        function reloadImage() {
            $('#codeImage').attr('src','${pageContext.request.contextPath}/code/getImage.do?time='+new Date().getTime());
            $('#code').val('');
        }
        
    </script>
</body>
</html>
