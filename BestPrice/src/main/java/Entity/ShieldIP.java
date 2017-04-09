package Entity;

import javax.persistence.Id;

/**
 * Created by lois on 2017/4/9.
 */
public class ShieldIP {

    private int id;
    private String ip;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
