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
	// 设置request与response的编码
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	String strName=request.getParameter("logonName");
	String strPassword=request.getParameter("password");
	//PrintWriter out=response.getWriter();
	
	UserManage userm=new UserManage();
	if(strName!=null && !strName.isEmpty()){
		if(userm.getUser(strName)){
			request.setAttribute("info", "该用户名已经注册过");
			//out.println("该用户名已经注册过");
		}
		else{
		   UserInfo user=new UserInfo();
		   //对用户对象属性赋值
		   user.setName(strName);
		   user.setPassword(strPassword);
		   //保存用户注册信息
		   if (userm.insertUser(user)){
			  // request.setAttribute("info", "用户注册成功！");
			   request.setAttribute("info", "<script>alert('用户注册成功！请先登录');</script>");
			  
		   }
		   else{
			   request.setAttribute("info", "用户注册失败！");
		   }
		}
	}
	else{
		request.setAttribute("info", "用户输入的注册信息有误！");
	}
	
	//request.getRequestDispatcher("login1-2.jsp").forward(request,response);
	request.getRequestDispatcher("massage2.jsp").forward(request,response);
}
}
