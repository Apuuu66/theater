package com.ttms.dao;

import com.ttms.vo.Employee;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 */
public interface EmpDao {
    List<Employee> findByPage(Integer currPage, int pageSize) throws SQLException;

    int getTotalCount() throws SQLException;

}
