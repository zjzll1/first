package cn.yunhe.test;

import cn.yunhe.mapper.UserMapper;
import cn.yunhe.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserMapperTest {

    @Test
    public void testFindUserRole() {
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory().openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(mapper.findUserRole(41));
        sqlSession.close();
    }
}
