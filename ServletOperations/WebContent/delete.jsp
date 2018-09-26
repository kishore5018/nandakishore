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
<title>delete</title>
</head>
<body>
<%
	try
{       int id2=Integer.parseInt(request.getParameter("pwd"));
	Class.forName( "oracle.jdbc.driver.OracleDriver");
	Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Sallauddin","super");
	PreparedStatement pst=conn.prepareStatement("delete  from Details where Id=?");
	pst.setInt(1, id2);
	ResultSet rs=pst.executeQuery();
	boolean req=rs.next();

        response.sendRedirect("success.jsp");
}
    catch(Exception e){
	System.out.println(e);

}



%>

</body>
</html>