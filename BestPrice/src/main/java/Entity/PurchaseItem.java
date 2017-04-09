package Entity;

import javax.persistence.Id;

/**
 * Created by lois on 2017/4/8.
 *
 * 购买商品模块
 * 商品列表
 */
public class PurchaseItem {


    private int id;
    //TODO
//    private Goods goods;
    private Purchase purchase;
    private int number;
    private double price;

    @Id
    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
