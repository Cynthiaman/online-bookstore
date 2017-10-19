package task;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CounterServlet2_1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException ,IOException{
		//��ȡServletContext����
		ServletContext context=getServletContext();
		Long num=(Long)context.getAttribute("count1");
		if(num==null){
			num=(long)1;
			context.setAttribute("count1", num);
			
		}else{
			context.setAttribute("count1", num+1);
			
		}
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE HTML>");
		out.println("<html>");
		out.println(" <head><title>ͳ����վ�ķ�����</title>");
		out.println(" <link rel='stylesheet' type='text/css' href='css/base.css'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='footer'>");
		out.println(" <span>���ǵ�"+context.getAttribute("count1")+"λ������ </span> ");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
		
		
	}
	   
	

}
