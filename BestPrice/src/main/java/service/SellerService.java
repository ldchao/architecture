package service;

import Entity.Notify;

import java.util.List;

/**
 * Created by Hanifor on 4/10/2017.
 */
public interface SellerService {
    /**
     * 更新商家关注词汇
     * @param id 商家id
     * @param keys 关注词汇
     */
    public void updateKeyWords(int id, List<String> keys);

    /**
     * 获取商家关注词汇
     * @param id 商家Id
     * @return
     */
    public List<String> getKeyWords(int id);

    /**
     * 获取商家提醒
     * @param id 商家id
     * @return
     */
    public List<Notify> getNotification(int id);
}