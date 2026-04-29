package app;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/feedback")
public class FeedbackServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String phone=  req.getParameter("phone");
		String feedbackMessage = req.getParameter("feedback_message");
		
		resp.setContentType("text/html");
		PrintWriter writer =resp.getWriter();
		writer.println("<h1>Feedback servlet working</h1>");
		
		writer.println("""
				
				<h2>Your form details that you have submited</h2>
				<h3>Email address: %s</h3>
				<h3>Phone number: %s</h3>
				<h3>Feedback message: %s</h3>
				""".formatted(email, phone,feedbackMessage));
	}

}
