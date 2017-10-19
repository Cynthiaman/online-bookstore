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
		ConnDB conn=new ConnDB();	//�������ݿ����Ӷ���
		String sql1="select ͼ�����,ͼ������,�Żݼ۸�,��������,���,��������,ͼƬ��ַ  from ���ﳵ��1";
		ResultSet rs1=conn.executeQuery(sql1);	//��ѯȫ����Ʒ��Ϣ
		List list1=new ArrayList();		
		try {
			while(rs1.next()){	
				CartInfo cart1=new CartInfo();	
				cart1.setGoodsCode(rs1.getString("ͼ�����"));
				cart1.setGoodsName(rs1.getString("ͼ������"));
				cart1.setGoodsPreferentialPrice(rs1.getDouble("�Żݼ۸�"));
				cart1.setGoodsNumber(rs1.getInt("��������"));
				cart1.setGoodsSum(rs1.getDouble("���"));	
				cart1.setBuyTime(rs1.getDate("��������"));
				cart1.setGoodsImageAddress(rs1.getString("ͼƬ��ַ"));
				list1.add(cart1);//����Ʒ��Ϣ���浽List������	
			}					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql2="select sum(�Żݼ۸�*��������) as ���ϼ�,sum((�۸�-�Żݼ۸�)*��������) as ��ʡ����  from ���ﳵ��1";
		ResultSet rs2=conn.executeQuery(sql2);
		List list2=new ArrayList();		
		try {
			if(rs2.next()){
				CartInfo cart2=new CartInfo();	
				cart2.setPayAll(rs2.getDouble("���ϼ�"));
				cart2.setPromotionAmount(rs2.getDouble("��ʡ����"));	
				list2.add(cart2);		//��������Ϣ���浽List������	
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
