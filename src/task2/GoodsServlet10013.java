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
	
	
		ConnDB conn=new ConnDB();	//�������ݿ����Ӷ���	
		String sql=null;
		if (name==null || name.isEmpty()) {	
			sql="select * from ͼ������� ";
		}
		else{
		 //  sql="select top " + num + " ͼ�����,ͼ������,����,�۸�,ͼƬ��ַ from ͼ�����ݱ�  where ͼ������ like '%" + name + "%' or ���� like '%" + name + "%'";
			 sql="select * from ͼ�������   where ͼ������  like '%" + name + "%'";
		}
		System.out.print(sql);
		ResultSet rs=conn.executeQuery(sql);	//��ѯȫ����Ʒ��Ϣ
		List list=new ArrayList();
		try {
			while(rs.next()){
				GoodsInfo1 goods=new GoodsInfo1();				
				goods.setGoodsName(rs.getString("ͼ������"));
				goods.setGoodsAuthor(rs.getString("����"));
				goods.setGoodsPublish(rs.getString("������"));
				goods.setGoodsDate(rs.getString("��������"));
				goods.setGoodsPreferentialPrice(rs.getDouble("�Żݼ۸�"));
				goods.setGoodsBrief(rs.getString("ͼ����"));
				goods.setGoodsPrice(rs.getDouble("�۸�"));
				goods.setGoodsImageAddress(rs.getString("ͼƬ��ַ"));
				goods.setGoodsImageAddress1(rs.getString("СͼƬ��ַ1"));
				goods.setGoodsImageAddress2(rs.getString("СͼƬ��ַ2"));
				goods.setGoodsImageAddress3(rs.getString("СͼƬ��ַ3"));
				list.add(goods);		//����Ʒ��Ϣ���浽List������
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (name==null || name.isEmpty()) {	
		   sql="select count(*) from ͼ�������  ";
		   request.setAttribute("searchName", "ȫ��ͼ��");
		}
		else{
		 
			sql="select  count(*) from ͼ�������  where ͼ������  like '%" + name + "%'";
			request.setAttribute("searchName", name);
		}
		rs=conn.executeQuery(sql);	//��ѯȫ����Ʒ��Ϣ
		
		try {
			if(rs.next()){
				request.setAttribute("goodsCount", rs.getInt(1));
			}
			else{
				request.setAttribute("goodsCount",0);
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		request.setAttribute("goodsList", list);		//����Ʒ��Ϣ���浽HttpServletRequest��
		request.getRequestDispatcher("details.jsp").forward(request, response);		//�ض���ҳ��
	}	
}
