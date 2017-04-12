package dao;

import vo.GoodVO;

/**
 * Created by ldchao on 2017/4/12.
 */
public interface CheckGoodDao {

    /**
     * 通过商品id得到商品信息
     * @param goodId
     * @return
     */
    public GoodVO getGoodByGoodId(int goodId);

}
