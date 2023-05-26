<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <h1>${title}</h1>

    <h2>submit 방식</h2>
    <form action="https://search.naver.com/search.naver" method="GET">
        네이버 검색어 입력: <input type="text" name="query"><br/>
        <input type = "submit" value="검색하기">
    </form>

   <h2>Redirect 방식</h2>
    <form action="http://localhost:8080/chap03/research" method="GET">
        네이버 검색어 입력: <input type="text" name="query"><br/>
        <input type = "submit" value="검색하기">
    </form>

</body>
</html>