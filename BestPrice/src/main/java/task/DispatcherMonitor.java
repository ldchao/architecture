package task;

import monitor.Monitor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/4/10.
 */
@Component
public class DispatcherMonitor {

    private static String ip="localhost";
    Monitor monitor;

    public DispatcherMonitor(){
        monitor=Monitor.GetInstance();
        monitor.setDispatcherMonitor(this);
    }

    @Scheduled(fixedDelay = 6000)  //每个十分钟，轮询各个服务器，查找最优的路径
    public void getOnlineVolume(){
        //从连通服务器获得可用的IP地址
        monitor.getPingableIpList();
     }

    public void update(String ip){

    }


    public static String getIP(){
        return null;
    }
}
