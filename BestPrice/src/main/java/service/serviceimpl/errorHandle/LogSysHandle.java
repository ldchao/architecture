package service.serviceimpl.errorHandle;

import service.errorHandle.ErrorHandler;
import service.errorHandle.ErrorBase;

/**
 * Created by Xuanlin on 2017/4/10.
 */
public class LogSysHandle implements ErrorHandler
{
    public void announceError(ErrorBase error) {
        error.handle(this);
    }

    public void handle(DBError dbError) {
         /* 通知日志系统进行有关数据库错误的处理 */
    }
    public void handle(CommError commError) {
        /* 通知日志系统进行有关通信错误的处理 */

    }
}