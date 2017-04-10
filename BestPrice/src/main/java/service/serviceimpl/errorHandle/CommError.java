package service.serviceimpl.errorHandle;
import service.errorHandle.ErrorBase;
import service.errorHandle.ErrorHandler;

/**
 * Created by Xuanlin on 17/4/11.
 */
public class CommError implements ErrorBase
{
    public void handle(ErrorHandler handler) {
        handler.handle(this);
    }
}