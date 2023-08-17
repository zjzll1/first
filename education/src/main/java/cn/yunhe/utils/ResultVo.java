package cn.yunhe.utils;
/*
* 在servlet每次请求数据返回的时候都 创建一个ResultVo 并赋值
*   然后转成json 进行响应
*
* 统一的返回格式
* */
public class ResultVo {
    private int code;//返回的状态码
    private String message;//返回的消息
    private Object obj;//返回的数据

    public ResultVo() {
    }

    public ResultVo(int code, String message, Object obj) {
        this.code = code;
        this.message = message;
        this.obj = obj;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
