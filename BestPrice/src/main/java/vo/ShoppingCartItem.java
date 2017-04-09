package vo;

import java.io.Serializable;

/**
 * Created by lois on 2017/4/8.
 *
 * 购物车内容列表
 */
public class ShoppingCartItem implements Serializable{

    private int goodsId;
    private String goodsName;
    private double goodsPrice;
    private int number;


    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
