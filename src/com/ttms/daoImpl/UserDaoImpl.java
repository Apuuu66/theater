package com.ttms.daoImpl;

import com.ttms.dao.UserDao;
import com.ttms.utils.DataSourceUtils;
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
        return qr.query(sql, new BeanHandler<>(User.class), emp_no, emp_pass);
    }

}
