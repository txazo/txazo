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
<%@ include file="../decorator/nav-user.jsp" %>

<div class="container-fluid">
    <ol class="breadcrumb">
        <li class="active">用户列表</li>
    </ol>

    <div class="panel panel-danger">
        <div class="panel-heading">用户列表</div>
        <table class="table table-bordered table-hover table-responsive table-striped">
            <thead>
            <tr>
                <th class="text-center">微信号</th>
                <th class="text-center">姓&nbsp;&nbsp;名</th>
                <th class="text-center">管&nbsp;&nbsp;理</th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${users != null && fn:length(users) > 0}">
                <c:forEach items="${users}" var="u">
                    <tr>
                        <td class="text-center">${u.userName}</td>
                        <td class="text-center">${u.trueName}</td>
                        <td class="text-center">
                            <button type="button" class="btn btn-xs btn-danger"
                                    onclick="window.location.href = '/user/privilege/show?userId=${u.id}'">权限设置
                            </button>
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

