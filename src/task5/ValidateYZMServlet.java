package task5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ValidateYZMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ValidateYZMServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ʶ����֤��
		//��ȡ������
		request.setCharacterEncoding("GB18030");
		response.setCharacterEncoding("GB18030");
		String name=request.getParameter("logonName");
		String password=request.getParameter("password");
		HttpSession session =request.getSession();
		PrintWriter out = response.getWriter();
		String rand = (String)session.getAttribute("randomCode"); 
		String input = request.getParameter("verifyCode"); 		
		if(rand.equals(input)){ 
		out.print("<script>alert('��֤ͨ����');</script>"); 
		response.sendRedirect("loginServlet?logonName="+name+"&password="+password);	
		} else{ 
			out.print("<script>alert('��������ȷ����֤�룡');location.href='login1-2.jsp';</script>"); 
/*			session.setAttribute("info", "��������ȷ����֤�룡");
			response.sendRedirect("login05.jsp");	*/	
		}
	}

}
