package cn.yunhe.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    static DataSource dataSource;

    static {
        Properties pro = new Properties();
        try {
            pro.load(JdbcUtils.class.getClassLoader().getResourceAsStream("durid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回连接池
     */
    public static DataSource getDataSource() {
        return dataSource;
    }

    /**
     * 返回连接对像
     */
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
