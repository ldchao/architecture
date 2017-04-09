package dao.daoimpl;

import dao.daoservice.SensitiveCommentService;

import java.util.List;

/**
 * Created by L.H.S on 2017/4/9.
 */
public class SensitiveComment implements SensitiveCommentService {

    public int saveSenComment(String comment, int userId) {
        return 0;
    }

    public List<Entity.SensitiveComment> getSenComment() {
        return null;
    }

    public void deleteSenComment(int senId) {

    }

    public void releaseSenComment(int senId) {

    }
}
