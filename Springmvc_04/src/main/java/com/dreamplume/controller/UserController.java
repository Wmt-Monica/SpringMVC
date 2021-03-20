package com.dreamplume.controller;

import com.alibaba.fastjson.JSON;
import com.dreamplume.pojo.User;
import com.dreamplume.util.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2021/3/20 14:44
 * @Created by 翊
 */
@Controller
@RequestMapping("/user")

// @RestController 此注解表明该类以下所有的方法返回
// 的字符串都不会进行跳转，只是单纯返回一个字符串
@RestController
public class UserController {

    // jackson : 将对象和 json 对象之间的转变
    // 创建 ObjectMapper 对象
    ObjectMapper mapper = new ObjectMapper();

    // 创建 JSON 获取的辅助类 JsonUtil 类对象
    JsonUtil jsonUtil = new JsonUtil();


    // 当出现了乱码的现象，我们可以使用 @RequestMapping() 注解中的 produces 属性
    // 该属性可以指定返回的数据类型和编码形式
//    @RequestMapping(value = "/u1", produces = "application/json;charset=utf-8")
    @RequestMapping("/u1")  // 在 springmvc-servlet.xml 在中配置了解决JSON对象的乱码问题
    @ResponseBody  // @ResponseBody 注解代表此方法的放回的字符串将
                   // 不会以文件的 url 来进行跳转，而是单纯的返回字符串的形式
    public String u1() throws JsonProcessingException {
        User user = new User("王梦婷",19,"女");

        // 使用 ObjectMapper 对象的 writeValueAsString() 方法
        // 将参数里面的对象转变成 json 对象格式的字符串
        String userJson = mapper.writeValueAsString(user);
//        return user.toString();  // User(name=王梦婷, age=19, sex=女)
        return userJson;  // {"name":"王梦婷","age":19,"sex":"女"}
    }

    @RequestMapping("/u2")
    public String u2() throws JsonProcessingException {
        // 创建 List 集合存放 User 对象
        List<User> users = new ArrayList<User>();
        for (int i = 0; i < 5;i ++) {
            users.add(new User("王梦婷"+i, (19+i), "女"));
        }
        return mapper.writeValueAsString(users);
    }

    @RequestMapping("/u3")
    public String u3() throws JsonProcessingException {
        // 创建事件对象
        Date date = new Date();
        // 将事件对象转变成自定义的格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");

        // 除了上面使用 java 基础里面的方法来自定义时间格式的方法以外，
        // 还可以使用 ObjectMapper 对象的方法
        // 1.不使用时间戳的方式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        // 2.以之前创建的 SimpleDateFormat 对象自定义的时间的格式存入 mapper 对象中
        mapper.setDateFormat(dateFormat);
//        return mapper.writeValueAsString(dateFormat.format(date));
        return mapper.writeValueAsString(date);  // 直接输出时间对象
    }

    // 使用 util 包下的 JsonUtil 工具类对象的 getTime() 方法获取对应格式的事件对象
    @RequestMapping("/u4")
    public String u4() throws JsonProcessingException {
        Date date = new Date();
        String format = "YYYY-MM-dd hh:mm:ss";
        return JsonUtil.getJSON(date, format);
    }

    @RequestMapping("/u5")
    public String u5() {
        Date date = new Date();
        return JsonUtil.getJSON(date);
    }

    @RequestMapping("/u6")
    public String u6() throws JsonProcessingException {
        // 创建 List 集合存放 User 对象
        List<User> users = new ArrayList<User>();
        for (int i = 0; i < 2;i ++) {
            users.add(new User("王梦婷"+i, (19+i), "女"));
        }
        return JsonUtil.getJSON(users);
    }

    @RequestMapping("/u7")
    public String u7() throws JsonProcessingException {
        // 创建 List 集合存放 User 对象
        List<User> users = new ArrayList<User>();
        for (int i = 0; i < 2;i ++) {
            users.add(new User("王梦婷"+i, (19+i), "女"));
        }

        // 使用阿里云创建的 fastjson.jar 包下的对象 JSON 对象，使用toJSONString()方法
        // 将 java 对象转换成 json 对象
        return JSON.toJSONString(users);
    }

}
