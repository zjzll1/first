package cn.yunhe.mapper;

import cn.yunhe.entity.Orders;
import cn.yunhe.entity.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface OrdersMapper {

    @Select("select * from orders where id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "user",javaType = User.class,one = @One(select = "cn.yunhe.mapper.UserMapper.findUserByUid"),column = "uid")
    })
    Orders findOrderById(Integer id);
}
