package service.payStrategy;

/**
 * Created by Hanifor on 4/11/2017.
 */
public class BankPayStrategy implements PayStrategy {
    private String account;
    private String password;

    public BankPayStrategy(String account, String password){
        this.account = account;
        this.password = password;
    }

    public boolean pay(){
        return true;
    }
}
