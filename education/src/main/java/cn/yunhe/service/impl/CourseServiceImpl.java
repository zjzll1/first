package cn.yunhe.service.impl;

import cn.yunhe.dao.CourseDao;
import cn.yunhe.dao.impl.CourseDaoImpl;
import cn.yunhe.entity.Course;
import cn.yunhe.service.CourseSercice;
import cn.yunhe.utils.PageBean;

import java.util.ArrayList;
import java.util.List;

public class CourseServiceImpl implements CourseSercice {

    CourseDao courseDao = new CourseDaoImpl();

    /**
     * 添加
     */
    @Override
    public int addCourse(Course course) {
        return courseDao.addCourse(course);
    }

    /**
     * 分页查询
     */
    @Override
    public PageBean<Course> findPage(String currentPage, String pageSize, String courseName) {
        PageBean<Course> pb = new PageBean<>();
        int cPage = Integer.parseInt(currentPage);
        int pSize = Integer.parseInt(pageSize);
        pb.setPageSize(pSize);
        pb.setCurrentPage(cPage);

        String sql = "select * from course ";
        //用于存入?参数
        ArrayList<Object> params = new ArrayList<>();

        //填写了搜索条件
        if (courseName != null && !"".equals(courseName.trim())) {
            sql += " where courseName like ? ";
            params.add( "%" + courseName + "%" );
        }

        //总共条数
        List<Course> courseList = courseDao.findCount(sql,params);
        pb.setTotalCount(courseList.size());

        //查询符合条件的结果
        List<Course> list =courseDao.findByLimit(sql,params,cPage,pSize);
        pb.setList(list);
        return pb;
    }

    /**
     * 删除
     */
    @Override
    public int delAll(String cids) {
        return courseDao.delAll(cids);
    }

    /**
     * 修改
     */
    @Override
    public int editCourse(Course course) {
        return courseDao.editCourse(course);
    }

    /**
     * 根据id查
     */
    @Override
    public Course findCourse(int cid) {
        return courseDao.findById(cid);
    }
}
