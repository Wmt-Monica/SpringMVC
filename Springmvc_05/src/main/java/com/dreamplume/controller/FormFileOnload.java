package com.dreamplume.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Classname FormFileOnload
 * @Description TODO
 * @Date 2021/3/20 18:36
 * @Created by 翊
 * 表单文件上传
 */
@Controller
@RequestMapping("/file")
public class FormFileOnload {

    @RequestMapping("/f1")
    // 此处方法的参数名称要和表单中的数据的 name 属性名称一致，否则接受的是为 null
    public String f1(String username, MultipartFile file, MultipartFile[] files, Model model) throws IOException {
        model.addAttribute("username",username);

        // 获取文件的名称
        String file1Name = file.getOriginalFilename();
        model.addAttribute("file1",file1Name);
        // 将从客户端接收到的数据保存到指定的位置
        file.transferTo(new File("D:/github上传的文件/JavaTxtSet/fileOnload/two/"+file1Name));

        for (int i = 0; i < files.length; i ++) {
            model.addAttribute("file"+(i+2),files[i].getOriginalFilename());
            // 将获取到的文件数组分批保留到电脑上指定的路径
            files[i].transferTo(new File("D:/github上传的文件/JavaTxtSet/fileOnload/two/"+files[i].getOriginalFilename()));
        }
        return "success";
    }
}
