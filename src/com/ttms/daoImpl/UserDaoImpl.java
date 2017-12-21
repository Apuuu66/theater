package com.ttms.daoImpl;

import com.ttms.dao.UserDao;
import com.ttms.utils.DataSourceUtils;
import com.ttms.vo.Employee;
import com.ttms.vo.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User getUserByNameAndPwd(String emp_no, String emp_pass) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where emp_no = ? and emp_pass = ?";
        User user = qr.query(sql, new BeanHandler<>(User.class), emp_no, emp_pass);
        if (user != null) {
            sql="select * from employee where emp_no = ?";
            Employee employee = qr.query(sql, new BeanHandler<>(Employee.class), emp_no);
            user.setEmp(employee);
        }
        return user;
    }

    @Override
    public void update(User user) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update user set role = ?,emp_pass = ?,head_path = ? where emp_no = ?";
        qr.update(sql, user.getRole(), user.getEmp_pass(),user.getHead_path(), user.getEmp_no());
    }

}
