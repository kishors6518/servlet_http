package servlet_http;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SingupController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		long phone=Long.parseLong(req.getParameter("phone"));
		String email=req.getParameter("email");
		String password=req.getParameter("pass");
		
		Customer customer=new Customer();
		customer.setId(id);
		customer.setName(name);
		customer.setPhone(phone);
		customer.setEmail(email);
		customer.setPassword(password);
		
		CustomerCrud crud=new CustomerCrud();
		try {
			int result =crud.singUp(customer);
			if(result!=0)
			{
				RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
				dispatcher.forward(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
