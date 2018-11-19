package com.sjz.Firstweb.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.catalina.valves.rewrite.Substitution.RewriteRuleBackReferenceElement;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String pwd = req.getParameter("pwd");
		//String vcode = req.getParameter("vcode");
		System.out.println("用户名："+username);
		System.out.println("密码："+pwd);
		if (login(username, pwd)) {
			//成功
			resp.sendRedirect("t.html");
		}else {
			//失败
			resp.sendRedirect("f.html");
		}
	}
	public boolean login(String username,String pwd) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_mydb?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "sjz12345");
		    String sql = "select *from tb_user where username=? and pwd=?";//占位符?，解决sql注入
		    PreparedStatement ps = conn.prepareStatement(sql);
		    ps.setString(1, username);
		    ps.setString(2, pwd);
		    ResultSet rs = ps.executeQuery();
		    return rs.next();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
