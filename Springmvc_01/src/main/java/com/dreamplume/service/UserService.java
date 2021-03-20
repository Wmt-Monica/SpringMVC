package com.dreamplume.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 2021/3/19 16:44
 * @Created by 翊
 */
public class UserService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 获取表单信息并进行判断
        String method = req.getParameter("method");
        if (method.equals("add")) {
            System.out.println("add method is running....");
        }else {
            System.out.println("other method is  running....");
        }

        // 转发
        req.getRequestDispatcher("/WEB-INF/jsp/UserService.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
