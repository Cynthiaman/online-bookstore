package task5;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// ����request��response�ı���
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//��ȡ������
		String userName=request.getParameter("logonName");
		String userPassword=request.getParameter("password");
		UserManage userm=new UserManage();
		UserInfo user=new UserInfo();
		user=userm.userLogin(userName, userPassword);	
		if(user!=null){
			request.getSession().setAttribute("loginUser", user);
			//request.setAttribute("info", "�û���¼�ɹ���");
			// out.println("<script>alert('��ӭ����WINPINHUI');</script>");
			
			//�����û���¼�ɹ�����
			
			 request.setAttribute("info", "<script>alert('�û���¼�ɹ���');</script>");
			 request.getRequestDispatcher("message.jsp").forward(request,response);
			 
		}
		else{
			request.setAttribute("info", "<script>alert('�û���¼ʧ�ܣ�');</script>");
			request.getRequestDispatcher("login1-2.jsp").forward(request,response);
			 
			//out.println("��¼ʧ��");
		}
		//ת��message.jspҳ��
		// request.getRequestDispatcher("atask2-1.jsp").forward(request,response);
		
		 
	}

}
