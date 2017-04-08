package monitor.severState;

/**
 * Created by LeeKane on 17/4/8.
 */
public interface ServerState {
    public void explainState();
    public boolean handle();
}
