package vo;

import Entity.BuyRecord;

import java.sql.Date;

/**
 * Created by Administrator on 2017/4/11.
 */
public class BuyRecordVO {

    private int productid;
    private int userid;
    private String buydate;
    private Integer buynum;
    private Double totalPrice;

    public BuyRecordVO() {
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getBuydate() {
        return buydate;
    }

    public void setBuydate(String buydate) {
        this.buydate = buydate;
    }

    public Integer getBuynum() {
        return buynum;
    }

    public void setBuynum(Integer buynum) {
        this.buynum = buynum;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BuyRecord makeBuyRecord(){
        BuyRecord buyRecord=new BuyRecord();
        buyRecord.setProductid(productid);
        buyRecord.setUserid(userid);
        buyRecord.setBuydate(Date.valueOf(buydate));
        buyRecord.setBuynum(buynum);
        buyRecord.setTotalPrice(totalPrice);
        return buyRecord;
    }

    public void update(BuyRecord buyRecord){
        this.productid=buyRecord.get();
        this.userid=buyRecord.getUserid();
        this.buydate=buyRecord.getBuydate().toString();
        this.buynum=buyRecord.getBuynum();
        this.totalPrice=buyRecord.getTotalPrice();
    }
}
