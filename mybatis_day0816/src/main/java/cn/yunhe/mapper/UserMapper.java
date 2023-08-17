package cn.yunhe.mapper;

import cn.yunhe.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("select * from user")
    List<User> findAll();

    @Insert("insert into user (username,birthday,sex,address) values (#{username},#{birthday},#{sex},#{address})")
    void addUser(User user);

    @Update("update user set username=#{username},birthday=#{birthday},sex=#{sex},address=#{address} where id=#{id}")
    void updateUser(User user);

    @Delete("delete from user where id=#{id}")
    void deleteUserById(int id);

    @Select("select * from user where id=#{id}")
    User findUserByUid(Integer id);

    @Select("select * from user u,user_role ur where u.id=ur.uid and ur.rid=#{id}")
    User findUserById(Integer id);
}
