package service.errorHandle;

import service.serviceimpl.errorHandle.DBError;
import service.serviceimpl.errorHandle.CommError;

/**
 * Created by Xuanlin on 2017/4/10.
 */
public interface ErrorHandler {

    /**
     * 调用errorBase中的handle方法，异常差错
     * @param errorBase
     */
    public void announceError(ErrorBase errorBase);




}