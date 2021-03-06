<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- JSTL(JavaStandard Tag Library -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 전체 검색</title>
<style type="text/css">
	td {
		width: 150px;
		height: 50px;
		text-align: center;
	}
	.left {
		background: orange;
	}
	
	.right {
		background: lightblue;
	}
	img {
		width: 100px;
		height: 50px;
	}
</style>
</head>
<body>
<table border=1>
	<tr>
		<td class="left">상품 번호</td>
		<td class="left">상품 이름</td>
		<td class="left">상품 가격</td>
		<td class="left">상품 이미지</td>
	</tr>
<c:forEach items="${list}" var="one">
	<tr>
		<td class="right">${one.id}</td>
		<td class="right">
			<a href="one?id=${one.id}">
			${one.name}</a></td>
		<td class="right">${one.price}</td>
		<td class="right">
			<img src="resources/img/${one.img}">
		</td>
	</tr>
</c:forEach>
</table>
</body>
</html>