package service.errorHandle;

import service.serviceimpl.errorHandle.DBError;
import service.serviceimpl.errorHandle.CommError;

/**
 * Created by Xuanlin on 2017/4/10.
 */
public interface ErrorHandler {

    /**
     * 处理数据库差错
     * @param dbError
     */
    public void handle(DBError dbError);


    /**
     * 处理常规运行时差错
     * @param commError
     */

    public void handle(CommError commError);


}