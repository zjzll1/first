package cn.yunhe.test;

import cn.yunhe.entity.Role;
import cn.yunhe.entity.User;
import cn.yunhe.mapper.RoleMapper;
import cn.yunhe.mapper.UserMapper;
import cn.yunhe.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.List;

public class RoleMapperTest {
    @Test
    public void testFindAll() {
        //可以获取会话工厂
        SqlSessionFactory sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        //得到会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取代理接口  基于动态代理形式
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        List<Role> roleList = roleMapper.findAll();

        for (Role role : roleList) {
            System.out.println(role);
        }
        sqlSession.close();
    }


}