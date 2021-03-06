<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/project.css">
<script type="text/javascript">
	$(function() {
		$('#plus').click(function() {
			$.ajax({
				url: 'plus',
				data: {
					id : ${one.id},
					name : '${one.name}',
					price : ${one.price}
				},
				success: function(result) {
					alert(result);
					if(confirm("장바구니를 확인하시겠습니까?")){
						location.href="basket.jsp";
					}
				},
				error: function() {
					alert("ajax 에러 발생")
				}
			});
		});
	});
</script>
</head>
<body>
	<div id="total">
		<div id="top">
			<jsp:include page="../../top.jsp"></jsp:include>
		</div>
		<div id="top2">
			<jsp:include page="../../top2.jsp"></jsp:include>
		</div>
		<div id="center">
			<span style="font-size: 25px;">물건 상세 페이지</span>
			<hr color=red>
			<a href="product.jsp">
			<button style="width: 200px; height: 50px;" class="btn btn-info">전체 목록으로!</button>
			</a>
			<br>
			<table border="1">
				<tr>
					<td class="left">제품번호</td>
					<td class="right">${one.id}</td>
					<!-- one.getId() -->
				</tr>
				<tr>
					<td class="left">제품이름</td>
					<td class="right">${one.name}</td>
				</tr>
				<tr>
					<td class="left">제품설명</td>
					<td class="right">${one.content}</td>
				</tr>
				<tr>
					<td class="left">제품가격</td>
					<td class="right">${one.price}</td>
				</tr>
				<tr>
					<td class="left">제품회사</td>
					<td class="right">${one.company}</td>
				</tr>
				<tr>
					<td class="left">제품이미지</td>
					<td class="right"><img src="resources/img/${one.img}"></td>
					<!-- 이미지가 보이게 -->
				</tr>
			</table>
			<button id="plus" style="width: 200px; height: 50px;">
				<img alt="" src="resources/img/bag.png" width="50" height="50">
			</button>
		</div>
	</div>
</body>
</html>