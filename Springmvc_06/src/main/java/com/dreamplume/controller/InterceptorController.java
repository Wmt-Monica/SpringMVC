package com.dreamplume.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Classname InterceptorController
 * @Description TODO
 * @Date 2021/3/20 19:31
 * @Created by 翊
 * 拦截器
 */
@Controller
@RequestMapping("/interceptor")
public class InterceptorController {

    @RequestMapping("/i1")
    public ModelAndView i1() {
        System.out.println("目标方法成功执行....");
        // 创建 ModelAndView 模型并视图类
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","王梦婷");
        modelAndView.setViewName("success");
        return modelAndView;
    }
}
