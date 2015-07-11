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
<%@ include file="../decorator/nav-user.jsp" %>

<div class="container-fluid">
    <ol class="breadcrumb">
        <li class="active">添加用户</li>
    </ol>

    <form action="/user/add" method="post" class="form-horizontal" style="padding: 0px 15px;" role="form" id="add-form">
        <div class="form-group">
            <div class="col-xs-3" style="padding-top: 7px;">
                <label for="trueName" class="control-label">姓&nbsp;&nbsp;名</label>
            </div>
            <div class="col-xs-9">
                <input type="text" name="trueName" class="form-control" id="trueName" placeholder="输入姓名" required/>
            </div>
        </div>

        <div class="form-group">
            <div class="col-xs-3" style="padding-top: 7px;">
                <label for="userName" class="control-label">微信号</label>
            </div>
            <div class="col-xs-9">
                <input type="text" name="userName" class="form-control" id="userName" placeholder="输入微信号" required/>
            </div>
        </div>

        <div class="form-group" id="alertDanger" style="display: none;">
            <div class="alert alert-danger" role="alert" style="padding: 8px; margin-bottom: 0px;"></div>
        </div>

        <div class="form-group">
            <div style="width: 60%; margin: 0 auto;">
                <button type="submit" class="btn btn-danger" style="width:100%;">添加</button>
            </div>
        </div>
    </form>
</div>

<%@ include file="../decorator/foot.jsp" %>
<script>
    seajs.use('user-add');
</script>
</body>
</html>

