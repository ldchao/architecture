package controller;


import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;

/**
 * Created by LeeKane on 17/4/9.
 */
public class TestController {
    //读取配置文件 决定进入测试模式还是正常模式
    private Path path = null;
    private WatchService watchService = null;
    private void initialize() {
        path = Paths.get("../testMode.xml");
        try {
            watchService = FileSystems.getDefault().newWatchService();
            path.register(watchService, ENTRY_CREATE, ENTRY_DELETE,
                    ENTRY_MODIFY);
        } catch (IOException e) {
            System.out.println("IOException" + e.getMessage());
        }
    }
    private void doMonitor() {
        WatchKey key = null;
        while (true) { // important - create an indefinite loop to watch the
            // file system changes.
            try {
                key = watchService.take();
                for (WatchEvent event : key.pollEvents()) {
                    WatchEvent.Kind kind = event.kind();
                    System.out.println("Event on " + event.context().toString()
                            + " is " + kind);
                    if(kind == ENTRY_MODIFY)
                    {

                    }
                }
            } catch (InterruptedException e) {
                System.out.println("InterruptedException: " + e.getMessage());
            }
            boolean reset = key.reset();
            if (!reset)
                break;
        }
    }
}
