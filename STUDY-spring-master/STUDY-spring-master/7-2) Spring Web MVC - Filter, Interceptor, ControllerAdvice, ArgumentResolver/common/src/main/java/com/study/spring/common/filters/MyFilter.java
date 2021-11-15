package com.study.spring.common.filters;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

public class MyFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ipInfo = ObjectUtils.isEmpty(request.getHeader("X-Forwarded-For")) ? request.getRemoteAddr() : request.getHeader("X-Forwarded-For");
		request.setAttribute("ipInfo", ipInfo);
		filterChain.doFilter(request, response);
	}

}
