package cn.yunhe.dao.impl;

import cn.yunhe.dao.CourseDao;
import cn.yunhe.entity.Course;
import cn.yunhe.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourseDaoImpl implements CourseDao {

    QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());

    /**
     * 添加
     */
    @Override
    public int addCourse(Course c) {
        try {
            return qr.update("insert into course values (null,?,?,?,?,?,?,?,?)", c.getCourseName(), c.getDescs(), c.getCourseType(), c.getCourseImage(), c.getCourseVideo(), c.getCoursePrice(), c.getStatus(), new Date());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询总条数
     */
    @Override
    public List<Course> findCount(String sql, ArrayList<Object> params) {
        try {
            return qr.query(sql,new BeanListHandler<Course>(Course.class),params.toArray());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据条件查询
     */
    @Override
    public List<Course> findByLimit(String sql, ArrayList<Object> params, int cPage, int pSize) {
        sql += " limit ?,? ";
        int start = (cPage - 1) * pSize;
        params.add(start);
        params.add(pSize);
        try {
            return qr.query(sql,new BeanListHandler<Course>(Course.class),params.toArray());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 删除
     */
    @Override
    public int delAll(String cids) {
        try {
            return qr.update("delete from course where cid in ("+cids+")");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 修改
     */
    @Override
    public int editCourse(Course c) {
        try {
            return qr.update("update course set courseName=?,descs=?,courseType=?,courseImage=?,courseVideo=?,coursePrice=?,status=?,createTime=? where cid =?",c.getCourseName(), c.getDescs(), c.getCourseType(), c.getCourseImage(), c.getCourseVideo(), c.getCoursePrice(), c.getStatus(), new Date(), c.getCid());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据id查
     */
    @Override
    public Course findById(int cid) {
        try {
            return qr.query("select * from course where cid=?",new BeanHandler<Course>(Course.class),cid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
