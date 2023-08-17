package cn.yunhe.impl;


import cn.yunhe.LoginDao;
import cn.yunhe.LoginService;
import cn.yunhe.User;

public class LoginServiceImpl implements LoginService {
    LoginDao dao = new LoginDaoImpl();
    @Override
    public User findByName(User user) {
        return dao.findByName(user);
    }
}
