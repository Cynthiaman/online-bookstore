package task3;

public class GoodsInfo {
	  //图书编码
	  private String goodsCode="";
	  public String getGoodsCode() {
	    return goodsCode;
	  }
	  public void setGoodsCode(String code) {
	    this.goodsCode = code;
	  }
	  // 图书名称
	  private String goodsName="";
	  public String getGoodsName() {
	    return goodsName;
	  }
	  public void setGoodsName(String name) {
	   this.goodsName = name;
	  }
	// 作者
		  private String goodsAuthor="";
		  public String getGoodsAuthor() {
		    return goodsAuthor;
		  }
		 public void setGoodsAuthor(String author) {
		   this.goodsAuthor = author;
		  }
	  // 价格
	  private double goodsPrice=0.0;
	  public double getGoodsPrice() {
	    return goodsPrice;
	  }
	  public void setGoodsPrice(double price) {
	    this.goodsPrice = price;
	  }
	  // 图片地址
	  private String goodsImageAddress;
	  public String getGoodsImageAddress() {
	    return goodsImageAddress;
	  }
	  public void setGoodsImageAddress(String address) {
	    this.goodsImageAddress = address;
	  }
	  
	  //类型
	  private String goodsType;
	  public String getGoodsType() {
	    return goodsType;
	  }
	  public void setGoodsType(String type) {
	    this.goodsType = type;
	  }
	  
}
