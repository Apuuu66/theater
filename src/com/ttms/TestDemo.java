package com.ttms;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.ttms.utils.DataSourceUtils;
import com.ttms.utils.DruidUtils;
import com.ttms.vo.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 */
public class TestDemo {
    @Test
    public void findAll() throws SQLException {
        DruidPooledConnection conn = DruidUtils.getInstance().getConnection();
        QueryRunner qr = new QueryRunner();
        String sql = "select * from user limit 1";
        User user = qr.query(conn, sql, new BeanHandler<>(User.class));
        System.out.println(user.getEmp_no());
        System.out.println(user.getRole());
        System.out.println(user.getEmp_pass());
    }

    @Test
    public void ttt() throws SQLException {
        QueryRunner qr = new QueryRunner(DruidUtils.getDs());
        String sql = "select * from user limit 1";
        User user = qr.query(sql, new BeanHandler<>(User.class));
        System.out.println(user.getEmp_no());
        System.out.println(user.getRole());
        System.out.println(user.getEmp_pass());
    }

    @Test
    public void eee() {
        String str = "/user?";
        System.out.println(str.startsWith("/user/"));
        str = "1 1";
        System.out.println(str.trim().length());
    }


    @Test
    public void getTotalCount() throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from employee";
        int totalCount = ((Long) qr.query(sql, new ScalarHandler())).intValue();
        System.out.println(totalCount);
    }


}
