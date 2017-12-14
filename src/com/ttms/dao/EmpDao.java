package com.ttms.dao;

import com.ttms.vo.Employee;
import com.ttms.vo.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 */
public interface EmpDao {
    List<Employee> findByPage(Integer currPage, int pageSize) throws SQLException;

    int getTotalCount() throws SQLException;

    Employee getEmpById(String emp_id) throws SQLException;

    void update(Employee emp) throws SQLException;

    void delEmp(String emp_id) throws SQLException;

    int getTotalCount(String condition) throws SQLException;

    List<Employee> getEmps(String condition, int pageSize, Integer currPage) throws SQLException;

    void addEmp(Employee emp) throws SQLException;

    boolean checkNo(String emp_no) throws SQLException;

    List<User> findUserByPage(Integer currPage, int pageSize) throws SQLException;

    int getUserTotalCount() throws SQLException;

    void delUser(String emp_no) throws SQLException;

    User getUser(String emp_no) throws SQLException;

    void updateuser(User user) throws SQLException;

    List<Employee> findByPage(Integer currPage, int pageSize, String str) throws SQLException;

    int getTotalCount(int i) throws SQLException;

    void addUser(String emp_no) throws SQLException;
}
