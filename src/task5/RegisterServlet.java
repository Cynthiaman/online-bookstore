package task5;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}


	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub		
	// ����request��response�ı���
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	String strName=request.getParameter("logonName");
	String strPassword=request.getParameter("password");
	//PrintWriter out=response.getWriter();
	
	UserManage userm=new UserManage();
	if(strName!=null && !strName.isEmpty()){
		if(userm.getUser(strName)){
			request.setAttribute("info", "���û����Ѿ�ע���");
			//out.println("���û����Ѿ�ע���");
		}
		else{
		   UserInfo user=new UserInfo();
		   //���û��������Ը�ֵ
		   user.setName(strName);
		   user.setPassword(strPassword);
		   //�����û�ע����Ϣ
		   if (userm.insertUser(user)){
			  // request.setAttribute("info", "�û�ע��ɹ���");
			   request.setAttribute("info", "<script>alert('�û�ע��ɹ������ȵ�¼');</script>");
			  
		   }
		   else{
			   request.setAttribute("info", "�û�ע��ʧ�ܣ�");
		   }
		}
	}
	else{
		request.setAttribute("info", "�û������ע����Ϣ����");
	}
	
	//request.getRequestDispatcher("login1-2.jsp").forward(request,response);
	request.getRequestDispatcher("massage2.jsp").forward(request,response);
}
}
