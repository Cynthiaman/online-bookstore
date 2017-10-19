package task4;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import task4.CartInfo;
import task4.ConnDB;

@SuppressWarnings("serial")
public class CartServlet extends HttpServlet {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ConnDB conn=new ConnDB();	//创建数据库连接对象
		String sql1="select 图书编码,图书名称,优惠价格,购买数量,金额,购买日期,图片地址  from 购物车表1";
		ResultSet rs1=conn.executeQuery(sql1);	//查询全部商品信息
		List list1=new ArrayList();		
		try {
			while(rs1.next()){	
				CartInfo cart1=new CartInfo();	
				cart1.setGoodsCode(rs1.getString("图书编码"));
				cart1.setGoodsName(rs1.getString("图书名称"));
				cart1.setGoodsPreferentialPrice(rs1.getDouble("优惠价格"));
				cart1.setGoodsNumber(rs1.getInt("购买数量"));
				cart1.setGoodsSum(rs1.getDouble("金额"));	
				cart1.setBuyTime(rs1.getDate("购买日期"));
				cart1.setGoodsImageAddress(rs1.getString("图片地址"));
				list1.add(cart1);//将商品信息保存到List集合中	
			}					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql2="select sum(优惠价格*购买数量) as 金额合计,sum((价格-优惠价格)*购买数量) as 节省费用  from 购物车表1";
		ResultSet rs2=conn.executeQuery(sql2);
		List list2=new ArrayList();		
		try {
			if(rs2.next()){
				CartInfo cart2=new CartInfo();	
				cart2.setPayAll(rs2.getDouble("金额合计"));
				cart2.setPromotionAmount(rs2.getDouble("节省费用"));	
				list2.add(cart2);		//将购物信息保存到List集合中	
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		request.setAttribute("cartList1", list1);
		request.setAttribute("cartList2", list2);
		request.getRequestDispatcher("gwc.jsp").forward(request, response);	
	}
}
