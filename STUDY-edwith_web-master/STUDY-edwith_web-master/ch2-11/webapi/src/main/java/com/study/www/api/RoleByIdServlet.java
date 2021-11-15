package com.study.www.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.www.dao.RoleDao;
import com.study.www.vo.Role;

/**
 * Servlet implementation class RoleByIdServlet
 */
@WebServlet("/roles/*")
public class RoleByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RoleByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		String pathInfo = request.getPathInfo();
		String[] pathParts = pathInfo.split("/");
		String roleIdStr = pathParts[1];
		Integer roleId = Integer.parseInt(roleIdStr);
		
		RoleDao rd = new RoleDao();
		Role role = rd.getRoleById(roleId);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(role);
		
		PrintWriter writer = response.getWriter();
		writer.println(json);
		writer.close();
	}
}
