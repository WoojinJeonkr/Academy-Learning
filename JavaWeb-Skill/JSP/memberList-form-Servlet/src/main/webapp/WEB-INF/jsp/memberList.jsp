<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원목록</title>
	<link rel="stylesheet" type="text/css" href="${contextPath}/css/style.css">
</head>
<body>
	<div class="container">
		<div class="section">
			<h2>회원목록</h2>
			<table class="bluetop">
				<tr>
					<td>No</td>
					<td>이름</td>
					<td>아이디</td>
					<td>비밀번호</td>
					<td>이메일</td>
					<td>핸드폰</td>
					<td>수정일</td>
					<td>등록일</td>
				</tr>
				<c:forEach var="member" items="${member_list}" varStatus="status">
				<tr>
					<td>${member.m_idx}</td>
					<td>${member.m_name}</td>
					<td>${member.m_id}</td>
					<td>${member.m_pw}</td>
					<td>${member.m_email}</td>
					<td>${member.m_phone}</td>
					<td>${member.m_mdfydate}</td>
					<td><fmt:formatDate value="${member.m_rgstdate}" pattern="yyyy-MM-dd"/></td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>