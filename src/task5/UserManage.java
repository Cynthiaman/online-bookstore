package task5;
import java.sql.*;

public class UserManage {
   private Connection conn;
   private ResultSet rs;
   private  PreparedStatement pstmt;
   
   public UserManage(){
	   
   }
   
 //查询指定注册用户是否存在
   public boolean getUser(String name){
	   boolean result=false;
	   try{		
		   //获取数据库连接Connection对象，方法getConnection()为静态方法可以直接调用
		   conn=DatabaseConn.getConnection();
		   String strSql="select 用户名 from 用户表3  where 用户名=?";
		   pstmt=conn.prepareStatement(strSql);
		   pstmt.setString(1,name);
		   rs=pstmt.executeQuery();
		   if(rs.next()){
			   result=true;
		   }
		   //释放此ResultSet对象
		   if(rs!=null)rs.close();
		   //释放此PreparedStatement对象
		   if(pstmt!=null)pstmt.close();
	   }
		   catch(SQLException e)
		   {
			   e.printStackTrace();
		   }finally{
			   //关闭数据库连接
			   if(conn!=null)DatabaseConn.closeConn(conn);
		   }
	   return result;
   }
   
   //指定用户登录
   public UserInfo userLogin(String name,String password){
	   UserInfo loginUser=null;
	   try{		   
		   conn=DatabaseConn.getConnection();
		   String strSql="select 用户ID,用户名,密码,Email  from 用户表3  where 用户名=? and 密码=?";
		   pstmt=conn.prepareStatement(strSql);
		   pstmt.setString(1,name);
		   pstmt.setString(2,password);		   
		   rs=pstmt.executeQuery();
		   if(rs.next()){
			   //实例化一个用户对象
			   loginUser=new UserInfo();
			   //对用户对象属性赋值
			   loginUser.setId(rs.getInt("用户ID"));
			   loginUser.setName(rs.getString("用户名"));
			   loginUser.setPassword(rs.getString("密码"));
			   loginUser.setEmail(rs.getString("Email"));
		   }
		   //释放此ResultSet对象
		   if(rs!=null)rs.close();
		   //释放此PreparedStatement对象
		   if(pstmt!=null)pstmt.close();
	       }
		   catch(SQLException e)
		   {
			   e.printStackTrace();
		   }finally{
			   //关闭数据库连接
			   if(conn!=null)DatabaseConn.closeConn(conn);
		   }
	   return loginUser;
   }
   
 //在数据表添加用户注册信息
   public boolean insertUser(UserInfo newUser){
	   boolean result=false;
	   try{		   
		   conn=DatabaseConn.getConnection();
		   String strSql="insert into 用户表3(用户名,密码) values(?,?)";
		   pstmt=conn.prepareStatement(strSql);
		   pstmt.setString(1,newUser.getName());
		   pstmt.setString(2,newUser.getPassword());		
		   int i=pstmt.executeUpdate();
		   if(i>0){
			   result=true;
		   }
		   //释放此PreparedStatement对象
		   if(pstmt!=null)pstmt.close();
	   }
		   catch(SQLException e)
		   {
			   e.printStackTrace();
		   }finally{
			   //关闭数据库连接
			   if(conn!=null)DatabaseConn.closeConn(conn);
		   }
	   return result;
   }   
}
