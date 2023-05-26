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
    <form action="http://localhost:8080/chap01/cat" method="POST">
        Name: <input type="text" name="name"><br/>
        age: <input type="text" name="age"><br/>
        Breed: <input type="text" name="breed"><br/>
        <input type = "submit" value="등록">
    </form>
</body>
</html>