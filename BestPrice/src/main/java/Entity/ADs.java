package Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by marioquer on 2017/4/10.
 */
@Entity
public class ADs {
    private int id;
    private Integer type;
    private String targetlink;
    private String piclink;
    private Date starttime;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type", nullable = true)
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "targetlink", nullable = true, length = 300)
    public String getTargetlink() {
        return targetlink;
    }

    public void setTargetlink(String targetlink) {
        this.targetlink = targetlink;
    }

    @Basic
    @Column(name = "piclink", nullable = true, length = 300)
    public String getPiclink() {
        return piclink;
    }

    public void setPiclink(String piclink) {
        this.piclink = piclink;
    }

    @Basic
    @Column(name = "starttime", nullable = true)
    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ADs aDs = (ADs) o;

        if (id != aDs.id) return false;
        if (type != null ? !type.equals(aDs.type) : aDs.type != null) return false;
        if (targetlink != null ? !targetlink.equals(aDs.targetlink) : aDs.targetlink != null) return false;
        if (piclink != null ? !piclink.equals(aDs.piclink) : aDs.piclink != null) return false;
        if (starttime != null ? !starttime.equals(aDs.starttime) : aDs.starttime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (targetlink != null ? targetlink.hashCode() : 0);
        result = 31 * result + (piclink != null ? piclink.hashCode() : 0);
        result = 31 * result + (starttime != null ? starttime.hashCode() : 0);
        return result;
    }
}
