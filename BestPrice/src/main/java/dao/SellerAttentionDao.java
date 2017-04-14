package dao;

import Entity.Comment;
import Entity.Notify;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Hanifor on 4/10/2017.
 */
@Repository
public interface SellerAttentionDao {
    /**
     * 更新或添加商家关注词汇
     * @param id 商家id
     * @param keys 关注词汇
     */
    void updateKeyWords(int id, List<String> keys);

    /**
     * 获得商家关注词汇
     * @param id 商家id
     * @return
     */
    List<String> getKeyWords(int id);

    /**
     * 保存提醒信息
     * @param notify
     */
    void saveNotification(Notify notify);

    /**
     * 获得商家所有未读通知
     * @param id 商家id
     * @return
     */
    List<Comment> getNotifications(int id);
}
