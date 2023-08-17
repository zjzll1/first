package cn.yunhe.service;

import cn.yunhe.entity.User;

public interface UserService {
    User login(String username, String password);
}
