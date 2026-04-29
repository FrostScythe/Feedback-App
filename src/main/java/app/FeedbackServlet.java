package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;           
import java.sql.PreparedStatement;    
import java.sql.SQLException;        

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/feedback")
public class FeedbackServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String email   = req.getParameter("email");
        String phone   = req.getParameter("phone");
        String message = req.getParameter("feedback_message");

        String sql = "INSERT INTO feedback (email, phone, message) VALUES (?, ?, ?)";
        
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, phone);
            stmt.setString(3, message);
            stmt.executeUpdate(); // ← actually runs the INSERT

            resp.sendRedirect(req.getContextPath() + "/index.jsp?success=true");

        } catch (SQLException e) {
            e.printStackTrace();
            resp.setContentType("text/html");
            PrintWriter writer = resp.getWriter();
            writer.println("<h2>Database error: " + e.getMessage() + "</h2>");
        }
    }
}