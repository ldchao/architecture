package filter;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by Hanifor on 4/11/2017.
 */
@Component
public class ThrottleFilter implements Filter {
    private Map<String, Integer> ip2countCache = new HashMap<String, Integer>();
    private Set<String> blackList = new HashSet<String>();
    private int maxConcurrentRequests;
    private static final long PERIOD = 1L; // second
    private boolean enable = false;

    public void init(FilterConfig config) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain nextFilter) throws ServletException, IOException {
        if (enable) {
            final String ip = request.getRemoteAddr();
            boolean isOverflow;
            synchronized (this) {
                Integer count = ip2countCache.get(ip);
                if (count == null || count == 0) {
                    count = 0;
                }
                if (count < maxConcurrentRequests) {
                    isOverflow = false;
                    ip2countCache.put(ip, count + 1);
                } else {
                    isOverflow = true;
                    blackList.add(ip);
                }
            }
            if (isOverflow) {
                // block it
                if (response instanceof HttpServletResponse) {
                    ((HttpServletResponse) response).sendError(503, ip + " has too many concurrent requests per " + PERIOD + " second");
                }
                return;
            }
        } // else go ahead below
        // every thing is okay, go ahead
        nextFilter.doFilter(request, response);
    }
    // every 1 second
    @Scheduled(fixedRate = PERIOD * 1000)
    private void throttlingJob() {
        if (enable) {
            synchronized (ThrottleFilter.this) {
                for (Map.Entry<String, Integer> ip2count : ip2countCache.entrySet()) {
                    Integer count = ip2count.getValue();
                    String ip = ip2count.getKey();
                    if (count == null || count <= 1) {
                        ip2countCache.remove(ip);
                    } else {
                        if (count == maxConcurrentRequests) {
                        // remove from blacklist
                            blackList.remove(ip);
                        }
                        ip2countCache.put(ip, count - 1);
                    }
                }
            }
        }
    }
    /**
     * Any cleanup for the filter.
     */
    public void destroy() {
    }
    /**
     * Sets the maximum number of concurrent requests for a single IP.
     */
    @Required
    public void setMaxConcurrentRequests(int max) {
        maxConcurrentRequests = max;
    }
    @ManagedAttribute(description = "is the throttle filter enable or not")
    public boolean isEnable() {
        return enable;
    }
    @Required
    public void setEnable(boolean enable) {
        this.enable = enable;
    }
    public Set<String> getBlackList() {
        // for exactly, it might need synchronized, but no hurt for snapshoot in one or severl seconds
        return Collections.unmodifiableSet(blackList);
    }
}