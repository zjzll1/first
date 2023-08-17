package cn.yunhe;

import cn.yunhe.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    LoginService service = new LoginServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //接收请求参数
        String username = req.getParameter("username");
        //调用业务查询
        User u = new User();
        u.setUsername(username);
        User user = service.findByName(u);
        //判断是否存在
        if (user != null) {
            resp.getWriter().println(1);
        }else {
            resp.getWriter().println(0);
        }
    }
}
