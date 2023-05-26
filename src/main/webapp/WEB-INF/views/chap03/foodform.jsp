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
    <form action="http://localhost:8080/chap03/order" method="POST">
        주문자명: <input type="text" name="name"><br/>
        주문 테이블 번호: <input type="text" name="tableNum"><br/>
        주문 할 음식: 
        <select name="menu">
            <c:forEach var="menu" items="${menuList}">
                <option>
                    ${menu}
                </option>
            </c:forEach>
        </select>
    </br>
        <input type = "submit" value="주문">
    </form>
</body>
</html>