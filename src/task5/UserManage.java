package task5;
import java.sql.*;

public class UserManage {
   private Connection conn;
   private ResultSet rs;
   private  PreparedStatement pstmt;
   
   public UserManage(){
	   
   }
   
 //��ѯָ��ע���û��Ƿ����
   public boolean getUser(String name){
	   boolean result=false;
	   try{		
		   //��ȡ���ݿ�����Connection���󣬷���getConnection()Ϊ��̬��������ֱ�ӵ���
		   conn=DatabaseConn.getConnection();
		   String strSql="select �û��� from �û���3  where �û���=?";
		   pstmt=conn.prepareStatement(strSql);
		   pstmt.setString(1,name);
		   rs=pstmt.executeQuery();
		   if(rs.next()){
			   result=true;
		   }
		   //�ͷŴ�ResultSet����
		   if(rs!=null)rs.close();
		   //�ͷŴ�PreparedStatement����
		   if(pstmt!=null)pstmt.close();
	   }
		   catch(SQLException e)
		   {
			   e.printStackTrace();
		   }finally{
			   //�ر����ݿ�����
			   if(conn!=null)DatabaseConn.closeConn(conn);
		   }
	   return result;
   }
   
   //ָ���û���¼
   public UserInfo userLogin(String name,String password){
	   UserInfo loginUser=null;
	   try{		   
		   conn=DatabaseConn.getConnection();
		   String strSql="select �û�ID,�û���,����,Email  from �û���3  where �û���=? and ����=?";
		   pstmt=conn.prepareStatement(strSql);
		   pstmt.setString(1,name);
		   pstmt.setString(2,password);		   
		   rs=pstmt.executeQuery();
		   if(rs.next()){
			   //ʵ����һ���û�����
			   loginUser=new UserInfo();
			   //���û��������Ը�ֵ
			   loginUser.setId(rs.getInt("�û�ID"));
			   loginUser.setName(rs.getString("�û���"));
			   loginUser.setPassword(rs.getString("����"));
			   loginUser.setEmail(rs.getString("Email"));
		   }
		   //�ͷŴ�ResultSet����
		   if(rs!=null)rs.close();
		   //�ͷŴ�PreparedStatement����
		   if(pstmt!=null)pstmt.close();
	       }
		   catch(SQLException e)
		   {
			   e.printStackTrace();
		   }finally{
			   //�ر����ݿ�����
			   if(conn!=null)DatabaseConn.closeConn(conn);
		   }
	   return loginUser;
   }
   
 //�����ݱ�����û�ע����Ϣ
   public boolean insertUser(UserInfo newUser){
	   boolean result=false;
	   try{		   
		   conn=DatabaseConn.getConnection();
		   String strSql="insert into �û���3(�û���,����) values(?,?)";
		   pstmt=conn.prepareStatement(strSql);
		   pstmt.setString(1,newUser.getName());
		   pstmt.setString(2,newUser.getPassword());		
		   int i=pstmt.executeUpdate();
		   if(i>0){
			   result=true;
		   }
		   //�ͷŴ�PreparedStatement����
		   if(pstmt!=null)pstmt.close();
	   }
		   catch(SQLException e)
		   {
			   e.printStackTrace();
		   }finally{
			   //�ر����ݿ�����
			   if(conn!=null)DatabaseConn.closeConn(conn);
		   }
	   return result;
   }   
}
