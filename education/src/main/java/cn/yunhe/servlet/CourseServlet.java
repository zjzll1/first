package cn.yunhe.servlet;

import cn.yunhe.entity.Course;
import cn.yunhe.service.CourseSercice;
import cn.yunhe.service.impl.CourseServiceImpl;
import cn.yunhe.utils.*;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/courses")
@MultipartConfig  //上传文件三要素之一
public class CourseServlet extends BaseServlet {
    ResultVo vo = null;
    CourseSercice courseSercice = new CourseServiceImpl();

    /**
     * 上传文件
     */
    public void uploadFile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = UploadUtils.uploadFile(req);
        if (fileName.endsWith(".jpg") || fileName.endsWith(".png") || fileName.endsWith(".gif") || fileName.endsWith(".jpeg")) {
            vo = new ResultVo(200, "上传图片成功", fileName);
        } else {
            vo = new ResultVo(200, "上传视频成功", fileName);
        }
        JsonUtils.objToJson(vo, resp);
    }

    /**
     * 添加
     */
    public void addCourse(HttpServletRequest req, HttpServletResponse resp) throws InvocationTargetException, IllegalAccessException, IOException {
        //接收参数到map
        Map<String, String[]> map = req.getParameterMap();
        //创建课程对象
        Course course = new Course();
        //使用工具类封装数据
        BeanUtils.populate(course, map);
        //处理文件名
        course.setCourseImage(FileNameUtils.subFileName(course.getCourseImage()));
        course.setCourseVideo(FileNameUtils.subFileName(course.getCourseVideo()));

        int row = courseSercice.addCourse(course);
        if (row > 0) {
            vo = new ResultVo(200, "课程添加成功", null);
        } else {
            vo = new ResultVo(500, "课程添加失败", null);
        }
        JsonUtils.objToJson(vo, resp);
    }

    /**
     * 移除
     */
    public void removeFile(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //String fileName = req.getParameter("fileName");
        String fileName = FileNameUtils.subFileName(req.getParameter("fileName"));

        //根据文件路径和文件名称构建file文件对象
        File file = new File("D:/upload/" + fileName);
        //删除
        file.delete();

        if (fileName.endsWith(".jpg") || fileName.endsWith(".png") || fileName.endsWith(".gif") || fileName.endsWith(".jpeg")) {
            vo = new ResultVo(200, "删除图片成功", null);
        } else {
            vo = new ResultVo(200, "删除视频成功", null);
        }
        //转json并响应
        JsonUtils.objToJson(vo, resp);
    }

    /**
     * 分页查询
     */
    public void findPage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String currentPage = req.getParameter("currentPage");//用户想看的页码
        String pageSize = req.getParameter("pageSize");//每页显示条数
        String courseName = req.getParameter("courseName");//搜索条件

        PageBean<Course> pageBean = courseSercice.findPage(currentPage,pageSize,courseName);

        JsonUtils.objToJson(pageBean,resp);
    }

    /**
     * 删除
     */
    public void delAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String cids = req.getParameter("cids");
        int row = courseSercice.delAll(cids);
        if (row > 0) {
            vo = new ResultVo(200, "删除成功", null);
        } else {
            vo = new ResultVo(500, "删除失败", null);
        }
        JsonUtils.objToJson(vo, resp);
    }

    /**
     * 修改
     */
    public void editCourse(HttpServletRequest req, HttpServletResponse resp) throws InvocationTargetException, IllegalAccessException, IOException {
        /*//接收参数到map
        Map<String, String[]> map = req.getParameterMap();
        //创建课程对象
        Course course = new Course();
        //使用工具类封装数据
        BeanUtils.populate(course, map);
        //处理文件名
        course.setCourseImage(FileNameUtils.subFileName(course.getCourseImage()));
        course.setCourseVideo(FileNameUtils.subFileName(course.getCourseVideo()));

        int row = courseSercice.editCourse(course);
        if (row > 0) {
            vo = new ResultVo(200, "修改成功", null);
        } else {
            vo = new ResultVo(500, "修改失败", null);
        }
        JsonUtils.objToJson(vo, resp);
    */
        //1、接收参数到map中
        Map<String, String[]> map = req.getParameterMap();
        //2、创建课程对象
        Course course = new Course();
        //3、封装数据
        BeanUtils.populate(course,map);
        course.setCourseImage(FileNameUtils.subFileName(course.getCourseImage()));
        course.setCourseVideo(FileNameUtils.subFileName(course.getCourseVideo()));

        //根据cid获取到课程对象
        Course c = courseSercice.findCourse(course.getCid());
        //上传的图片名称和数据库中查询的原始图片名称对比
        if(!course.getCourseImage().equals(c.getCourseImage())){
            //修改了
            File file = new File("d:/upload/" + c.getCourseImage());
            //删除老图片
            file.delete();
        }

        if(!course.getCourseVideo().equals(c.getCourseVideo())){
            //修改了视频
            File file = new File("d:/upload/" + c.getCourseVideo());
            //删除老视频
            file.delete();
        }
        //4、调用业务
        int row= courseSercice.editCourse(course);
        //5、响应
        if (row > 0) {
            vo = new ResultVo(200, "修改课程成功", null);
        } else {
            vo = new ResultVo(500, "修改课程失败", null);
        }
        JsonUtils.objToJson(vo,resp);
    }
}
