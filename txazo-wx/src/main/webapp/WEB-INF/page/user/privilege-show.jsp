<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>权限设置</title>
    <%@ include file="../decorator/head.jsp" %>
    <link href="http://cdn.bootcss.com/iCheck/1.0.1/skins/square/red.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/bootstrap-switch/3.3.2/css/bootstrap3/bootstrap-switch.min.css" rel="stylesheet">
</head>
<body>
<%@ include file="../decorator/nav-user.jsp" %>

<div class="container-fluid">
    <ol class="breadcrumb">
        <li class="active">权限设置</li>
    </ol>

    <form action="/user/privilege/update" method="post" class="form-horizontal" role="form" id="update-form">
        <input type="hidden" name="userId" value="${userId}"/>

        <div class="panel panel-danger">
            <div class="panel-heading">权限设置</div>
            <table class="table table-bordered table-hover table-responsive table-striped">
                <thead>
                <tr>
                    <th class="text-center">应用</th>
                    <th class="text-center">权限</th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${privileges != null && fn:length(privileges) > 0}">
                    <c:forEach items="${privileges}" var="p">
                        <tr>
                            <td class="text-center">${p.title}</td>
                            <td class="text-center">
                                <!--
                                <input type="checkbox" name="privilege"
                                       value="${p.privilege}" ${p.hasPrivilege ? 'checked' : ''}/>
                                       -->
                                <input type="checkbox" data-size="mini" data-on-color="success"
                                       data-off-color="danger" checked/>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
        </div>

        <div class="form-group">
            <div style="width: 60%; margin: 0 auto;">
                <button type="submit" class="btn btn-danger" style="width:100%;">更新权限</button>
            </div>
        </div>
    </form>
</div>

<%@ include file="../decorator/foot.jsp" %>
<script src="http://cdn.bootcss.com/iCheck/1.0.1/icheck.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap-switch/3.3.2/js/bootstrap-switch.min.js"></script>
<script>
    $(function () {
//        $('input[type="checkbox"]').iCheck({
//            checkboxClass: 'icheckbox_square-red',
//            radioClass: 'iradio_square-red',
//            increaseArea: '20%'
//        });

        $('input[type="checkbox"]').bootstrapSwitch();
    });
</script>
</body>
</html>

