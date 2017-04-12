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
}