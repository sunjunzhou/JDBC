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

//import org.apache.catalina.startup.PasswdUserDatabase;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String pwd = req.getParameter("pwd");
		String vcode = req.getParameter("vcode");
		if (pwd.equals(vcode)) {
			register(username, pwd);
			resp.sendRedirect("index.html");
			
		}else {
			resp.sendRedirect("f.html");
		}
	}
	public void register(String username,String pwd) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_mydb?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "sjz12345");
		    String sql = "insert into tb_user(username,pwd) values(?,?)";
		    PreparedStatement ps = conn.prepareStatement(sql);
		    ps.setString(1, username);
		    ps.setString(2, pwd);
		    ps.executeUpdate();
		    conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
