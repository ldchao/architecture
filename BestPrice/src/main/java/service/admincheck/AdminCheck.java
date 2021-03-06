package service.admincheck;

import Entity.Comment;
import Entity.User;
import dao.SensitiveCommentDao;
import dao.WaterUserDao;
import dao.daoimpl.SensitiveCommentDaoImpl;
import dao.daoimpl.WaterUserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.admincheck.freezestrategy.FreezeStrategy;
import service.admincheck.freezestrategy.LogoffStrategy;
import service.admincheck.freezestrategy.LongFreezeStrategy;
import service.admincheck.freezestrategy.ShortFreezeStrategy;

import java.util.ArrayList;

/**
 * Created by L.H.S on 2017/4/9.
 */

@Service
public class AdminCheck {

    private SensitiveCommentDao sensitiveCommentDao = new SensitiveCommentDaoImpl();
    private WaterUserDao waterUserDao = new WaterUserDaoImpl();

    // 获取待审核敏感评论
    public ArrayList<Comment> getSenComment() {

        return (ArrayList<Comment>) sensitiveCommentDao.getSenComment();
    }

    // 获取待审核水军
    public ArrayList<User> getWaterUser() {

        return waterUserDao.getWater();
    }

    // 若是敏感评论，则删除敏感评论；
    public void deleteSenComment(int comId) {

        sensitiveCommentDao.deleteSenComment(comId);
    }

    // 若评论不是敏感评论，则调用正常的发布接口，并从潜在敏感评论表中删除
    public void publishSenComment(int comId) {

        sensitiveCommentDao.releaseSenComment(comId);
    }

    // 冻结水军用户，短期/长期/永久
    // 此处用 never
    public void freezeUser(int userId, String freezeType) {

        FreezeStrategy freeze;
        if (freezeType.equals("short")) {
            freeze = new ShortFreezeStrategy();
        } else if (freezeType.equals("long")) {
            freeze = new LongFreezeStrategy();
        } else {
            freeze = new LogoffStrategy();
        }

        freeze.freezeUser(userId);
    }

    // 若不是水军用户，则直接从潜在水军表中删除
    public void realeaseWater(int userId) {

        waterUserDao.releaseWaterUser(userId);
    }
}
