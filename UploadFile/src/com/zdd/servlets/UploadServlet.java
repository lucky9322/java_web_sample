package com.zdd.servlets;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Project: UploadFile
 * Created by Zdd on 2018/3/14.
 */
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SmartUpload smartUpload = new SmartUpload();
        ServletConfig config = this.getServletConfig();
//        初始化
        smartUpload.initialize(config, req, resp);
        try {
//            上传文件
            smartUpload.upload();
//            得到上传文件的对象
            File file = smartUpload.getFiles().getFile(0);
            file.saveAs("/Users/lucky/java/java_web_sample/UploadFile/uploadResult/" + file.getFileName(), SmartUpload.SAVE_PHYSICAL);
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        String msg="Upload Success";
        req.setAttribute("msg",msg);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req,resp);
    }
}
