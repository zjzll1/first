package cn.yunhe.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        //获取某个Servlet类的Class类型对象
        Class<? extends BaseServlet> claz = this.getClass();
        //调用method对应的方法
        try {
            Method m = claz.getMethod(method,HttpServletRequest.class,HttpServletResponse.class);
            //方法调用
            m.invoke(claz.newInstance(),req,resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
