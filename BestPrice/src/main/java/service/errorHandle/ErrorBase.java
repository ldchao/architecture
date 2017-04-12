package service.errorHandle;

import service.serviceimpl.errorHandle.GuiSysHandle;
import service.serviceimpl.errorHandle.LogSysHandle;

/**
 * Created by Xuanlin on 2017/4/10.
 */
public interface ErrorBase {

    /**
     * 通过界面显示处理情况
     * @param guiSysHandle
     */
    public void handle(GuiSysHandle guiSysHandle);

    /**
     * 通过日志文件处理情况
     * @param logSysHandle
     */
    public void handle(LogSysHandle logSysHandle);
}
