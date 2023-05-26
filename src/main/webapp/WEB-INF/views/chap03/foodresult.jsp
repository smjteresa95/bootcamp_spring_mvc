<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <h1>주문서</h1>
    <ol>
        <p>
            ${name}님의 주문결과입니다.</br>
            ${tableNum}번 테이블에 <%=request.getParameter("menu")%> 가져다드립니다.
        </p>
    </ol>
    
</body>
</html>