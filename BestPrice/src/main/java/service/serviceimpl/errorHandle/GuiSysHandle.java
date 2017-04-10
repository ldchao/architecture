package service.serviceimpl.errorHandle;

import service.errorHandle.ErrorHandler;
import service.errorHandle.ErrorBase;


/**
 * Created by Xuanlin on 2017/4/10.
 */
public class GuiSysHandle implements ErrorHandler
{
    public void announceError(ErrorBase error) {
        error.handle(this);
    }

    public void handle(DBError dbError) {
        /* 通知用户界面进行有关数据库错误的处理 */
    }

    public void handle(CommError commError) {
        /* 通知用户界面进行有关常规运行时错误的处理 */
    }
}