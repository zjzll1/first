package cn.yunhe.test;

import cn.yunhe.entity.QueryVo;
import cn.yunhe.entity.User;
import cn.yunhe.mapper.UserMapper;
import cn.yunhe.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
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
        User user = new User(46,"琳","2023-08-14","女","jx");
        userMapper.updateUser(user);
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
    public void textFindByNameAndSex() {
        //可以获取会话工厂
        SqlSessionFactory sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        //得到会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取代理接口  基于动态代理形式
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        for (User user : userMapper.findByNameAndSex("老王", "男")) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void testFindBySelectMap() {
        //可以获取会话工厂
        SqlSessionFactory sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        //得到会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取代理接口  基于动态代理形式
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Object> map = new HashMap<>();
        map.put("username","琳");
        map.put("sex","女");
        for (User user : userMapper.findBySelectMap(map)) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void testFindBySelectPOJO() {
        //可以获取会话工厂
        SqlSessionFactory sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        //得到会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取代理接口  基于动态代理形式
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("琳");
        user.setSex("女");
        for (User user1 : userMapper.findBySelectPOJO(user)) {
            System.out.println(user1);
        }
        sqlSession.close();
    }

    @Test
    public void testFindBySelectPOJO1() {
        //可以获取会话工厂
        SqlSessionFactory sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        //得到会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取代理接口  基于动态代理形式
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("琳");
        user.setSex("女");
        QueryVo queryVo = new QueryVo();
        queryVo.setUser(user);
        for (User user1 : userMapper.findBySelectPOJO1(queryVo)) {
            System.out.println(user1);
        }
        sqlSession.close();
    }

    @Test
    public void testAddUser1() {
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
        userMapper.addUser1(user);
        System.out.println("刚刚插入数据的id"+user.getId());
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testFindByLikeSelect() {
        //可以获取会话工厂
        SqlSessionFactory sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        //得到会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取代理接口  基于动态代理形式
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("琳");
        user.setSex("女");
        for (User user1 : userMapper.findByLikeSelect(user)) {
            System.out.println(user1);
        }
        sqlSession.close();
    }

    @Test
    public void testEditUser() {
        //可以获取会话工厂
        SqlSessionFactory sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        //得到会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取代理接口  基于动态代理形式
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setId(41);
        user.setUsername("aaaa");
        userMapper.editUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteAll() {
        //可以获取会话工厂
        SqlSessionFactory sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        //得到会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取代理接口  基于动态代理形式
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(58);
        list.add(59);
        list.add(60);
        userMapper.deleteAll(list);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteAllArray() {
        //可以获取会话工厂
        SqlSessionFactory sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        //得到会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取代理接口  基于动态代理形式
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Integer arr[] = {54,55,56,57};
        userMapper.deleteAllArray(arr);
        sqlSession.commit();
        sqlSession.close();
    }
}
