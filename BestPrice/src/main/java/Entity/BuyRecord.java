package Entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by marioquer on 2017/4/10.
 */
@Entity
@IdClass(BuyRecordPK.class)
public class BuyRecord {
    private int productid;
    private int userid;
    private Date buydate;
    private Integer buynum;
    private Double totalPrice;
    private Product productByProductid;
    private User userByUserid;

    @Id
    @Column(name = "productid", nullable = false)
    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    @Id
    @Column(name = "userid", nullable = false)
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "buydate", nullable = true)
    public Date getBuydate() {
        return buydate;
    }

    public void setBuydate(Date buydate) {
        this.buydate = buydate;
    }

    @Basic
    @Column(name = "buynum", nullable = true)
    public Integer getBuynum() {
        return buynum;
    }

    public void setBuynum(Integer buynum) {
        this.buynum = buynum;
    }

    @Basic
    @Column(name = "totalPrice", nullable = true, precision = 0)
    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BuyRecord buyRecord = (BuyRecord) o;

        if (productid != buyRecord.productid) return false;
        if (userid != buyRecord.userid) return false;
        if (buydate != null ? !buydate.equals(buyRecord.buydate) : buyRecord.buydate != null) return false;
        if (buynum != null ? !buynum.equals(buyRecord.buynum) : buyRecord.buynum != null) return false;
        if (totalPrice != null ? !totalPrice.equals(buyRecord.totalPrice) : buyRecord.totalPrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productid;
        result = 31 * result + userid;
        result = 31 * result + (buydate != null ? buydate.hashCode() : 0);
        result = 31 * result + (buynum != null ? buynum.hashCode() : 0);
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "productid", referencedColumnName = "id", nullable = false)
    public Product getProductByProductid() {
        return productByProductid;
    }

    public void setProductByProductid(Product productByProductid) {
        this.productByProductid = productByProductid;
    }

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid", nullable = false)
    public User getUserByUserid() {
        return userByUserid;
    }

    public void setUserByUserid(User userByUserid) {
        this.userByUserid = userByUserid;
    }
}
