package tk.mybatis.springboot.filter;

import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang.StringUtils;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;

import static tk.mybatis.springboot.util.HttpUtil.dealResponse;

/**
 * @Author: yule
 * @Description:
 * @Date: Created in 15:39 2018/8/7
 */
//@Component
//@ServletComponentScan
//@WebFilter(urlPatterns = {"/**"})
public class PermissionFilter implements Filter {

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
            return;
        }


        String token = request.getParameter("token");
        long nanoTime = 1533632638686L;
        String charArrayString = new StringBuffer(String.valueOf(nanoTime)).reverse().toString();
        char[] firstSegment = charArrayString.substring(0, 6).toCharArray();
        char[] secondSegment = charArrayString.substring(6, 13).toCharArray();
        ArrayList firstList = new ArrayList();
        ArrayList secondList= new ArrayList();
        for (Character ch : firstSegment) {
            firstList.add(ch);
        }
        for (Character ch : secondSegment) {
            secondList.add(ch);
        }
        String a = StringUtils.join(firstList, "a");
        String b = StringUtils.join(secondList, "b");
        String str = a + request.getQueryString() + uri + b;

        String result = Base64.getEncoder().encodeToString((str).getBytes(Charset.forName("UTF-8")));
        result = Base64.getEncoder().encodeToString((result).getBytes(Charset.forName("UTF-8")));
        if (token == null) {
            dealResponse(response, result);
        }

        String string;
        String newString;
        String time = "0";
        try {
            string = new String(Base64.getDecoder().decode(token), Charset.forName("utf-8"));
            newString = new String(Base64.getDecoder().decode(string), Charset.forName("utf-8"));
            newString = new String(Base64.getDecoder().decode(newString), Charset.forName("utf-8"));
            time = new StringBuffer(newString.substring(newString.length() - 6 - 7).replace("b", "")).reverse().toString() +
                    new StringBuffer(newString.substring(0, 5 + 6).replace("a", "")).reverse();
        } catch (Exception e) {

        }

        if (Long.valueOf(time) + 30 * 1000 < nanoTime) {
            dealResponse(response, result);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }


    @Override
    public void destroy() {
    }
}
