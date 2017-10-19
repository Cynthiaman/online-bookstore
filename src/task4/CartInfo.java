package task4;

import java.util.Date;
public class CartInfo {
  // 图书编码
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
  // 价格
  private double goodsPrice=0.0;
  public double getGoodsPrice() {
    return goodsPrice;
  }
  public void setGoodsPrice(double price) {
    this.goodsPrice = price;
  }
  // 优惠价格
    private Double goodsPreferentialPrice;
	public Double getGoodsPreferentialPrice() {
		return goodsPreferentialPrice;
	}
	public void setGoodsPreferentialPrice(Double newPrice) {
		this.goodsPreferentialPrice = newPrice;
	}
  // 购买数量
  private int goodsNumber=0;
  public int getGoodsNumber() {
    return goodsNumber;
  }
  public void setGoodsNumber(int num) {
    this.goodsNumber = num;
  }
  // 金额
  private double goodsSum=0.0;
  public double getGoodsSum() {
    return goodsSum;
  }
  public void setGoodsSum(double money) {
    this.goodsSum = money;
  }
  //购买时间
  private Date buyTime = new Date();
  public Date getBuyTime() {
	return buyTime;
  }
  public void setBuyTime(Date buyTime) {
	this.buyTime = buyTime;
  }
  // 图片地址
  private String goodsImageAddress;
  public String getGoodsImageAddress() {
    return goodsImageAddress;
  }
  public void setGoodsImageAddress(String address) {
    this.goodsImageAddress = address;
  }
  // 金额总计
  private double payAll=0.0;
  public double getPayAll() {
    return payAll;
  }
  public void setPayAll(double money) {
    this.payAll = money;
  }
  // 优惠金额
  private double promotionAmount=0.0;
  public double getPromotionAmount() {
    return promotionAmount;
  }
  public void setPromotionAmount(double amount) {
    this.promotionAmount = amount;
  }
}
