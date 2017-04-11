package service;

import Entity.Ip;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by lois on 2017/4/9.
 */
public interface ShieldIPService {

    /**
     * 检测ip是否安全
     * @return false表示不安全，需重定向到警告界面
     */
    public boolean checkIP(HttpServletRequest request);

    /**
     * 向屏蔽ip表内添加特定IP
     * @param ip
     * @return
     */
    public boolean add(Ip ip);

    /**
     * 删除屏蔽IP
     * @param ip
     * @return
     */
    public boolean delete(Ip ip);

    /**
     * 更新屏蔽IP
     * @param ip
     * @return
     */
    public boolean update(Ip ip);

    /**
     * 获取被屏蔽ip
     * @return
     */
    public List<Ip> query();
}

