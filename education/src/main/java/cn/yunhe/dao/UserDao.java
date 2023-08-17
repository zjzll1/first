package cn.yunhe.dao;

import cn.yunhe.entity.User;

public interface UserDao {
    User login(String username, String password);
}
