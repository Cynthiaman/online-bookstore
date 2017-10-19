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
		
		
		// 设置request与response的编码
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//获取表单数据
		String userName=request.getParameter("logonName");
		String userPassword=request.getParameter("password");
		UserManage userm=new UserManage();
		UserInfo user=new UserInfo();
		user=userm.userLogin(userName, userPassword);	
		if(user!=null){
			request.getSession().setAttribute("loginUser", user);
			//request.setAttribute("info", "用户登录成功！");
			// out.println("<script>alert('欢迎光临WINPINHUI');</script>");
			
			//弹出用户登录成功界面
			
			 request.setAttribute("info", "<script>alert('用户登录成功！');</script>");
			 request.getRequestDispatcher("message.jsp").forward(request,response);
			 
		}
		else{
			request.setAttribute("info", "<script>alert('用户登录失败！');</script>");
			request.getRequestDispatcher("login1-2.jsp").forward(request,response);
			 
			//out.println("登录失败");
		}
		//转发message.jsp页面
		// request.getRequestDispatcher("atask2-1.jsp").forward(request,response);
		
		 
	}

}
