package cn.yunhe.test;

import cn.yunhe.entity.Orders;
import cn.yunhe.mapper.OrdersMapper;
import cn.yunhe.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class OrdersMapperTest {

    @Test
    public void testFindOrder() {
        SqlSessionFactory sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
        Orders order = mapper.findOrder(2);
        System.out.println(order.getMoney());
        System.out.println(order.getUser());
        System.out.println(order.getUid());
        sqlSession.close();
    }
}
