package servlet_http;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cycle")
public class LifecycleController extends HttpServlet{
	
	public LifecycleController() {
		System.out.println("Instatnciation is done");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("init() is invoked/called");
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service() is invoked/called");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy() is invoked");
	}

}
