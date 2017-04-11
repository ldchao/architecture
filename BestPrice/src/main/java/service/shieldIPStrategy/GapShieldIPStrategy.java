package service.shieldIPStrategy;

/**
 * Created by Hanifor on 4/11/2017.
 */
public class GapShieldIPStrategy implements ShieldIPStrategy {
    /**
     * ip访问频次是否正常
     * @param ip
     * @return
     */
    public boolean isUnsafe(String ip) {
        return false;
    }
}
