package task2;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import task3.ConnDB;
import task2.GoodsInfo1;

public class GoodsServlet10013 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public GoodsServlet10013() {
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
		String name = s1.getAttribute("keywords3").toString().trim();	
		//String name = request.getParameter("keywords").trim();
	
	
		ConnDB conn=new ConnDB();	//创建数据库连接对象	
		String sql=null;
		if (name==null || name.isEmpty()) {	
			sql="select * from 图书详情表 ";
		}
		else{
		 //  sql="select top " + num + " 图书编码,图书名称,作者,价格,图片地址 from 图书数据表  where 图书名称 like '%" + name + "%' or 作者 like '%" + name + "%'";
			 sql="select * from 图书详情表   where 图书名称  like '%" + name + "%'";
		}
		System.out.print(sql);
		ResultSet rs=conn.executeQuery(sql);	//查询全部商品信息
		List list=new ArrayList();
		try {
			while(rs.next()){
				GoodsInfo1 goods=new GoodsInfo1();				
				goods.setGoodsName(rs.getString("图书名称"));
				goods.setGoodsAuthor(rs.getString("作者"));
				goods.setGoodsPublish(rs.getString("出版社"));
				goods.setGoodsDate(rs.getString("出版日期"));
				goods.setGoodsPreferentialPrice(rs.getDouble("优惠价格"));
				goods.setGoodsBrief(rs.getString("图书简介"));
				goods.setGoodsPrice(rs.getDouble("价格"));
				goods.setGoodsImageAddress(rs.getString("图片地址"));
				goods.setGoodsImageAddress1(rs.getString("小图片地址1"));
				goods.setGoodsImageAddress2(rs.getString("小图片地址2"));
				goods.setGoodsImageAddress3(rs.getString("小图片地址3"));
				list.add(goods);		//将商品信息保存到List集合中
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (name==null || name.isEmpty()) {	
		   sql="select count(*) from 图书详情表  ";
		   request.setAttribute("searchName", "全部图书");
		}
		else{
		 
			sql="select  count(*) from 图书详情表  where 图书名称  like '%" + name + "%'";
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
		
		request.setAttribute("goodsList", list);		//将商品信息保存到HttpServletRequest中
		request.getRequestDispatcher("details.jsp").forward(request, response);		//重定向页面
	}	
}
