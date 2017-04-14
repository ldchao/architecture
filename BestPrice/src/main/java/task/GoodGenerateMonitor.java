package task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import service.serviceimpl.htmlGenerateServiceImpl.Generator;

/**
 * Created by LeeKane on 17/4/14.
 */
@Component
public class GoodGenerateMonitor {

    @Scheduled(fixedDelay = 600000)  //10分钟更新一次
    public void generatorGoods() {
        Generator generator=new Generator();
        generator.generate();
    }
}
