package vo;

/**
 * Created by Administrator on 2017/4/8.
 */
//商品类
public class GoodVO {

    private int id;   //商品id
    private Double price;   //价格
    private String link;    //商品链接

//    private ProductType productTypeByTypeid;
    private String description;  //商品描述
    private String product_name;  //商品名称

public Double getCompetePrice() {
		return competePrice;
	}

	//    private Seller sellerBySellerid;
    private String seller_name;  // 商家名称
    private String platform;  //平台名称
    private Integer isJoin;   //是否加盟
    private Double competePrice; //商家竞价排名出价

    private int sales_volume;  //销量
    private int comments_volume; //评论量

    public GoodVO() {
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getSeller_name() {
        return seller_name;
    }

    public void setSeller_name(String seller_name) {
        this.seller_name = seller_name;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Integer getIsJoin() {
        return isJoin;
    }

    public void setIsJoin(Integer isJoin) {
        this.isJoin = isJoin;
    }

    public int getSales_volume() {
        return sales_volume;
    }

    public void setSales_volume(int sales_volume) {
        this.sales_volume = sales_volume;
    }

    public int getComments_volume() {
        return comments_volume;
    }

    public void setComments_volume(int comments_volume) {
        this.comments_volume = comments_volume;
    }
    

	public void setCompetePrice(Double competePrice) {
		this.competePrice = competePrice;
	}

}
