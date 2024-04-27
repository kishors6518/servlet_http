package servlet_http;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet{
	
	@SuppressWarnings("unused")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
		
		CustomerCrud crud=new CustomerCrud();
		try {
			String dbpass=crud.getPassword(email);
			if(dbpass.equals(pass))
			{
				resp.sendRedirect("https://www.flipkart.com/");
			}else if(dbpass==null) {
				
				resp.sendRedirect("singup.html");
			}
			else {
				RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
				dispatcher.include(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
