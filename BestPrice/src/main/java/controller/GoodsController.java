package controller;
import dao.daoimpl.BuyRecordDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.CommentService;
import service.PurchaseService;
import service.SearchGoodService;
import service.ShowGoodsService;
import service.payStrategy.AliPayStrategy;
import service.payStrategy.BankPayStrategy;
import vo.*;

import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

/**
 * Created by Xuanlin on 2017/4/12.
 */
@Controller
@RequestMapping(value = "/goods")
public class GoodsController{
    private String success = "success";
    @Autowired
    ShowGoodsService showGoodsService;
    @Autowired
    SearchGoodService searchGoodService;
    @Autowired
    PurchaseService purchaseService;

    @RequestMapping(value ="/showGoodsInfo")
    public ModelAndView showGoodsInfo(int GoodId, HttpServletRequest request) {
//        ServletContext sc = request.getServletContext();
        ModelAndView modelAndView=new ModelAndView();
        GoodVO goodVO = showGoodsService.getByGoodId(GoodId);
        modelAndView.addObject("GoodVO",goodVO);
//        String goodid=Integer.toString(GoodId);
//        String price=Double.toString(goodVO.getPrice());
//        String description=goodVO.getDescription();
//        String product_name=goodVO.getProduct_name();
//        String seller_name=goodVO.getSeller_name();
//        String platform=goodVO.getPlatform();
//        String isJoin=pickIsJoin(goodVO.getIsJoin());
//
//        sc.setAttribute("goodid", goodid);
//        sc.setAttribute("price",price);
//        sc.setAttribute("description",description);
//        sc.setAttribute("product_name",product_name);
//        sc.setAttribute("seller_name",seller_name);
//        sc.setAttribute("platform",platform);
//        sc.setAttribute("isJoin",isJoin);
//        sc.setAttribute("sales_volume",goodVO.getSales_volume());
//        sc.setAttribute("comments_volume",goodVO.getComments_volume());
//
//
//        List<CommentVO> cl=showGoodsService.getCommentByGoodId(GoodId);
//        List<BuyRecordVO> bl =showGoodsService.getByShopId(GoodId);
//
//        String[] comment_date = new String[cl.size()];
//        String[] comment_UsersId=new String[cl.size()];
//        String[] comment_content = new String[cl.size()];
//
//
//        String[] buy_UserId = new String[bl.size()];
//        String[] buy_date= new String[bl.size()];
//        String[] buy_price= new String[bl.size()];
//        String[] buy_num= new String[bl.size()];
//
//
//        for(int i = 0;i<cl.size();i++){
//            comment_date[i]=cl.get(i).getTime();
//            comment_UsersId[i]=Integer.toString(cl.get(i).getUserid());
//            comment_content[i]=cl.get(i).getContent();
//
//            System.out.println(cl.get(i).getTime());
//            System.out.println(cl.get(i).getUserid());
//            System.out.println(cl.get(i).getContent());
//        }
//
//        for(int i = 0;i<bl.size();i++){
//            buy_UserId[i]=Integer.toString(bl.get(i).getUserid());
//            buy_date[i] =bl.get(i).getBuydate();
//            buy_price[i]=Double.toString(bl.get(i).getTotalPrice());
//            buy_num [i]=Integer.toString(bl.get(i).getBuynum());
//        }
//
//        sc.setAttribute("comment_date", comment_date);
//        sc.setAttribute("comment_UsersId", comment_UsersId);
//        sc.setAttribute("comment_content", comment_content);
//        sc.setAttribute("num_comment", comment_date.length);  //次数
//        sc.setAttribute("buy_UserId", buy_UserId);
//        sc.setAttribute("buy_date", buy_date);
//        sc.setAttribute("buy_price", buy_price);
//        sc.setAttribute("buy_num", buy_num);
//        sc.setAttribute("num_buy", buy_date.length); //次数
//
//
//
//        return success;
        return modelAndView;

    }

    /**
     * 用银行账号购买
     * @param cart
     * @param account
     * @param password
     * @param request
     * @return 购买记录，当账号无效时返回Null
     */
    @RequestMapping(value ="/buyGoods/bank")
    @ResponseBody
    public List<BuyRecordVO> buyGoodsWithBank(ShoppingCart cart, String account, String password, HttpServletRequest request) {
        Object o = request.getSession().getAttribute("user");
        return purchaseService.create(((UserVO)o).getUserid(), cart, new BankPayStrategy(account, password));
    }

    /**
     * 用支付宝购买
     * @param cart
     * @param account
     * @param password
     * @param request
     * @return 购买记录，当账号无效时返回Null
     */
    @RequestMapping(value ="/buyGoods/alipay")
    @ResponseBody
    public List<BuyRecordVO> buyGoodsWithAlipay(ShoppingCart cart, String account, String password, HttpServletRequest request) {
        Object o = request.getSession().getAttribute("user");
        return purchaseService.create(((UserVO)o).getUserid(), cart, new AliPayStrategy(account, password));
    }

    @RequestMapping(value ="/searchGoods")
    @ResponseBody
    public List<GoodVO> searchGood(String key){
        List<GoodVO> goodVOS = searchGoodService.searchGoods(key);
        return goodVOS;
    }

    @RequestMapping(value ="/sortSearchResult")
    @ResponseBody
    public List<GoodVO> sortSearchResult(String sortRule){
        List<GoodVO> goodVOS = searchGoodService.sortResult(sortRule);
        return goodVOS;
    }

    @RequestMapping(value ="/shieldSearchResult")
    @ResponseBody
    public List<GoodVO> shieldSearchResult(String condition){
        List<GoodVO> goodVOS = searchGoodService.shieldGoods(condition);
        return goodVOS;
    }

    @RequestMapping(value ="/cancleShieldSearchResult")
    @ResponseBody
    public List<GoodVO> cancleShieldSearchResult(String condition){
        List<GoodVO> goodVOS = searchGoodService.cancleShield(condition);
        return goodVOS;
    }

    private String pickIsJoin(Integer isJoin){
        if(isJoin==null){
            return "未加入";
        }else{
            return "已加入";
        }
    }
}
