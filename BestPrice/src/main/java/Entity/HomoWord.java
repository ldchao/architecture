package Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by marioquer on 2017/4/10.
 */
@Entity
public class HomoWord {
    private String word;
    private Integer groupid;

    @Id
    @Column(name = "word", nullable = false, length = 11)
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Basic
    @Column(name = "groupid", nullable = true)
    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HomoWord homoWord = (HomoWord) o;

        if (word != null ? !word.equals(homoWord.word) : homoWord.word != null) return false;
        if (groupid != null ? !groupid.equals(homoWord.groupid) : homoWord.groupid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = word != null ? word.hashCode() : 0;
        result = 31 * result + (groupid != null ? groupid.hashCode() : 0);
        return result;
    }
}
