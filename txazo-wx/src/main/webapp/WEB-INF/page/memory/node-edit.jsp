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
            <a class="navbar-brand" href="/memory/home.wx">技术体系</a>
        </div>
        <div class="collapse navbar-collapse" id="navbar">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/memory/home.wx">Home</a></li>
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

    <form action="/memory/updateNode.wx" method="post" class="form-horizontal" style="padding: 0px 15px;" role="form"
          id="update-form">
        <input type="hidden" name="id" id="id" value="${memory.id}"/>

        <div id="points">
            <c:choose>
                <c:when test="${memory.extContent != null && memory.extContent.point != null && fn:length(memory.extContent.point) > 0}">
                    <c:forEach items="${memory.extContent.point}" var="p" varStatus="stat">
                        <div class="form-group">
                            <div class="col-xs-1" style="padding-top: 12px;">
                                <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
                            </div>
                            <div class="col-xs-9">
                                <textarea name="point" class="form-control" required="">${p}</textarea>
                            </div>
                            <div class="col-xs-1" style="padding-top: 12px;">
                                <c:if test="${stat.first}">
                                    <a href="javascript:;" onclick="plus();">
                                        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                                    </a>
                                </c:if>
                                <c:if test="${!stat.first}">
                                    <a href="javascript:;" onclick="minus(this);">
                                        <span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
                                    </a>
                                </c:if>
                            </div>
                        </div>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <div class="form-group">
                        <div class="col-xs-1" style="padding-top: 12px;">
                            <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
                        </div>
                        <div class="col-xs-9">
                            <textarea name="point" class="form-control" required=""></textarea>
                        </div>
                        <div class="col-xs-1" style="padding-top: 12px;">
                            <a href="javascript:;" onclick="plus();">
                                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                            </a>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>

        <div class="form-group">
            <div style="width: 60%; margin: 0 auto;">
                <button type="submit" class="btn btn-danger" style="width:100%;">Update</button>
            </div>
        </div>
    </form>
</div>

<footer class="footer">
    <div class="container">
        <p class="text-muted" align="center">txazo.com © 粤ICP备14070725号</p>
    </div>
</footer>

<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="/js/app/memory/node-edit.js"></script>
</body>
</html>

