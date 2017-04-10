package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by marioquer on 2017/4/10.
 */
@Entity
public class SensitiveWord {
    private String word;

    @Id
    @Column(name = "word", nullable = false, length = 11)
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

        SensitiveWord that = (SensitiveWord) o;

        if (word != null ? !word.equals(that.word) : that.word != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return word != null ? word.hashCode() : 0;
    }
}
