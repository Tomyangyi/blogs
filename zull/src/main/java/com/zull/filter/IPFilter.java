package com.zull.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @author Administrator
 */
@Component
public class IPFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(IPFilter.class);

    private static final String key="user";

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx= RequestContext.getCurrentContext();
        HttpServletRequest req=ctx.getRequest();
        HttpSession session=req.getSession();
        String ipAddr=this.getIpAddr(req);
        logger.info("请求IP地址为：[{}]",ipAddr);
        //配置本地IP白名单，生产环境可放入数据库或者redis中
        List<String> ips=new ArrayList<String>();
        ips.add("192.168.66.31");
        if(!ips.contains(ipAddr)){
            logger.info("IP地址校验不通过！！！");
            ctx.setResponseStatusCode(401);
            ctx.setSendZuulResponse(false);
            ctx.setResponseBody("IpAddr is forbidden!");
        }
        logger.info("IP校验通过。");
        return null;
    }

    public void getHeader(HttpServletRequest request){
            //返回请求行中的资源名称
            String uri = request.getRequestURI();
            //获得客户端发送请求的完整url
            String url = request.getRequestURL().toString();
            //返回发出请求的IP地址
            String ip = request.getRemoteAddr();
            //返回请求行中的参数部分
            String params = request.getQueryString();
            //返回发出请求的客户机的主机名
            String host=request.getRemoteHost();
            //返回发出请求的客户机的端口号。
            int port =request.getRemotePort();
            System.out.println(ip);
            System.out.println(url);
            System.out.println(uri);
            System.out.println(params);
            System.out.println(host);
            System.out.println(port);
    }

    /**
     * 获取Ip地址
     * @param request
     * @return
     */
    public  String getIpAddr(HttpServletRequest request){

        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
