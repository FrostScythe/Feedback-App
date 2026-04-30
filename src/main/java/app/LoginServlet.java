package app;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // If already logged in, skip login page
        HttpSession session = req.getSession(false); // false = don't create new session
        if (session != null && session.getAttribute("user") != null) {
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }
        // Show login page
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String email    = req.getParameter("email");
        String password = req.getParameter("password");

        // Server-side validation
        if (email == null || email.isBlank() || password == null || password.isBlank()) {
            req.setAttribute("error", "Email and password are required.");
            req.getRequestDispatcher("/login.jsp").forward(req, resp); // forward keeps error attr
            return;
        }

        try {
            String validUser = UserDAO.validateUser(email, password);

            if (validUser != null) {
                // ✅ Login success — create session
                HttpSession session = req.getSession(); // creates new session
                session.setAttribute("user", validUser);
                session.setMaxInactiveInterval(30 * 60); // 30 minutes timeout
                resp.sendRedirect(req.getContextPath() + "/index.jsp");
            } else {
                // ❌ Wrong credentials — forward back with error
                req.setAttribute("error", "Invalid email or password.");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("error", "Server error. Please try again.");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}