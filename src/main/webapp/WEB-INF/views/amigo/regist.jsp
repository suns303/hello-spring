<%--
  Created by IntelliJ IDEA.
  User: danawacomputer
  Date: 2017-06-12
  Time: 오후 2:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<br class="container">
<div class="header clearfix">
    <nav>
        <ul class="nav nav-pills pull-right">
            <li role="presentation" class="active"><a href="#">Home</a></li>
            <li role="presentation"><a href="#">About</a></li>
            <li role="presentation"><a href="#">Contact</a></li>
        </ul>
    </nav>
    <h3 class="text-muted"> 친구등록화면입니다.</h3>
</div>

<form action="/amigo/regist/go" method="post">

    <div class="input-group input-group-lg">
                <span class="input-group-addon">
                <i class="glyphicon glyphicon-ok-sign"></i>친구이름
                </span>
        <input type="text" name="friendname" class="form-control" placeholder="친구이름">
    </div>


    <div class="input-group input-group-lg">
                <span class="input-group-addon">
                <i class="glyphicon glyphicon-ok-sign"></i>핸드폰
                </span>
        <input type="text" name="phonenumber" class="form-control" placeholder="핸드폰">
    </div>



    <div class="input-group input-group-lg">
                <span class="input-group-addon">
                <i class="glyphicon glyphicon-ok-sign"></i>이메일
                </span>
        <input type="text" name="email" class="form-control" placeholder="이메일">
    </div>

    <p><input type = "submit" value="친구등록하기"  class="btn btn-lg btn-success" href="#" role="button"></p>
</form>


</body>
</html>
