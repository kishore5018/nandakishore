package servlet;




import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.deletedao;

import userbean.userbean;
@WebServlet("/deleteservlet")
public class deleteservlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
		userbean user=new userbean();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		user.setId(Integer.parseInt(request.getParameter("id")));
		deletedao.delete(user);
		response.sendRedirect("fetch.jsp");
}
}