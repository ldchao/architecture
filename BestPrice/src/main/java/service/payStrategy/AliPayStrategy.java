package service.payStrategy;

/**
 * Created by Hanifor on 4/11/2017.
 */
public class AliPayStrategy implements PayStrategy{
    private String account;
    private String password;

    public AliPayStrategy(String account, String password){
        this.account = account;
        this.password = password;
    }

    public boolean pay() {
        return true;
    }
}