<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>添加用户</title>
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
    <form action="/user/add" method="post" class="form-horizontal" style="padding: 0px 15px;" role="form" id="add-form">
        <div class="form-group">
            <div class="col-xs-3" style="padding-top: 7px;">
                <label for="userName" class="control-label">微信号</label>
            </div>
            <div class="col-xs-9">
                <input type="text" name="userName" class="form-control" id="userName" placeholder="输入微信号" required/>
            </div>
        </div>

        <div class="form-group">
            <div class="col-xs-3" style="padding-top: 7px;">
                <label for="trueName" class="control-label">姓名</label>
            </div>
            <div class="col-xs-9">
                <input type="text" name="trueName" class="form-control" id="trueName" placeholder="输入姓名" required/>
            </div>
        </div>

        <div class="form-group" id="alertDanger" style="display: none;">
            <div class="alert alert-danger" role="alert" style="padding: 8px; margin-bottom: 0px;"></div>
        </div>

        <div class="form-group">
            <div style="width: 60%; margin: 0 auto;">
                <button type="submit" class="btn btn-danger" style="width:100%;">Add</button>
            </div>
        </div>
    </form>
</div>

<%@ include file="../decorator/foot.jsp" %>
<script src="/js/app/user/add.js"></script>
</body>
</html>

