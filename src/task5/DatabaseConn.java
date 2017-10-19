package task5;
import java.sql.*;

public class DatabaseConn {	
	
	public DatabaseConn(){
		
	}
	//�����ȡ���ݿ����ӵķ������÷���Ϊ��̬��������ֱ�ӵ���
	public static Connection getConnection(){	
		Connection conn=null;
		//��������
		String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		//���ݿ�����URL
	//	String url = "jdbc:sqlserver://localhost:1433;DatabaseName=ebook";
		
		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=ebook";
		
		
		
		//���ݿ��¼�û���
		String user = "sa";
		//���ݿ��¼����
		String password = "123456";
		try 
		{
			//��������
			Class.forName(driverClass);
			//��ȡ��������
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception ex) {
			ex.printStackTrace();
			//�������ݿ����Ӵ�����ʾ��Ϣ
			//response.sendError(500,"���ݿ����Ӳ��ɹ���");
		}
		 return conn;
	}
	//����ر����ݿ����ӵľ�̬����
	public static void closeConn(Connection conn){
		//�ж�conn�Ƿ�Ϊ��
		if(conn!=null){
			try{
				conn.close();  //�ر����ݿ�����
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}
	}
}
