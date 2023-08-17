package cn.yunhe.test;

import cn.yunhe.entity.Dept;
import cn.yunhe.entity.User;
import cn.yunhe.mapper.DeptMapper;
import cn.yunhe.mapper.OrdersMapper;
import cn.yunhe.mapper.RoleMapper;
import cn.yunhe.mapper.UserMapper;
import cn.yunhe.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void testFindAll() {
        //可以获取会话工厂
        SqlSessionFactory sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        //得到会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取代理接口  基于动态代理形式
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        List<User> list = userMapper.findAll();
        list.forEach(System.out::println);
        //释放资源
        sqlSession.close();
    }

    @Test
    public void testAddUser() {
        //可以获取会话工厂
        SqlSessionFactory sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        //得到会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取代理接口  基于动态代理形式
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("aaa");
        user.setBirthday("2022-02-02");
        user.setSex("男");
        user.setAddress("11111");
        userMapper.addUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateUser() {
        //可以获取会话工厂
        SqlSessionFactory sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        //得到会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取代理接口  基于动态代理形式
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //User user = new User(46,"琳","2023-08-14","女","jx");
        //userMapper.updateUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteUserById() {
        //可以获取会话工厂
        SqlSessionFactory sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        //得到会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取代理接口  基于动态代理形式
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUserById(50);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testFindUserOrders() {
        //可以获取会话工厂
        SqlSessionFactory sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        //得到会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取代理接口  基于动态代理形式
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        //调用方法
        System.out.println(ordersMapper.findOrderById(1));
        //释放资源
        sqlSession.close();
    }

    @Test
    public void testFindDeptEmp() {
        //可以获取会话工厂
        SqlSessionFactory sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        //得到会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取代理接口  基于动态代理形式
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        //调用方法
        Dept dept = deptMapper.findDept(2);
        System.out.println(dept.getDname());
        System.out.println(dept);
        //释放资源
        sqlSession.close();
    }

    @Test
    public void testFindUserRole() {
        SqlSessionFactory sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        mapper.findRoleById(1).forEach(System.out::println);
        sqlSession.close();
    }
}
