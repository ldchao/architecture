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
public class DispatcherMonitor {

    private static String ip = "127.0.0.1";
    Monitor monitor;

    public DispatcherMonitor() {
        monitor = Monitor.GetInstance();
        monitor.setDispatcherMonitor(this);
    }

    @Scheduled(fixedDelay = 6000)  //每个十分钟，轮询各个服务器，查找最优的路径
    public void getOnlineVolume() {
        //从连通服务器获得可用的IP地址
        List<String> pingableIpList = monitor.getPingableIpList();
        for (String pingableIp : pingableIpList) {
            System.out.println(pingableIp);
            System.out.println(sendGet("http://localhost:8080/test",""));
        }

    }

    public void update(String ip) {
        if (this.ip.equals(ip)) {
            getOnlineVolume();
        }
    }


    public static String getIP() {
        return ip;
    }


    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }


}
