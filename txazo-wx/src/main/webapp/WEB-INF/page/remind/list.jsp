<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>事项列表</title>
    <%@ include file="../decorator/head.jsp" %>
</head>
<body>
<%@ include file="../decorator/nav-remind.jsp" %>

<div class="container-fluid">
    <ol class="breadcrumb">
        <li class="active">事项列表</li>
    </ol>

    <div class="panel panel-danger">
        <div class="panel-heading">事项列表</div>
        <table class="table table-bordered table-hover table-responsive table-striped">
            <thead>
            <tr>
                <th class="text-center">类型</th>
                <th class="text-center">表达式</th>
                <th class="text-center">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${reminds != null && fn:length(reminds) > 0}">
                <c:forEach items="${reminds}" var="r">
                    <tr>
                        <td class="text-center">${r.typeString}</td>
                        <td class="text-center">${r.ext.cronExpression}</td>
                        <td class="text-center">
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

