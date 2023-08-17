package cn.yunhe.dao;

import cn.yunhe.entity.Course;

import java.util.ArrayList;
import java.util.List;

public interface CourseDao {
    /**
     * 添加
     */
    int addCourse(Course course);

    /**
     * 查询总条数
     */
    List<Course> findCount(String sql, ArrayList<Object> params);

    /**
     * 根据条件查询
     */
    List<Course> findByLimit(String sql, ArrayList<Object> params, int cPage, int pSize);

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
    Course findById(int cid);
}
