package task;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class Filter2_3  extends HttpServlet implements Filter {
  public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain)
      throws IOException,ServletException{
	  HttpServletRequest req=(HttpServletRequest)request;
	  ServletContext sc=req.getSession().getServletContext();
	  if(sc.getAttribute("count")!=null){
		  Long num=(Long)sc.getAttribute("count");
		  sc.setAttribute("count", ++num);
	  }else{
		  sc.setAttribute("count", new Long(1));
		 
	  }
	  chain.doFilter(req, response);
  }
 public Filter2_3() {
	 
 }
 public  void destroy() {
	 
 }
 public void init(FilterConfig fconfig)throws ServletException{
	 
 }
}
