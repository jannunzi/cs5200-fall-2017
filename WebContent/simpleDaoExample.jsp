<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="lecture.jdbc.dao.*,java.util.*,lecture.jdbc.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Simple JSP + DAO Example</h1>
	
	<%
		Website website = (Website)request.getAttribute("website");
		String name = "";
		String description = "";
		String websiteId = "";
		if(website != null) {
			name = website.getName();
			description = website.getDescription();
			websiteId = website.getId() + "";
		}
	%>
	
	<form action="/cs5200_lecture/WebsiteController" method="POST">
		<input type="hidden" value="<%= websiteId %>" name="id"/>
		<input value="<%= name %>" name="name" placeholder="Website Name"/>
		<br/>
		<textarea name="description"><%= description %></textarea>
		<br/>
		<button type="submit">Create Website</button>
		<button type="submit" name="action" value="update">Update Website</button>
	</form>
	
	<ul>
	<%
		ArrayList<Website> websites = (ArrayList<Website>)request.getAttribute("websites");
		int count = websites.size();
		for(int i=0; i<count; i++) {
			website = websites.get(i);
			%>
			<li>
				<%= website.getName() %>
				<a href="/cs5200_lecture/WebsiteController?action=select&websiteId=<%= website.getId()%>">Select</a>
				<a href="/cs5200_lecture/WebsiteController?action=delete&websiteId=<%= website.getId()%>">Delete</a>
			</li>
			<%
		}
	%>
	</ul>
</body>
</html>