package cn.yunhe.test;

import cn.yunhe.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.ResourceBundle;

public class UserDaoTest {
    @Test
    public void testFindAll() throws IOException {
        //1、读取核心的配置文件 sqlMapConfig.xml
        InputStream fis = Resources.getResourceAsStream("sqlMapConfig.xml");
        //2、创建会话工厂sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(fis,"mysql_01");
        //3、从工厂中产生sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4、调用查询方法  namespace.方法名称
        List<User> list = sqlSession.selectList("userMapper.findAll");
        list.forEach(System.out::println);
        //5、释放资源
        sqlSession.close();
    }

    @Test
    public void testAdd() throws IOException {
        //读取核心的配置文件 sqlMapConfig.xml
        InputStream fis = Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建会话工厂sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(fis);
        //从工厂中产生sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //调用查询方法  namespace.方法名称
        User user = new User();
        user.setUsername("123");
        user.setSex("nan");
        user.setAddress("aaa");
        user.setBirthday("2222-2-22");
        System.out.println(sqlSession.insert("userMapper.addUser", user) > 0 ? "添加成功" : "添加失败");
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Test
    public void testDel() throws IOException {
        //读取核心的配置文件 sqlMapConfig.xml
        InputStream fis = Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建会话工厂sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(fis);
        //从工厂中产生sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //调用查询方法  namespace.方法名称
        System.out.println(sqlSession.insert("userMapper.deleteUser", 49) > 0 ? "删除成功" : "删除失败");
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Test
    public void updateUser() throws IOException {
        //读取核心的配置文件 sqlMapConfig.xml
        InputStream fis = Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建会话工厂sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(fis);
        //从工厂中产生sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //调用查询方法  namespace.方法名称
        User user = new User(46, "77", "2002-10-28", "女", "jj");
        System.out.println(sqlSession.insert("userMapper.updateUser", user) > 0 ? "修改成功" : "修改失败");
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }
}