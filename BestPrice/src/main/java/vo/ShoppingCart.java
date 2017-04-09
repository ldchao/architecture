package vo;

import java.util.List;

/**
 * Created by lois on 2017/4/8.
 *
 * 购物车
 */
public class ShoppingCart {

    private List<ShoppingCartItem> shoppingCartItems;


    public List<ShoppingCartItem> getShoppingCartItems() {
        return shoppingCartItems;
    }

    public void setShoppingCartItems(List<ShoppingCartItem> shoppingCartItems) {
        this.shoppingCartItems = shoppingCartItems;
    }
}
