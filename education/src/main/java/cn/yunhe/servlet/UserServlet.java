package cn.yunhe.servlet;

import cn.yunhe.entity.User;
import cn.yunhe.service.UserService;
import cn.yunhe.service.impl.UserServiceImpl;
import cn.yunhe.utils.BaseServlet;
import cn.yunhe.utils.JsonUtils;
import cn.yunhe.utils.ResultVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends BaseServlet {

    UserService userService = new UserServiceImpl();
    ResultVo vo = null;
    public void login(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userService.login(username,password);
        if (user != null) {
            if (user.getStatus()!=1) { // 1 启用  2 封禁
                vo = new ResultVo(500,"账号已被封禁",null);
            }else {
                if (user.getRole()==1){ // 1 管理员 2 经理 3 用户
                    vo = new ResultVo(200,"登录成功",username);
                }else {
                    vo = new ResultVo(500,"权限不足",null);
                }
            }
        }else {
            vo = new ResultVo(500,"用户名或密码错误",null);
        }
        JsonUtils.objToJson(vo,resp);
    }
}
