package service;

import java.util.List;

import vo.BuyRecordVO;
import vo.CommentVO;
import vo.GoodInfo;
import vo.GoodVO;

/**
 * Created by Xuanlin on 2017/4/9.
 */

public interface ShowGoodsInfoService {

    /**
     * 根据商品id返回一条商品信息
     * @param goodId
     * @return 商品信息
     */
    public GoodVO getByGoodId(int goodId);

    /**
     * 根据商品ID返回所有评论信息
     * @param goodId
     * @return  评论列表
     */
    public List<CommentVO> getCommentByGoodId(int goodId);


    /**
     * 返回商品ID返回所有购买记录
     * @param goodId
     * @return  购买记录
     */
    public List<BuyRecordVO> getByShopId(int goodId);

}