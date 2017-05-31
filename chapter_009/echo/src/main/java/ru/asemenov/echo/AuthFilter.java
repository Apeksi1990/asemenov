package ru.asemenov.echo;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/**
 * Class AuthFilter решение задачи части 009.
 * @author asemenov
 * @version 1
 */
public class AuthFilter implements Filter {
    /**
     * Initialization.
     * @param filterConfig FilterConfig.
     * @throws ServletException exception.
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * Filter.
     * @param req ServletRequest.
     * @param resp ServletResponse.
     * @param chain FilterChain.
     * @throws IOException exception.
     * @throws ServletException exception.
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        if (request.getRequestURI().contains("/signin")) {
            chain.doFilter(req, resp);
        } else {
            HttpSession session = request.getSession();
            synchronized (session) {
                if (session.getAttribute("login") == null) {
                    ((HttpServletResponse) resp).sendRedirect(String.format("%s/signin", request.getContextPath()));
                    return;
                }
            }
            chain.doFilter(req, resp);
        }
    }

    /**
     * Destroy.
     */
    @Override
    public void destroy() {

    }
}
