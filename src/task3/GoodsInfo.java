package task3;

public class GoodsInfo {
	  //ͼ�����
	  private String goodsCode="";
	  public String getGoodsCode() {
	    return goodsCode;
	  }
	  public void setGoodsCode(String code) {
	    this.goodsCode = code;
	  }
	  // ͼ������
	  private String goodsName="";
	  public String getGoodsName() {
	    return goodsName;
	  }
	  public void setGoodsName(String name) {
	   this.goodsName = name;
	  }
	// ����
		  private String goodsAuthor="";
		  public String getGoodsAuthor() {
		    return goodsAuthor;
		  }
		 public void setGoodsAuthor(String author) {
		   this.goodsAuthor = author;
		  }
	  // �۸�
	  private double goodsPrice=0.0;
	  public double getGoodsPrice() {
	    return goodsPrice;
	  }
	  public void setGoodsPrice(double price) {
	    this.goodsPrice = price;
	  }
	  // ͼƬ��ַ
	  private String goodsImageAddress;
	  public String getGoodsImageAddress() {
	    return goodsImageAddress;
	  }
	  public void setGoodsImageAddress(String address) {
	    this.goodsImageAddress = address;
	  }
	  
	  //����
	  private String goodsType;
	  public String getGoodsType() {
	    return goodsType;
	  }
	  public void setGoodsType(String type) {
	    this.goodsType = type;
	  }
	  
}
