package com.dreamplume.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Classname MyInterceptor
 * @Description TODO
 * @Date 2021/3/20 19:48
 * @Created by 翊
 * 拦截器的入门
 * 1.创建拦截器类实现 HandlerInterceptor 接口
 * 2.配置拦截器
 * 3.测试拦截器的拦截结果
 */
public class MyInterceptor implements HandlerInterceptor {

    // 实现了 HandlerInterceptor 接口，实现拦截效果有三个

    // 1.在目标方法执行之前
    // 诺此方法返回 false,那么不会再执行之后的所有方法，包括目标方法
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle is running....");
        return true;
    }

    // 2.在目标方法执行之后，视图对象返回之前执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle is running....");
    }

    // 3.在流程都执行完毕之后执行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion is running....");
    }
}
