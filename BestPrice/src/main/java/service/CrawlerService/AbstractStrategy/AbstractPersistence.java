package service.CrawlerService.AbstractStrategy;

/**
 * Created by mm on 2017/4/9.
 */
public abstract class AbstractPersistence<T> {
    public abstract void registerShop(T t);

    public abstract void persist(T t,String target);
}
