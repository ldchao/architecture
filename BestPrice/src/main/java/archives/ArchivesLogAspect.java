package archives;
import model.User;
import java.lang.reflect.Method;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * Created by LeeKane on 17/4/9.
 */
public class ArchivesLogAspect {

    private final Logger logger = Logger.getLogger(this.getClass());

    private String requestPath = null ; // 请求地址
    private String userName = "" ; // 用户名
    private Map<?,?> inputParamMap = null ; // 传入参数
    private Map<String, Object> outputParamMap = null; // 存放输出结果
    private long startTimeMillis = 0; // 开始时间
    private long endTimeMillis = 0; // 结束时间
    private User user = null;
    private HttpServletRequest request = null;


    /**
     *
     * @Description: 方法调用前触发   记录开始时间
     * @author LeeKane
     * @param joinPoint
     */
    public void before(JoinPoint joinPoint){
        //System.out.println("被拦截方法调用之后调用此方法，输出此语句");
        request = getHttpServletRequest();

        //Object obj =request.getParameter("someParam");
        //System.out.println("方法调用前: " + obj);

        //user = (User)request.getSession().getAttribute();

        startTimeMillis = System.currentTimeMillis(); //记录方法开始执行的时间
    }


    /**
     *
     * @Description: 方法调用后触发   记录结束时间
     * @author LeeKane
     * @param joinPoint
     */
    public  void after(JoinPoint joinPoint) {
        request = getHttpServletRequest();
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = null;
        try {
            targetClass = Class.forName(targetName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Method[] methods = targetClass.getMethods();
        String operationName = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs!=null&&clazzs.length == arguments.length&&method.getAnnotation(ArchivesLog.class)!=null) {
                    operationName = method.getAnnotation(ArchivesLog.class).operationName();
                    break;
                }
            }
        }
        endTimeMillis = System.currentTimeMillis();
        //格式化开始时间
        String startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startTimeMillis);
        //格式化结束时间
        String endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(endTimeMillis);

        Object obj =request.getParameter("fileName");
        System.out.println("方法调用后: " + obj);
//        System.out.println(" 操作人: "+user.getUsername()+" 操作方法: "+operationName+" 操作开始时间: "+startTime +" 操作结束时间: "+endTime);

    }



    /**
     * @Description: 获取request
     * @author LeeKane
     * @param
     * @return HttpServletRequest
     */
    public HttpServletRequest getHttpServletRequest(){
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes)ra;
        HttpServletRequest request = sra.getRequest();
        return request;
    }

    /**
     *
     * @Title：printOptLog
     * @Description: 输出日志到其它地方
     * @author LeeKane
     */
    private void printOptLog() {

    }
}
