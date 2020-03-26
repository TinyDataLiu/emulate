package com.alice.filter.springfilterdemo.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Slf4j
@Order(value = 2)
@Component
@WebFilter(urlPatterns = {"/*"})
public class SecondFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("start");
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("end");
    }
}
