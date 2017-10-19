package task5;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ValidateCodeServlet
 */

public class ValidateCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 private static int WIDTH = 65;//����ͼƬ�Ŀ��   
	  
	 private static int HEIGHT = 22;//����ͼƬ�ĸ߶� 
    public ValidateCodeServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*//��ֹҳ�滺��
	 	response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");		//������Ӧ���ĵ�MIME����ΪͼƬ
		int width=60, height=20;  
		*//**����һ��λ�ڻ����е�ͼ�񣬿��60���߶�20 *//*  
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);   	
		Graphics g = image.getGraphics();      		//��ȡ���ڴ���ͼ�������ĵĶ����൱�ڻ���
		Random random = new Random();        		//��������������Ķ���
		g.setColor(getRandomColor(200,250));  	  	//����ͼ��ı���ɫ
		g.fillRect(0, 0, width, height);            //��һ������	�����꣨0��0�������60���߶�20 
		g.setFont(new Font("Times New Roman",Font.PLAIN,18)); 	//�趨�����ʽ
		g.setColor(getRandomColor(160,200));
		for(int i=0;i<130;i++){                     //����130�����������
			int x = random.nextInt(width);   
			int y = random.nextInt(height);   
			int xl = random.nextInt(12);   
			int yl = random.nextInt(12);   
			g.drawLine(x,y,x+xl,y+yl);          	//��ͼ������꣨x,y�������꣨x+x1,y+y1��֮�仭������ 
		} 
		String strCode="";  
		for (int i=0;i<4;i++){   
			String strNumber=String.valueOf(random.nextInt(10)); //�������ת����String�ַ���
			strCode=strCode+strNumber;
			//�����������ɫ
			g.setColor(new Color(15+random.nextInt(120),15+random.nextInt(120),15+random.nextInt(120)));
			g.drawString(strNumber,13*i+6,16);       //����֤�����λ���ͼ����,���꣨x=13*i+6,y=16��
		}
		request.getSession().setAttribute("randomCode",strCode);       	//����֤�뱣�浽Session��   
		g.dispose();  //�ͷŴ�ͼ����������Լ���ʹ�õ�����ϵͳ��Դ
		ImageIO.write(image, "JPEG", response.getOutputStream()); 	//���JPEG��ʽ��ͼ��    
		response.getOutputStream().flush();                     	//ˢ������� 
		response.getOutputStream().close(); 	*/
		
		
	  HttpSession session = request.getSession();   
	  response.setContentType("image/jpeg");   
	  ServletOutputStream sos = response.getOutputStream();   
	  response.setHeader("Pragma", "No-cache");   
	  response.setHeader("Cache-Control", "no-cache");   
	  response.setDateHeader("Expires", 0);   
	  BufferedImage image = new BufferedImage(WIDTH, HEIGHT,BufferedImage.TYPE_INT_RGB);   
	  Graphics g = image.getGraphics();   
	  char[] rands = generateCheckCode();   
	  drawBackground(g);   
	  drawRands(g, rands);   
	  g.dispose();   
	  ByteArrayOutputStream bos = new ByteArrayOutputStream();   
	  ImageIO.write(image, "JPEG", bos);   
	  byte[] buf = bos.toByteArray();   
	  response.setContentLength(buf.length);   
	  sos.write(buf);   
	  bos.close();   
	  sos.close();   
	  session.setAttribute("randomCode", new String(rands));   
	  }   
		
	   private void drawBackground(Graphics g) {   
		g.setColor(new Color(0xDCDCDC));   
		g.fillRect(0, 0, WIDTH, HEIGHT);   
		for (int i = 0; i < 120; i++) {   
		 int x = (int) (Math.random() * WIDTH);   
		 int y = (int) (Math.random() * HEIGHT);   
		 int red = (int) (Math.random() * 255);   
		 int green = (int) (Math.random() * 255);   
		 int blue = (int) (Math.random() * 255);   
		 g.setColor(new Color(red, green, blue));   
		 g.drawOval(x, y, 1, 0);   
		}   
	   }   
		
	   private void drawRands(Graphics g, char[] rands) {   
		// g.setColor(Color.BLUE);   
		Random random = new Random();   
		int red = random.nextInt(110);   
		int green = random.nextInt(50);   
		int blue = random.nextInt(50);   
		g.setColor(new Color(red, green, blue));   
		g.setFont(new Font(null, Font.ITALIC | Font.BOLD, 18));   
		g.drawString("" + rands[0], 1, 17);   
		g.drawString("" + rands[1], 16, 15);   
		g.drawString("" + rands[2], 31, 18);   
		g.drawString("" + rands[3], 46, 16);   
	   }   
		
	   private char[] generateCheckCode() {   
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";   
		char[] rands = new char[4];   
		for (int i = 0; i < 4; i++) {   
		 int rand = (int) (Math.random() * 36);   
		 rands[i] = chars.charAt(rand);   
		}   
		return rands;   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);

	}
	
	
}
