package com.dreamplume.controller;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Classname HelloController
 * @Description TODO
 * @Date 2021/3/19 17:25
 * @Created by 翊
 */
public class HelloController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws Exception {
        // ModelAndView 模型和视图
        ModelAndView mv = new ModelAndView();

        // 封装对象，放在 ModelAndView中，Model
        mv.addObject("msg","HelloSpringMVC!");
        // 封装要跳转的视图，放在ModeAndView中
        mv.setViewName("hello");
        return mv;
    }
}
