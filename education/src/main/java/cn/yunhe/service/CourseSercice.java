package cn.yunhe.service;

import cn.yunhe.entity.Course;
import cn.yunhe.utils.PageBean;

public interface CourseSercice {

    /**
     * 添加
     */
    int addCourse(Course course);

    /**
     * 分页查询
     */
    PageBean<Course> findPage(String currentPage, String pageSize, String courseName);

    /**
     * 删除
     */
    int delAll(String cids);

    /**
     * 修改
     */
    int editCourse(Course course);

    /**
     * 根据id查找
     */
    Course findCourse(int cid);
}
