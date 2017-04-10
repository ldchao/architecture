package vo;

/**
 * Created by mm on 2017/4/9.
 */
public class CrawlerConfig {
    private String url;
    private String handler;
    private String persistence;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public String getPersistence() {
        return persistence;
    }

    public void setPersistence(String persistence) {
        this.persistence = persistence;
    }

    public boolean checkNotNull(){
        if (url!=null&&handler!=null&&persistence!=null){
            return true;
        }else {
            return false;
        }
    }
}
