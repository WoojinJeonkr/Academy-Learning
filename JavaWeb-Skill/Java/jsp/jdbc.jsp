<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JDBC 연결 확인</title>
</head>
<body>
	<h2>JDBC 드라이버 테스트</h2>
	<%
	Connection con = null;
	String url ="jdbc:mariadb://localhost:3306/mars";
	String user = "mars";
	String pw = "p@ss00";
	
	try{
		// 1. JDBC 드라이버 로딩
		// Class.forName("org.postgresql.Driver");
		Class.forName("org.mariadb.jdbc.Driver");
		
		// 2. Connection 생성
		con = DriverManager.getConnection(url, user, pw);
		out.println("Database 연결 성공~");
	} catch (ClassNotFoundException e){
		e.printStackTrace();
	}
	%>
</body>
</html>