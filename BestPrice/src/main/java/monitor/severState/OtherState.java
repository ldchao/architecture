package monitor.severState;

import monitor.stateSolution.StateSolution;

/**
 * Created by LeeKane on 17/4/8.
 */
//扩展其它状态
public class OtherState implements ServerState {
    public void explainState() {
        System.out.println("other state");
    }

    public boolean handle() {
        return false;
    }

    public void setSulution(StateSolution sulution) {

    }
}
