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
<title>Display</title>
</head>
<body>
<table border="2">
<tr>
<th>UserName</th>
<th>PassWord</th>
<th>Email</th>
<th>Id</th>
<th>To Do's</th>
</tr>
<%
try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Sallauddin","super");
	PreparedStatement pstmt=conn.prepareStatement("select * from Details");
	ResultSet rs=pstmt.executeQuery();
	while(rs.next()){
%>
	<tr>
	<td><%=rs.getInt("Id") %></td>
	<td><%=rs.getString("Username") %></td>
	<td><%=rs.getString("Password") %></td>
	<td><%=rs.getString("Email") %></td>
	
	<td><a href="edit.jsp?pwd=<%=rs.getInt("Id")%>">EDIT </a>   <a href="delete.jsp?pwd=<%=rs.getInt("Id")%>">DELETE</a></td>
	</tr>
	
		
<% 	
	}
	
}catch(Exception e){
	System.out.println(e);
}

%>

</table><br>
<a href="index.jsp"><b style="color:blue;"> HOME</b></a>

</body>
</html>