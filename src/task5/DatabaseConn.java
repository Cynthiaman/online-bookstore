package task5;
import java.sql.*;

public class DatabaseConn {	
	
	public DatabaseConn(){
		
	}
	//定义获取数据库连接的方法，该方法为静态方法可以直接调用
	public static Connection getConnection(){	
		Connection conn=null;
		//驱动程序
		String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		//数据库连接URL
	//	String url = "jdbc:sqlserver://localhost:1433;DatabaseName=ebook";
		
		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=ebook";
		
		
		
		//数据库登录用户名
		String user = "sa";
		//数据库登录密码
		String password = "123456";
		try 
		{
			//加载驱动
			Class.forName(driverClass);
			//获取数据连接
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception ex) {
			ex.printStackTrace();
			//发送数据库连接错误提示信息
			//response.sendError(500,"数据库连接不成功。");
		}
		 return conn;
	}
	//定义关闭数据库连接的静态方法
	public static void closeConn(Connection conn){
		//判断conn是否为空
		if(conn!=null){
			try{
				conn.close();  //关闭数据库连接
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}
	}
}
