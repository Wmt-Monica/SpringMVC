package com.dreamplume.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Classname Forward_Redirect
 * @Description TODO
 * @Date 2021/3/19 23:09
 * @Created by 翊
 */
@Controller
public class Forward_Redirect {
    /*
        通过 SpringMVC 来实现转发和重定向 （无需视图解析），
        测试前先把 springmvc-servlet.xml 的解析器给注释掉
        return 中输入的页面的路径字符串，默认是使用 转发的
        形式跳转 (forward)，如果要使用重定向需要在 return 返回的
        字符串前面加上 redirect: 转发就是 forward:
        加入视图解析器没有注释掉，那么转发直接就些默认的页面即可，
        重定向在 redirect:后面写加上视图解析器的前缀后缀的页面 url 路径
     */
    @RequestMapping(value = "/hello5")
    public String hello5(HttpServletRequest request, HttpServletResponse response, Model model) {
        HttpSession session = request.getSession();
        model.addAttribute("data",session.getId());
        // 转发 http://localhost:8080/hello5
        return "forward:/WEB-INF/jsp/success.jsp";
    }

    @RequestMapping(value = "/hello6")
    public String hello6(HttpServletRequest request, HttpServletResponse response, Model model) {
        HttpSession session = request.getSession();
        model.addAttribute("data",session.getId());
        // 重定向 http://localhost:8080/index.jsp?data=77537EB46F126E959F5C2D283176E122
        return "redirect:/index.jsp";
    }
}
