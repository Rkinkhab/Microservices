package com.example.gateway.ApiGatewayservice;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RequestResponseLoggingFilter implements Filter {
	private final static Logger LOG = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		chain.doFilter(request, response);
		LOG.info("Logging Request {} :{} : {} : {}", req.getRequestURL(), req.getRequestURI(), req.getMethod(),
				res.getStatus());
	}

	@Override
	public void destroy() {

	}

	// other methods
}