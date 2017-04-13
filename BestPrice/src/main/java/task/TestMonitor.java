package task;

import monitor.Monitor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/10.
 */
@Component
public class TestMonitor {


    @Scheduled(fixedDelay = 5000)  //任务间隔5秒  固定间隔用“@Scheduled(fixedRate = 5000)”
    public void monitorTestConfig() {

        // TODO: 2017/4/13
    }

}
