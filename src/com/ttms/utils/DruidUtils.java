package com.ttms.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 数据库连接操作类:使用Druid连接池*
 */
public final class DruidUtils {
    private static DruidUtils instance = null;
    private static DruidDataSource ds = null;

    // 初始化,只执行一次
    static {
        String path = Class.class.getClass().getResource("/").getPath() + "druid.properties";
        try {
            System.out.println(path);
            FileInputStream fis = new FileInputStream(path);
            Properties p = new Properties();
            p.load(fis);
            // 加载properties文件，创建数据源
            ds = (DruidDataSource) DruidDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库实例
     *
     * @return 连接对象ConnectionManager
     */
    public synchronized static final DruidUtils getInstance() {
        if (instance == null) {
            try {
                instance = new DruidUtils();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    /**
     * 获取数据库连接
     *
     * @return 数据库连接对象DruidPooledConnection
     */
    public synchronized final DruidPooledConnection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭数据库连接
     *
     * @return void
     */
    public static void close(ResultSet rs, Statement stmt, Connection con) {
        try {
            if (rs != null)
                rs.close();
            if (stmt != null)
                stmt.close();
            if (con != null)
                con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConn(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DruidDataSource getDs() {
        return ds;
    }
}
