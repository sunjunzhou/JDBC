package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class TestJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//加载驱动
		//贾（加载数据库）莲（链接数据库）欲（预执行数据库）执（执行数据库）事（释放数据库）
		try {
			//1.通过反射加载数据库驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.链接数据库
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_mydb?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "sjz12345");
		    //System.out.println(conn);
			//预执行sql语句
			//Scanner scanner = new Scanner(System.in);
			//String sql = "insert into tb_user(username,pwd)values('sjz','123')";
			String sql = "select *from tb_user where username";
			Statement statement=(Statement) conn.createStatement();
			//执行sql；
			((java.sql.Statement) statement).executeUpdate(sql);
			//释放链接
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
