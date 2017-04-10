package Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by marioquer on 2017/4/10.
 */
@Entity
public class Ip {
    private int id;
    private String ip;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ip", nullable = true, length = 30)
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ip ip1 = (Ip) o;

        if (id != ip1.id) return false;
        if (ip != null ? !ip.equals(ip1.ip) : ip1.ip != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ip != null ? ip.hashCode() : 0);
        return result;
    }
}
