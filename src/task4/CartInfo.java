package task4;

import java.util.Date;
public class CartInfo {
  // ͼ�����
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
  // �۸�
  private double goodsPrice=0.0;
  public double getGoodsPrice() {
    return goodsPrice;
  }
  public void setGoodsPrice(double price) {
    this.goodsPrice = price;
  }
  // �Żݼ۸�
    private Double goodsPreferentialPrice;
	public Double getGoodsPreferentialPrice() {
		return goodsPreferentialPrice;
	}
	public void setGoodsPreferentialPrice(Double newPrice) {
		this.goodsPreferentialPrice = newPrice;
	}
  // ��������
  private int goodsNumber=0;
  public int getGoodsNumber() {
    return goodsNumber;
  }
  public void setGoodsNumber(int num) {
    this.goodsNumber = num;
  }
  // ���
  private double goodsSum=0.0;
  public double getGoodsSum() {
    return goodsSum;
  }
  public void setGoodsSum(double money) {
    this.goodsSum = money;
  }
  //����ʱ��
  private Date buyTime = new Date();
  public Date getBuyTime() {
	return buyTime;
  }
  public void setBuyTime(Date buyTime) {
	this.buyTime = buyTime;
  }
  // ͼƬ��ַ
  private String goodsImageAddress;
  public String getGoodsImageAddress() {
    return goodsImageAddress;
  }
  public void setGoodsImageAddress(String address) {
    this.goodsImageAddress = address;
  }
  // ����ܼ�
  private double payAll=0.0;
  public double getPayAll() {
    return payAll;
  }
  public void setPayAll(double money) {
    this.payAll = money;
  }
  // �Żݽ��
  private double promotionAmount=0.0;
  public double getPromotionAmount() {
    return promotionAmount;
  }
  public void setPromotionAmount(double amount) {
    this.promotionAmount = amount;
  }
}
