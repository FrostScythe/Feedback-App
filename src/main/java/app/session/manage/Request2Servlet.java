package app.session.manage;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/servlet2")
public class Request2Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		var writer = resp.getWriter();
		Cookie[] cookies =req.getCookies();
		
		var flag = false;
		
		if(cookies!=null) {
			for(Cookie c: cookies) {
				String name = c.getName();
				if(name.equals("username")) {
					System.out.println("username: "+c.getValue());
					
					writer.println("""
							<h1>Welcome %s</h1>
							""".formatted(c.getValue()));
					flag =true;
				}
			}
		}
		
		if(!flag) {
			writer.println("<h1> No username found in cookies</h1>");
			writer.println("<h1>Username cookie is not there in request</h1>");
		}
	}
}
