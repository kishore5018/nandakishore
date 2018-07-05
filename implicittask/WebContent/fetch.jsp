<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="2">
<tr>
<th>UserName</th>
<th>PassWord</th>
<th>Email</th>
<th>Id</th>
</tr>
<%
try{
String d=application.getInitParameter("dclass");
Class.forName(d);
String con=application.getInitParameter("url");
Connection cn=DriverManager.getConnection(con,"nanda","nanda123");
PreparedStatement pstmt=cn.prepareStatement("select * from empdata");
ResultSet rs=pstmt.executeQuery();
while(rs.next()){
%>
<tr>
	<td><%=rs.getInt("Id") %></td>
	<td><%=rs.getString("Username") %></td>
	<td><%=rs.getString("Password") %></td>
	<td><%=rs.getString("Email") %></td>
	
<a href="index.jsp">Home</a>
</tr>
<% 
}
	
}catch(Exception e){
	System.out.println(e);
}
%>

</table>
</body>
</html>