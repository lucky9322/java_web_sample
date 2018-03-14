package com.zdd.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Project: ValidateCode
 * Created by Zdd on 2018/3/13.
 */
public class ValidateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String code = req.getParameter("code");
        HttpSession session = req.getSession();
        String ranStr = (String) session.getAttribute("ranStr");
        PrintWriter writer = resp.getWriter();
        if (!code.equals(ranStr)){
            writer.println("验证码错误");
        }else {
            writer.println("验证码正确");
        }
    }
}
