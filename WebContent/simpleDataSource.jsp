<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.naming.*,javax.sql.DataSource,java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello from Simple Data Source Example</h1>
	
	<ul>
	<%
		Context initCtx = new InitialContext();
		Context envCtx  = (Context)initCtx.lookup("java:/comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/lectures");
		Connection connection = ds.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM Website");
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			%>
			<li><%= name %></li>
			<%
		}
	%>
	</ul>
</body>
</html>