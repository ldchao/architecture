package Entity;

import javax.persistence.*;

/**
 * Created by marioquer on 2017/4/10.
 */
@Entity
public class Notify {
    private int id;
    private Integer isDeal;
    private Seller sellerBySellerid;

    private int commentid;
    private int sellerid;

    public int getCommentid() {
        return commentid;
    }

    public void setCommentid(int commentid) {
        this.commentid = commentid;
    }

    public int getSellerid() {
        return sellerid;
    }

    public void setSellerid(int sellerid) {
        this.sellerid = sellerid;
    }

    public Notify(){}

    public Notify(Seller seller, int commentid){
        this.sellerBySellerid = seller;
        this.commentid = commentid;
        this.sellerid = seller.getId();
        this.isDeal = 0;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "isDeal", nullable = true)
    public Integer getIsDeal() {
        return isDeal;
    }

    public void setIsDeal(Integer isDeal) {
        this.isDeal = isDeal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notify notify = (Notify) o;

        if (id != notify.id) return false;
        if (isDeal != null ? !isDeal.equals(notify.isDeal) : notify.isDeal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (isDeal != null ? isDeal.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "sellerid", referencedColumnName = "id")
    public Seller getSellerBySellerid() {
        return sellerBySellerid;
    }

    public void setSellerBySellerid(Seller sellerBySellerid) {
        this.sellerBySellerid = sellerBySellerid;
    }
}
