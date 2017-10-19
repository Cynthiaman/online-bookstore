package task3;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import task3.GoodsInfo;
import task3.ConnDB;

public class GoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public GoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession s1=request.getSession();
		String name = s1.getAttribute("keywords").toString().trim();	
		
		String strVar =s1.getAttribute("slectedType").toString().trim();	
		
		
		//String name = request.getParameter("keywords").trim();
		//	String strVar = request.getParameter("slectedType").trim();
		
		
		
		
		
		ConnDB conn=new ConnDB();	//创建数据库连接对象	
		String sql=null;
		if (name==null || name.isEmpty()) {	
			sql="select * from 图书数据表 ";
		}
		else{
		 //  sql="select top " + num + " 图书编码,图书名称,作者,价格,图片地址 from 图书数据表  where 图书名称 like '%" + name + "%' or 作者 like '%" + name + "%'";
			 sql="select * from 图书数据表   where " + strVar + " like '%" + name + "%'";
		}
		System.out.print(sql);
		ResultSet rs=conn.executeQuery(sql);	//查询全部商品信息
		List list=new ArrayList();
		try {
			while(rs.next()){
				GoodsInfo goods=new GoodsInfo();				
				goods.setGoodsCode(rs.getString("图书编码"));
				goods.setGoodsName(rs.getString("图书名称"));
				goods.setGoodsAuthor(rs.getString("作者"));
				goods.setGoodsPrice(rs.getDouble("价格"));
				goods.setGoodsImageAddress(rs.getString("图片地址"));
				list.add(goods);		//将商品信息保存到List集合中
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (name==null || name.isEmpty()) {	
		   sql="select count(*) from 图书数据表  ";
		   request.setAttribute("searchName", "全部图书");
		}
		else{
		  // sql="select count(*) from 图书数据表  where 图书名称  like '%" + name + "%' or 作者 like '%" + name + "%'";
			sql="select  count(*) from 图书数据表  where " + strVar + " like '%" + name + "%'";
			request.setAttribute("searchName", name);
		}
		rs=conn.executeQuery(sql);	//查询全部商品信息
		
		try {
			if(rs.next()){
				request.setAttribute("goodsCount", rs.getInt(1));
			}
			else{
				request.setAttribute("goodsCount",0);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		String str=request.getParameter("page");
		
		  if(str==null){
	            str="0";
	        }
	        int pagesize=2;
	       
	        int goodsCount=0;
	       // int goodsCount=(Integer)session.getAttribute("goodsCount");
			try {
				goodsCount = rs.getInt(1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	       
	        int maxPage=0;
	        maxPage=(goodsCount%pagesize==0)?(goodsCount/pagesize):(goodsCount/pagesize+1);
	        int currentPage = Integer.parseInt(str);

	        if(currentPage<1){
	            currentPage=1;
	        }else if(currentPage>maxPage){
	            currentPage=maxPage;
	        }
		    request.setAttribute("pagesize", pagesize);
	        request.setAttribute("currentPage", currentPage);
	        request.setAttribute("maxPage", maxPage);
		
		
		
		
		request.setAttribute("goodsList", list);		//将商品信息保存到HttpServletRequest中
		request.getRequestDispatcher("goodsSearch3-2.jsp").forward(request, response);		//重定向页面
	}
	
	
	
	
	
	
	
}
