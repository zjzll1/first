package cn.yunhe.mapper;

import cn.yunhe.entity.Role;
import cn.yunhe.entity.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {

    @Select("select * from role where id=#{id}")
    @Results({
            @Result(id = true, property = "id",column = "id"),
            @Result(property = "roleName",column = "role_name"),
            @Result(property = "roleDesc",column = "role_desc"),
            @Result(property = "userList",javaType = List.class,many = @Many(select = "cn.yunhe.mapper.UserMapper.findUserById"),column = "id")
    })
    List<Role> findRoleById(Integer id);
}
