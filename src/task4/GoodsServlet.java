package task4;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;;

@SuppressWarnings("serial")
public class GoodsServlet extends HttpServlet {
	Connection conn = null; // 声明Connection对象的实例
	ResultSet rs = null; // 声明ResultSet对象的实例	
	PreparedStatement pstat = null; // 声明PreparedStatement对象的实例
	String sql = null;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	conn = ConnDB.getConnection(); 
	String operate = request.getParameter("action"); //获取action参数值	
	//将商品放入购物车
	if (operate.equals("add")){
		//从商品库中取出所选购商品的数据
		String goodsCode = request.getParameter("code");		
		sql="select 图书编码,价格,购买数量  from 购物车表1 where 图书名称=?";
		try {
			String name=null,price=null,num=null,preferentialPrice=null,address=null;	
			pstat = conn.prepareStatement(sql);
			pstat.setString(1,goodsCode);
			rs = pstat.executeQuery();
			if (rs.next()){
				num=rs.getString("购买数量").trim();
				price = rs.getString("价格").trim();
				sql = "update 购物车表1  set 购买数量 = ?, 金额 = ? where 图书名称=?";
				pstat = conn.prepareStatement(sql);
				pstat.setInt(1,new Integer(num)+1);
				pstat.setDouble(2,(new Integer(num)+1)*new Double(price));
				pstat.setString(3,goodsCode);
				pstat.executeUpdate();
				pstat.close();		
				//关闭数据库连接
				conn.close();		
			}else{
				sql="select 图书编码,图书名称,价格,优惠价格,图片地址 from 图书数据表 where 图书名称=?";
				pstat = conn.prepareStatement(sql);
				pstat.setString(1,goodsCode);
				rs = pstat.executeQuery();
				if (rs.next()){
					name = rs.getString("图书名称").trim();
					price = rs.getString("价格").trim();
					preferentialPrice=rs.getString("优惠价格").trim();
					address=rs.getString("图片地址").trim();
				}
				Date buyDate = new Date();
				SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
                String strDate=sdf.format(buyDate);//				
				//将所选购商品加入到购物车中
				sql = "insert into 购物车表1(图书编码,图书名称,价格,优惠价格,购买数量,金额,购买日期,图片地址) values(?,?,?,?,?,?,?,?)";
				pstat = conn.prepareStatement(sql);
				pstat.setString(1,goodsCode);
				pstat.setString(2,name);
				pstat.setString(3,price);
				pstat.setString(4,preferentialPrice);
				pstat.setInt(5,1);
				pstat.setDouble(6,new Double(price)*1);
				pstat.setString(7, strDate);
				pstat.setString(8,address);
				pstat.executeUpdate();
				pstat.close();		
				//关闭数据库连接
				conn.close();	
			}			
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		//重定向到购物车页面
		response.sendRedirect("cartServlet");
	}	
	//更改商品的数量
	if (operate.equals("update")){
		String id = request.getParameter("code");
		int num = Integer.parseInt(request.getParameter("num"));
		double price=Double.parseDouble(request.getParameter("price"));
		sql = "update 购物车表1  set 购买数量 = ?, 金额 = ? where 图书名称=?";
		try {
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1,num);
			pstat.setDouble(2,new Double(price*num));
			pstat.setString(3,id);
			pstat.executeUpdate();
			pstat.close();		
			//关闭数据库连接
			conn.close();		
			//重定向到购物车页面
			response.sendRedirect("cartServlet");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}		
	//将商品退回到商品架(将商品从购物车中删除)
	if (operate.equals("del")){
		String id = request.getParameter("code");
		sql = "delete from 购物车表1 where 图书名称=?";
		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1,id);
			pstat.executeUpdate();
			pstat.close();		
			//关闭数据库连接
			conn.close();		
			//重定向到购物车页面
			response.sendRedirect("cartServlet");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}	
	//清空购物车
	if (operate.equals("clear")){
		String sql=null;
		sql = "delete from 购物车表1";
		try {
			pstat = conn.prepareStatement(sql);
			pstat.executeUpdate();
			pstat.close();		
			//关闭数据库连接
			conn.close();		
			//重定向到购物车页面
			response.sendRedirect("gwc.jsp");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
  }
}
