package com.ttms.dao;

import com.ttms.vo.User;

import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 */
public interface UserDao {
    User getUserByNameAndPwd(String emp_no, String emp_pass) throws SQLException;
}
