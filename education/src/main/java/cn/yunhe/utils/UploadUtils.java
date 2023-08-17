package cn.yunhe.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.UUID;

public class UploadUtils {
    public static String uploadFile(HttpServletRequest req) throws ServletException, IOException {
        //得到文件资源
        Part part = req.getPart("file");
        //获取文件名
        String fileName = part.getSubmittedFileName();
        //重命名文件名
        fileName = UUID.randomUUID()+fileName;
        //上传地址
        String path = "D:/upload/" + fileName;
        //写入
        part.write(path);
        return fileName;
    }
}
