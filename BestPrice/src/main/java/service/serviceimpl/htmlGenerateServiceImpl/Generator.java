package service.serviceimpl.htmlGenerateServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import service.HtmlGenerateService;

/**
 * 策略类的调用类
 * Created by marioquer on 2017/4/10.
 */
public class Generator {


    HtmlGenerateService htmlGenerateService;

    public void setHtmlGenerateService(HtmlGenerateService html){
        htmlGenerateService = html;
    }

    /**
     * 转发策略类的generate方法
     */
    public void generate(){
        htmlGenerateService.generate();
    }

}
