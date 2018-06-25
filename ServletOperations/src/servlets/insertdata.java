package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Operations.pojo;
import dao.insertdao;

@WebServlet("/insertdata")
public class insertdata extends HttpServlet {
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
		pojo user=new pojo();
		user.setUsername(request.getParameter("un"));
		user.setPassword(request.getParameter("pwd"));
		user.setEmail(request.getParameter("email"));
		user.setId(Integer.parseInt(request.getParameter("id")));
		insertdao.insert(user);
		response.sendRedirect("success.jsp");
		
	}
		
}
