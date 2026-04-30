package app;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*") // intercepts ALL requests
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest  req  = (HttpServletRequest)  request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String path = req.getRequestURI().substring(req.getContextPath().length());

        // ✅ These paths are always allowed (no login needed)
        boolean isPublic = path.equals("/login")
                        || path.startsWith("/css/")
                        || path.startsWith("/js/")
                        || path.startsWith("/comp/");

        if (isPublic) {
            chain.doFilter(request, response); // pass through
            return;
        }

        // Check session
        HttpSession session = req.getSession(false);
        boolean loggedIn = session != null && session.getAttribute("user") != null;

        if (loggedIn) {
            chain.doFilter(request, response); // logged in → allow
        } else {
            resp.sendRedirect(req.getContextPath() + "/login"); // not logged in → redirect
        }
    }

    @Override public void init(FilterConfig fc) throws ServletException {}
    @Override public void destroy() {}
}