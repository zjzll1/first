package cn.yunhe.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JsonUtils {
    /*{"code":200,"message":"登录成功","obj":"root"} {"code":500,"message":"用户名密码错误","obj":null}
     * 参数是传入的java对象
     * */
    public static void objToJson(Object obj, HttpServletResponse response) throws IOException {
        //解决响应体中含有的中文乱码
        response.setContentType("text/html;charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(obj);
        //响应回页面
        response.getWriter().println(json);
    }
}
