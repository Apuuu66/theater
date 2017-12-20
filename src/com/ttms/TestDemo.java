package com.ttms;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ttms.utils.DataSourceUtils;
import com.ttms.utils.DruidUtils;
import com.ttms.vo.Employee;
import com.ttms.vo.Studio;
import com.ttms.vo.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List list=new ArrayList();
        System.out.println(list.size());
    }


    @Test
    public void getTotalCount() throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from employee";
        int totalCount = ((Long) qr.query(sql, new ScalarHandler())).intValue();
        System.out.println(totalCount);
    }

    @Test
    public void tttt() {
        Employee emp = new Employee();
        emp.setEmp_no("1");
        emp.setEmp_id(2);
        emp.setEmp_name("张三");
        Gson gson = new Gson();
        String s = gson.toJson(emp, Employee.class);
        System.out.println(s);

        Person person1 = new Person();
        person1.setId(1);
        person1.setName("李四");
        person1.setpEmailAdd("家里");
        System.out.println(gson.toJson(person1));

        Person person2 = new Person();
        person2.setId(2);
        person2.setName("王立");
        person2.setpEmailAdd("家佳佳");
        System.out.println(gson.toJson(person2, Person.class));
        List<Person> list = new ArrayList<>();
        list.add(person1);
        list.add(person2);
        String s1 = gson.toJson(list, new TypeToken<List<Person>>() {
        }.getType());
        System.out.println(s1);
    }

    @Test
    public void t3() throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from studio";
        int totalCount = ((Long) qr.query(sql, new ScalarHandler())).intValue();
        System.out.println(totalCount);


        String sql1 = "select * from studio limit ?,?";
        List<Studio> query = qr.query(sql1, new BeanListHandler<>(Studio.class), 0, 6);
        for (int i = 0; i < query.size(); i++) {
            Studio studio = query.get(i);
            System.out.println(studio.getStudio_name());
        }
    }

    @Test
    public void t4() throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "SELECT * FROM `studio` ORDER BY `studio_id` DESC ";
        Object[] query = qr.query(sql, new ArrayHandler());
        System.out.println(query.length);
        System.out.println(Arrays.toString(query));
        System.out.println(query[0]);
        Integer i= (Integer) query[2];
        System.out.println(i);
    }

}