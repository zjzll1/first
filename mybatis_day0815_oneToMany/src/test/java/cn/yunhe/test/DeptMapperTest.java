package cn.yunhe.test;

import cn.yunhe.entity.Dept;
import cn.yunhe.mapper.DeptMapper;
import cn.yunhe.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class DeptMapperTest {

    @Test
    public void testFindEmpDept() {
        SqlSessionFactory sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.findDept("销售部");
        System.out.println(dept.getDeptno());
        System.out.println(dept.getEmpList());
        System.out.println(dept);
        sqlSession.close();
    }
}
