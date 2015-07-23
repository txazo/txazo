<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap Model</title>
    <!-- Bootstrap -->
    <link href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../../css/bootstrap-custom.css" rel="stylesheet">
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
            <a class="navbar-brand" href="#">Home</a>
        </div>
        <div class="collapse navbar-collapse" id="navbar">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Home</a></li>
                <li><a href="#">Add</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">

    <ol class="breadcrumb">
        <li><a href="#">Home</a></li>
        <li><a href="#">Library</a></li>
        <li class="active">Data</li>
    </ol>

    <!-- panel -->
    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title">Panel title</h3>
        </div>
        <div class="panel-body">
            Basic panel example
        </div>
        <div class="panel-footer">Panel footer</div>
    </div>

    <!-- list group -->
    <div class="list-group">
        <a href="#" class="list-group-item list-group-margin list-group-item-success">Dapibus ac facilisis in</a>
        <a href="#" class="list-group-item list-group-margin list-group-item-info">Morbi leo risus</a>
        <a href="#" class="list-group-item list-group-margin list-group-item-warning">Porta ac consectetur ac</a>
        <a href="#" class="list-group-item list-group-margin list-group-item-danger">Vestibulum at eros</a>
        <a href="#" class="list-group-item list-group-margin list-group-item-danger">Vestibulum at eros</a>
        <a href="#" class="list-group-item list-group-margin list-group-item-danger">Vestibulum at eros</a>
        <a href="#" class="list-group-item list-group-margin list-group-item-danger">Vestibulum at eros</a>
        <a href="#" class="list-group-item list-group-margin list-group-item-danger">Vestibulum at eros</a>
        <a href="#" class="list-group-item list-group-margin list-group-item-danger">Vestibulum at eros</a>
    </div>

    <!-- input group -->
    <div class="input-group">
        <span class="input-group-addon" id="basic-addon1">名称</span>
        <input type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
    </div>

</div>

<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>

