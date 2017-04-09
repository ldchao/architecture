package monitor.severState;

import monitor.stateSolution.StateSolution;

/**
 * Created by LeeKane on 17/4/8.
 */
public interface ServerState {
    public void explainState();
    public boolean handle() throws Exception;
    public void setSulution(StateSolution sulution);
}
