package vo;

import java.io.Serializable;

/**
 * Created by Xuanlin on 2017/4/9.
 */

public class GoodInfo implements Serializable{

    private int id;
    private int shopid;
    private String name;
    private String description;
    private double price;

    public GoodInfo(int shopid,String name,String description,double price) {
        this.shopid=shopid;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShopid() {
        return shopid;
    }

    public void setShopid(int shopid) {
        this.shopid = shopid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
