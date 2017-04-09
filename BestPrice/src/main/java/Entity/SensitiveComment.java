package Entity;

/**
 * Created by L.H.S on 2017/4/9.
 */
public class SensitiveComment {

    private int senId;
    private String comment;
    private int userId;

    public SensitiveComment(int senId, String comment, int userId) {
        this.senId = senId;
        this.comment = comment;
        this.userId = userId;
    }

    public int getSenId() {
        return senId;
    }

    public void setSenId(int senId) {
        this.senId = senId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
