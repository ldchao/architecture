package service.serviceimpl;

import Entity.Notify;
import dao.SellerAttentionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.SellerService;
import vo.CommentVO;

import java.util.List;

/**
 * Created by Hanifor on 4/10/2017.
 */
@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerAttentionDao sellerAttentionDao;

    public void updateKeyWords(int id, List<String> keys) {
        sellerAttentionDao.updateKeyWords(id, keys);
    }

    public List<String> getKeyWords(int id) {
        return sellerAttentionDao.getKeyWords(id);
    }

    public List<CommentVO> getNotification(int id) {
        return sellerAttentionDao.getNotifications(id);
    }
}
