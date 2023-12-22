package com.demo.controller;

import com.demo.entity.vo.MessageModel;
import com.demo.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class UserServlet extends HttpServlet {
    //实例化UserService对象
    private UserService userService = new UserService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String uPassword = request.getParameter("uPassword");
        MessageModel messageModel = userService.userLogin(uname, uPassword);

        if (messageModel.getCode() == 1){
            //成功状态
            request.getSession().setAttribute("user", messageModel.getObject());
            response.sendRedirect("index.jsp");
        }else {
            //失败状态
            request.setAttribute("messageModel", messageModel);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
}
