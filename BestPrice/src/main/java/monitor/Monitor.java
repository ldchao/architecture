package monitor;

import monitor.severState.CrashState;
import monitor.severState.NormalState;
import monitor.severState.ServerState;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by LeeKane on 17/4/8.
 */
public class Monitor {
    private ServerState serverState = new NormalState();

    private  boolean pingWebServer(String ipAddress, int pingTimes, int timeOut){
        BufferedReader in = null;
        Runtime r = Runtime.getRuntime();  // 将要执行的ping命令,此命令是windows格式的命令
        String pingCommand = "ping " + ipAddress + " -n " + pingTimes    + " -w " + timeOut;
        try {   // 执行命令并获取输出
            System.out.println(pingCommand);
            Process p = r.exec(pingCommand);
            if (p == null) {
                return false;
            }
            in = new BufferedReader(new InputStreamReader(p.getInputStream(),"utf-8"));  // 逐行检查输出,计算类似出现=23ms TTL=62字样的次数
            int connectedCount = 0;
            String line = null;
            while ((line = in.readLine()) != null) {
                connectedCount += getCheckResult(line);
            }   // 如果出现类似=23ms TTL=62这样的字样,出现的次数=测试次数则返回真
//            return connectedCount == pingTimes;
            if(connectedCount == pingTimes)
            {
                if(!(this.serverState instanceof NormalState))
                    setState(new NormalState());
                return true;
            }
            else
            {
                if(this.serverState instanceof NormalState)
                    setState(new CrashState());
                return false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();   // 出现异常则返回假
            return false;
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //若line含有=18ms TTL=16字样,说明已经ping通,返回1,否則返回0.

    private  int getCheckResult(String line) {

        // System.out.println("控制台输出的结果为:"+line);或者log到日志

        Pattern pattern = Pattern.compile("(\\d+ms)(\\s+)(TTL=\\d+)",    Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            return 1;
        }
        return 0;
    }

    private void setState(ServerState state)
    {
        this.serverState=state;
    }

    //错误状态码返回
    private void explainState()
    {
        this.serverState.explainState();
    }

    //monitor处理错误接口
    private boolean handle() throws Exception
    {
        try {
            if(this.serverState.handle())
            {
                this.serverState= new NormalState();
                return  true;
            }
            else
            {
                return false;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    //monitor开启接口,调用该方法,20s后开始执行,每10s一次
    public void run()
    {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                pingWebServer("127.0.0.1",5,10000);// 目前是当前ip 5次请求 10秒超时
            }
        }, 200000 , 10000);
    }

}
