package Entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by marioquer on 2017/4/10.
 */
public class BuyRecordPK implements Serializable {
    private int productid;
    private int userid;

    @Column(name = "productid", nullable = false)
    @Id
    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    @Column(name = "userid", nullable = false)
    @Id
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BuyRecordPK that = (BuyRecordPK) o;

        if (productid != that.productid) return false;
        if (userid != that.userid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productid;
        result = 31 * result + userid;
        return result;
    }
}
