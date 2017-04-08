package Entity;

import java.util.Date;

/**
 * Created by dlydd on 2017/4/8.
 */
public class DiaryRecord {

    private Date date;
    private String operation;

    public DiaryRecord(Date date, String operation) {
        this.date = date;
        this.operation = operation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
