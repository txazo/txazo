<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户列表</title>
    <%@ include file="../decorator/head.jsp" %>
</head>
<body>

<!-- navbar -->
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#navbar" aria-expanded="false">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/user/list">用户管理</a>
        </div>
        <div class="collapse navbar-collapse" id="navbar">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/user/list">用户列表</a></li>
                <li><a href="/user/add">添加用户</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="panel panel-info">
        <div class="panel-heading">用户列表</div>
        <table class="table table-bordered table-hover table-responsive table-striped">
            <thead>
            <tr>
                <th class="text-center">姓名</th>
                <th class="text-center">微信号</th>
                <th class="text-center">管理</th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${users != null && fn:length(users) > 0}">
                <c:forEach items="${users}" var="u">
                    <tr>
                        <td class="text-center">${u.trueName}</td>
                        <td class="text-center">${u.userName}</td>
                        <td class="text-center">
                            <a class="btn btn-xs btn-info" href="/user/privilege/show?userId=${u.id}">权限设置</a>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
            </tbody>
        </table>
    </div>
</div>

<%@ include file="../decorator/foot.jsp" %>
</body>
</html>

