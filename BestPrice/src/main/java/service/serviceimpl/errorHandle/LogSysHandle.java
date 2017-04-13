package service.serviceimpl.errorHandle;

import service.errorHandle.ErrorHandler;
import service.errorHandle.ErrorBase;

/**
 * Created by Xuanlin on 2017/4/10.
 */
public class LogSysHandle implements ErrorHandler
{
    public void announceError(ErrorBase error) {
        System.out.println("假装日志显示错误码：");
        error.handle(this);
    }

}