package Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by dlydd on 2017/4/12.
 */
@Entity
public class BuyRecord {
    private int id;
    private Date buydate;
    private Integer buynum;
    private Double totalPrice;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

        if (id != buyRecord.id) return false;
        if (buydate != null ? !buydate.equals(buyRecord.buydate) : buyRecord.buydate != null) return false;
        if (buynum != null ? !buynum.equals(buyRecord.buynum) : buyRecord.buynum != null) return false;
        if (totalPrice != null ? !totalPrice.equals(buyRecord.totalPrice) : buyRecord.totalPrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (buydate != null ? buydate.hashCode() : 0);
        result = 31 * result + (buynum != null ? buynum.hashCode() : 0);
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        return result;
    }
}
