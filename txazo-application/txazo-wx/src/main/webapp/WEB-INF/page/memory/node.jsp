<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${title}</title>
    <!-- Bootstrap -->
    <link href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/bootstrap-custom.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
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
            <a class="navbar-brand" href="/memory/home.wx">Technology</a>
        </div>
        <div class="collapse navbar-collapse" id="navbar">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/memory/home.wx">Home</a></li>
                <li><a href="/memory/editNode.wx?id=${memory.id}">Edit</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <ol class="breadcrumb">
        <c:forEach items="${titles}" var="t" varStatus="stat">
            <c:if test="${stat.last}">
                <li class="active">${t.name}</li>
            </c:if>
            <c:if test="${!stat.last}">
                <li><a href="/memory/show.wx?id=${t.id}">${t.name}</a></li>
            </c:if>
        </c:forEach>
    </ol>

    <div class="list-group">
        <c:if test="${memory.extContent != null && memory.extContent.point != null && fn:length(memory.extContent.point) > 0}">
            <c:forEach items="${memory.extContent.point}" var="point" varStatus="stat">
                <pre class="list-group-item list-group-margin list-group-item-info">${stat.count}. ${point}</pre>
            </c:forEach>
        </c:if>
    </div>
</div>

<footer class="footer">
    <div class="container">
        <p class="text-muted" align="center">txazo.com © 粤ICP备14070725号</p>
    </div>
</footer>

<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>

