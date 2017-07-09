package ru.asemenov.filter.servlets;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        System.out.println(request.getRequestURI());
        if (request.getRequestURI().contains("/login.html") || request.getRequestURI().contains("/signin")) {
            chain.doFilter(req, resp);
        } else {
            HttpSession session = request.getSession();
            System.out.println(session.getAttribute("login"));
            synchronized (session) {
                if (session.getAttribute("login") == null) {
                    ((HttpServletResponse)resp).sendRedirect(String.format("%s/login.html", request.getContextPath()));
                    return;
                }
            }
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {

    }
}
