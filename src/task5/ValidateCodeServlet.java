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

	 private static int WIDTH = 65;//设置图片的宽度   
	  
	 private static int HEIGHT = 22;//设置图片的高度 
    public ValidateCodeServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*//禁止页面缓存
	 	response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");		//设置响应正文的MIME类型为图片
		int width=60, height=20;  
		*//**创建一个位于缓存中的图像，宽度60，高度20 *//*  
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);   	
		Graphics g = image.getGraphics();      		//获取用于处理图形上下文的对象，相当于画笔
		Random random = new Random();        		//创建生成随机数的对象
		g.setColor(getRandomColor(200,250));  	  	//设置图像的背景色
		g.fillRect(0, 0, width, height);            //画一个矩形	，坐标（0，0），宽度60，高度20 
		g.setFont(new Font("Times New Roman",Font.PLAIN,18)); 	//设定字体格式
		g.setColor(getRandomColor(160,200));
		for(int i=0;i<130;i++){                     //产生130条随机干扰线
			int x = random.nextInt(width);   
			int y = random.nextInt(height);   
			int xl = random.nextInt(12);   
			int yl = random.nextInt(12);   
			g.drawLine(x,y,x+xl,y+yl);          	//在图象的坐标（x,y）和坐标（x+x1,y+y1）之间画干扰线 
		} 
		String strCode="";  
		for (int i=0;i<4;i++){   
			String strNumber=String.valueOf(random.nextInt(10)); //把随机数转换成String字符串
			strCode=strCode+strNumber;
			//设置字体的颜色
			g.setColor(new Color(15+random.nextInt(120),15+random.nextInt(120),15+random.nextInt(120)));
			g.drawString(strNumber,13*i+6,16);       //将验证码依次画到图像上,坐标（x=13*i+6,y=16）
		}
		request.getSession().setAttribute("randomCode",strCode);       	//把验证码保存到Session中   
		g.dispose();  //释放此图像的上下文以及它使用的所有系统资源
		ImageIO.write(image, "JPEG", response.getOutputStream()); 	//输出JPEG格式的图像    
		response.getOutputStream().flush();                     	//刷新输出流 
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
