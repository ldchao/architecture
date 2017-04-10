package Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by marioquer on 2017/4/10.
 */
@Entity
public class Seller {
    private int id;
    private String name;
    private String platform;
    private Integer isJoin;
    private Double competePrice;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "platform", nullable = true, length = 30)
    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Basic
    @Column(name = "isJoin", nullable = true)
    public Integer getIsJoin() {
        return isJoin;
    }

    public void setIsJoin(Integer isJoin) {
        this.isJoin = isJoin;
    }

    @Basic
    @Column(name = "competePrice", nullable = true, precision = 0)
    public Double getCompetePrice() {
        return competePrice;
    }

    public void setCompetePrice(Double competePrice) {
        this.competePrice = competePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seller seller = (Seller) o;

        if (id != seller.id) return false;
        if (name != null ? !name.equals(seller.name) : seller.name != null) return false;
        if (platform != null ? !platform.equals(seller.platform) : seller.platform != null) return false;
        if (isJoin != null ? !isJoin.equals(seller.isJoin) : seller.isJoin != null) return false;
        if (competePrice != null ? !competePrice.equals(seller.competePrice) : seller.competePrice != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (platform != null ? platform.hashCode() : 0);
        result = 31 * result + (isJoin != null ? isJoin.hashCode() : 0);
        result = 31 * result + (competePrice != null ? competePrice.hashCode() : 0);
        return result;
    }
}
