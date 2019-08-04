<%--
  Created by IntelliJ IDEA.
  User: 18822
  Date: 2018/10/11
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
包租婆/抢租客${sessionScope.personBean.name},来到坑<br/>
后台人员${sessionScope.backStageBean.num},来到坑<br/>
企业用户${sessionScope.companyBean.admin},来到坑
</body>
</html>
