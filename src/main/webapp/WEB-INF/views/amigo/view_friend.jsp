<%--
  Created by IntelliJ IDEA.
  User: danawacomputer
  Date: 2017-06-12
  Time: 오후 4:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1> ${friendname}친구가 조회되었습니다.</h1>

<c:forEach var="Amigo" items="${list}">
    <ul>
        <li> 친구이름 :<a href="/amigo/${Amigo.friendname}"> ${Amigo.friendname} </a></li>
        <li> 핸드폰번호 : ${Amigo.phonenumber} </li>
        <li> 이메일 : ${Amigo.email} </li>
    </ul>

</c:forEach>

<%--<p>${list[0].friendname}</p>--%>

<a href="/amigo/regist"> 친구등록 </a>


</body>
</html>
