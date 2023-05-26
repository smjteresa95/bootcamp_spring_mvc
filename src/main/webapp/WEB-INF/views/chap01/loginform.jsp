<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <h1>고양이 정보 등록하기</h1>
    <form action="http://localhost:8080/chap01/login" method="POST">
        Id: <input type="text" name="id"><br/>
        Password: <input type="text" name="pw"><br/>
        <input type = "submit" value="로그인">
    </form>
</body>
</html>