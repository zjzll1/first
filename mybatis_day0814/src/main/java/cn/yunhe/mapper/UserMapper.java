package cn.yunhe.mapper;

import cn.yunhe.entity.QueryVo;
import cn.yunhe.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface UserMapper {

    List<User> findAll();

    void addUser(User user);

    void updateUser(User user);

    void deleteUserById(int id);

    List<User> findByNameAndSex(@Param("username")String username,@Param("sex")String sex);

    List<User> findBySelectMap(HashMap<String,Object> map);

    List<User> findBySelectPOJO(User user);

    List<User> findBySelectPOJO1(QueryVo queryVo);

    void addUser1(User user);

    /*
     * 多条件查询
     *    username 模糊查  sex等值查询
     * */
    List<User> findByLikeSelect(User user);

    void editUser(User user);

    void deleteAll(ArrayList<Integer> ids);

    void deleteAllArray(Integer arr[]);
}
