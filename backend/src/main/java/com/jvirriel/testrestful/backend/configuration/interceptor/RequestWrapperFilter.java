package com.jvirriel.testrestful.backend.configuration.interceptor;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RequestWrapperFilter implements Filter {
    public void init(FilterConfig config)
            throws ServletException {
        // nothing goes here
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws java.io.IOException, ServletException {
        MultiReadHttpServletRequest requestWrapper = new MultiReadHttpServletRequest((HttpServletRequest) request);
        // Pass request back down the filter chain
        chain.doFilter(requestWrapper, response);
    }

    public void destroy() {
 /* Called before the Filter instance is removed
 from service by the web container*/
    }
}
