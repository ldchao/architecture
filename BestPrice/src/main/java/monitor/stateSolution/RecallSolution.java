package monitor.stateSolution;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by LeeKane on 17/4/8.
 */
public class RecallSolution implements StateSolution{

    public boolean solveState()throws Exception {
        int  timeOut =  10000 ;  //超时应该在10钞以上
        try {
            //当前为本机ip
            boolean status = InetAddress.getByName("127.0.0.1").isReachable(timeOut);// 当返回值是true时，说明host是可用的，false则不可。
            return  status;
        }
        catch (Exception e) {
            e.printStackTrace();   // 出现异常则返回假
            return false;
        }
    }
}
