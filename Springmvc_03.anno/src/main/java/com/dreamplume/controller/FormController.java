package com.dreamplume.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname FormController
 * @Description TODO
 * @Date 2021/3/20 8:30
 * @Created by 翊
 */
@Controller
@RequestMapping("/form")
public class FormController {

    // 以下方式当收到的 name 属性值是中文的时候，会看到乱码的情况
    @PostMapping("/f1")
    public String f1(String name, Model model) {

        // 乱码情况在打印到控制台就已经是乱码的状态
        // 1.从前端接收数据
        System.out.println("从前端表单接收到的name属性值："+name);

        // 2.封装数据
        model.addAttribute("data",name);

        // 3.跳转页面
        return "success";
    }
}
