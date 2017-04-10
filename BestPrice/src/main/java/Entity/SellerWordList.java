package Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by marioquer on 2017/4/10.
 */
@Entity
public class SellerWordList {
    private int id;
    private Integer sellerid;
    private String word;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "sellerid", nullable = true)
    public Integer getSellerid() {
        return sellerid;
    }

    public void setSellerid(Integer sellerid) {
        this.sellerid = sellerid;
    }

    @Basic
    @Column(name = "word", nullable = true, length = -1)
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SellerWordList that = (SellerWordList) o;

        if (id != that.id) return false;
        if (sellerid != null ? !sellerid.equals(that.sellerid) : that.sellerid != null) return false;
        if (word != null ? !word.equals(that.word) : that.word != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (sellerid != null ? sellerid.hashCode() : 0);
        result = 31 * result + (word != null ? word.hashCode() : 0);
        return result;
    }
}
