<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Technology Memory">
    <meta name="author" content="txazo">
    <title>添加根目录</title>
    <!-- Bootstrap -->
    <link href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <h3>添加根目录</h3>

    <form action="/memory/addNode.wx" method="post" class="form-horizontal" role="form" id="add-form">
        <input type="hidden" name="parentId" id="parentId" value="${parentId}"/>
        <input type="hidden" name="type" id="type" value="${type}"/>

        <div class="row form-group">
            <label for="name" class="col-xs-2 control-label">名称</label>

            <div class="col-xs-10">
                <input type="text" name="name" class="form-control" id="name" placeholder="输入名称" required/>
            </div>
        </div>
        <div class="row form-group">
            <div style="width: 80%; margin: 0 auto;">
                <button type="submit" class="btn btn-success" style="width:100%;">添加</button>
            </div>
        </div>
    </form>
</div>
<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="/js/app/memory/add.js"></script>
</body>
</html>
