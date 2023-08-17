package cn.yunhe.pool;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

public class MyPooled extends UnpooledDataSourceFactory {

    public MyPooled() {
        this.dataSource = new DruidDataSource();
    }
}
