package monitor.severState;

import monitor.stateSolution.RecallSolution;
import monitor.stateSolution.StateSolution;

/**
 * Created by LeeKane on 17/4/8.
 */
public class CrashState implements ServerState {
    private StateSolution stateSolution = new RecallSolution();
    //错误码与状态信息输出
    public void explainState() {
        System.out.println("ping fail , server may be crashed!");
    }

    public boolean handle() throws Exception{

        try{
            return stateSolution.solveState();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return  false;
        }
    }

    public void setSulution(StateSolution sulution) {
        this.stateSolution=sulution;
    }
}
