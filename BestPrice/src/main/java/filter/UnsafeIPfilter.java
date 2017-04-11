package filter;

import Entity.Ip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.ShieldIPService;
import service.serviceimpl.ShieldIPServiceImpl;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Hanifor on 4/11/2017.
 */
@Component
public class UnsafeIPfilter implements Filter, Observer {
    private ShieldIPService shieldIPService=new ShieldIPServiceImpl();
    private List<String> ips;

    public void init(FilterConfig filterConfig) throws ServletException {
        ips = new ArrayList<String>();
        List<Ip> tmp = shieldIPService.query();
        for (Ip ip: tmp) {
            ips.add(ip.getIp());
        }
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final String IP = servletRequest.getRemoteAddr();
        for (String ip: ips) {
            if(ip.equals(IP)){
                if (servletResponse instanceof HttpServletResponse) {
                    ((HttpServletResponse) servletResponse).sendError(503, ip + " is blocked.");
                }
                return;
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
    }

    public void update(Observable o, Object arg) {
        if(o instanceof ShieldIPServiceImpl){
            String ip = (String)arg;
            if(ip.charAt(0) == '+'){
                ips.add(ip);
            }else if(ip.charAt(0) == '-'){
                ips.remove(ip);
            }
        }
    }
}
