package tk.mybatis.springboot.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;
import tk.mybatis.springboot.service.IRedisService;
import tk.mybatis.springboot.util.HttpUtil;
import tk.mybatis.springboot.util.MathUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @Author: yule
 * @Description:
 * @Date: Created in 15:39 2018/8/7
 */
@Component
@ServletComponentScan
@WebFilter(urlPatterns = {"/**"})
public class IpRequstFilter implements Filter {

    @Autowired
    private IRedisService iRedisService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        String uri = request.getRequestURI();
        ArrayList arrayOf = new ArrayList();

        arrayOf.add("/countries");
        if (!arrayOf.contains(uri)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            String ip = HttpUtil.getIp(request);
            Integer ipRequstNum = (Integer) iRedisService.get(ip);
            if (ipRequstNum == null) {
                ipRequstNum = 0;
            }
            if (ipRequstNum > 2) {
                if (MathUtil.getRandomNum(0.5)) {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
                HttpUtil.dealResponse(response, "爬虫你好！");
            } else {
                ipRequstNum++;
                iRedisService.put(ip, ipRequstNum, 10);
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }

    }

    @Override
    public void destroy() {
    }

}
