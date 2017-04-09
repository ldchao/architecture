package monitor.severState;

import monitor.stateSolution.StateSolution;

/**
 * Created by LeeKane on 17/4/8.
 */
public class NormalState implements ServerState {


    public void explainState() {
        System.out.println("server runs with a good state");
    }

    public boolean handle() {
        return true;
    }

    public void setSulution(StateSolution sulution) {

    }
}
