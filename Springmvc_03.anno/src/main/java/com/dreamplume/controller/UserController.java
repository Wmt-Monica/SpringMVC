package com.dreamplume.controller;

import com.dreamplume.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2021/3/19 23:31
 * @Created by 翊
 */
@Controller
@RequestMapping("/user")
public class UserController {

    // @GetMapping 注解，指定该方法是当使用 get 方式提交到 /user/wmt1 路径下执行的方法
    @GetMapping("/wmt1")
    public String test1(String name, Model model) {

        // 1.接收前端的参数
        System.out.println("接收到前端的参数为:"+name);

        // 2.将返回的结果返回给后端, Model
        model.addAttribute("data",name);

        // 3.视图跳转
        return "success";
    }

    /*
        在方法参数前面添加 @RequestParam() 括号里面参数填写 username
        那么在访问该路径时，想要输入方法参数的 name 参数值，就强制使用
        username 做为 请求头上面的参数名称，上面不使用该注解，未输入参
        数不会报错，但是在下面添加了注解的参数未输入在 url 中，回报400
        的错误，如果是不是使用username参数名称也是报400的错误
     */
    @GetMapping("/wmt2")
    public String test2(@RequestParam("username") String name, Model model) {
        // 1.接收前端的参数
        System.out.println("接收到前端的参数为:"+name);

        // 2.将返回的结果返回给后端, Model
        model.addAttribute("data",name);

        // 3.视图跳转
        return "success";
    }

    /*
        1.接收到前端用户传递的参数，判断参数的名称，假设参数名称和方法上面的
          参数名称一致，就可以直接匹配到，该方法的参数值可以直接使用
        2.假设传递的是一个对象 User,匹配 User 对象中的属性名，如果相一致
          就匹配陈工，否则该对象的未匹配成功的属性值为 null
     */
    @GetMapping("/wmt3")
    public String test3(User user, Model model) {
        // 1.接收前端的参数
        System.out.println("接收到前端的参数为:"+user);

        // 2.将返回的结果返回给后端, Model
        model.addAttribute("data",user);

        // 3.视图跳转
        return "success";
    }
}
