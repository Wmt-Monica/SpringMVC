package com.dreamplume.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Classname HelloController
 * @Description TODO
 * @Date 2021/3/19 19:13
 * @Created by 翊
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model) {
        // 封装数据
        model.addAttribute("data","Hello SpringMVC!");

        // 返回的数据会被视图解析器处理
        // 如果不专门在 return 的字符串中设置跳转类型。默认是转发形式
        // 如果要设置成转发要在要转发的页面前面加上 forward:
        // 如果要使用重定向的形式首先将 springmvc-servlet.xml 配置中删除前缀后缀的添加
        return "success";
    }

    @RequestMapping("/hello2")
    public String hello2(Model model) {
        // 封装数据
        model.addAttribute("data","hello2路径下的转发");

        /*
            /hello 路径下的页面和 /hello2 页面共享转发到 success.jsp 页面，
            但是再其中得到的 data 数据不一样，其中可以看出两个请求可以共享同
            一个视图（jsp页面），但是页面的结果不一样，视图可以复用，控制器
            和视图是弱偶合关系
         */
        return "success";
    }

    /*
        一般需要参数的页面再访问的时候，其中参数的书写是在后面添加?,
        多个而参数之间室友 & 符号进行连接。例如：?a=1&b=2
        但是当我们再参数的类型上面，再前面时候 @PathVariable 之后
        在 @RequestMapping 括号里面的 url 路径，填写如下的形式之后
        访问该页面的时候，所输入的 url 为 /hello3/1/3 斜杠后面输入具体的数据
     */
    @RequestMapping(value = "/hello3/{a}/{b}", method = RequestMethod.POST)
    public String hello3_1(@PathVariable int a, @PathVariable int b,Model model) {
        int result = a+b;
        // 封装数据
        model.addAttribute("data","1: a+b = "+result);
        return "success";
    }

    /*
        在 @RequestMapping 注解当中 method 这个参数的是可以用来
        判断以什么方式访问到该路径的对应的逻辑代码，上面是当以 Post
        方式访问 /hello3 页面的时候执行 hello3_1 方法，当使用 Get 方式
        访问 /hello3 页面的时候。就执行 hello3_2 方法。其中相同的 url 中，
        不能有相同的提交方式的service方法，否则会报错500 (内部服务器错误)
     */
    @RequestMapping(value = "/hello3/{a}/{b}", method = RequestMethod.GET)
    public String hello3_2(@PathVariable int a, @PathVariable int b,Model model) {
        int result = a+b;
        // 封装数据
        model.addAttribute("data","2: a+b = "+result);
        return "success";
    }

    @RequestMapping(value = "/hello4", method = RequestMethod.GET)
    public String hello4(HttpServletRequest request, HttpServletResponse response, Model model) {
        HttpSession session = request.getSession();
        model.addAttribute("data",session.getId());
        return "success";
    }


}