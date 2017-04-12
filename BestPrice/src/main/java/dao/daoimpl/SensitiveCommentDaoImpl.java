package dao.daoimpl;

import Entity.Comment;
import dao.daoservice.SensitiveCommentService;

import java.util.List;

/**
 * Created by L.H.S on 2017/4/9.
 */
public class SensitiveCommentDaoImpl implements SensitiveCommentService {

    public int saveSenComment(String comment, int userId, int comId) {
        return 0;
    }

    public List<Comment> getSenComment() {
        return null;
    }

    public void deleteSenComment(int comId) {

    }

    public void releaseSenComment(int comId) {

    }
}
