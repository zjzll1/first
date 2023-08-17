package cn.yunhe.impl;



import cn.yunhe.JdbcUtils;
import cn.yunhe.LoginDao;
import cn.yunhe.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class LoginDaoImpl implements LoginDao {
    QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
    @Override
    public User findByName(User user) {
        try {
            return qr.query("select * from users where username=?",new BeanHandler<User>(User.class),user.getUsername());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
