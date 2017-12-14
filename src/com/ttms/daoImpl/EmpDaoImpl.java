package com.ttms.daoImpl;

import com.ttms.dao.EmpDao;
import com.ttms.utils.DataSourceUtils;
import com.ttms.vo.Employee;
import com.ttms.vo.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 */
public class EmpDaoImpl implements EmpDao {
    @Override
    public List<Employee> findByPage(Integer currPage, int pageSize) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from employee limit ?,?";
        return qr.query(sql, new BeanListHandler<>(Employee.class), (currPage - 1) * pageSize, pageSize);
    }

    @Override
    public int getTotalCount() throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from employee";
        int totalCount = ((Long) qr.query(sql, new ScalarHandler())).intValue();
        return totalCount;
    }

    @Override
    public Employee getEmpById(String emp_id) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from employee where emp_id = ?";
        return qr.query(sql, new BeanHandler<Employee>(Employee.class), emp_id);
    }

    @Override
    public void update(Employee e) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update employee set emp_name = ?,emp_sex = ?,emp_tel_num = ?,emp_addr = ?,emp_email = ? where emp_id = ?";
        qr.update(sql, e.getEmp_name(), e.getEmp_sex(), e.getEmp_tel_num(), e.getEmp_addr(), e.getEmp_email(), e.getEmp_id());
    }

    @Override
    public void delEmp(String emp_id) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from employee where emp_id = ?";
        qr.update(sql, emp_id);
    }

    @Override
    public int getTotalCount(String condition) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from employee where emp_no like ?";
        int totalCount = ((Long) qr.query(sql, new ScalarHandler(), "%" + condition + "%")).intValue();
        return totalCount;
    }

    @Override
    public List<Employee> getEmps(String condition, int pageSize, Integer currPage) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from employee where emp_no like ? limit ?,?";
        return qr.query(sql, new BeanListHandler<>(Employee.class), "%" + condition + "%", (currPage - 1) * pageSize, pageSize);
    }

    @Override
    public void addEmp(Employee e) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "INSERT INTO `employee` (`emp_no`, `emp_name`,emp_sex ,`emp_tel_num`, `emp_addr`, `emp_email`) VALUES (?,?,?,?,?,?)";
        qr.update(sql, e.getEmp_no(), e.getEmp_name(), e.getEmp_sex(), e.getEmp_tel_num(), e.getEmp_addr(), e.getEmp_email());
    }

    @Override
    public boolean checkNo(String emp_no) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from employee where emp_no = ? limit 1";
        Employee user = qr.query(sql, new BeanHandler<>(Employee.class), emp_no);
        if (user != null) {
            System.out.println(user.getEmp_no());
            return true;
        }
        return false;
    }

    @Override
    public List<User> findUserByPage(Integer currPage, int pageSize) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user limit ?,?";
        return qr.query(sql, new BeanListHandler<>(User.class), (currPage - 1) * pageSize, pageSize);
    }

    @Override
    public int getUserTotalCount() throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from user";
        int totalCount = ((Long) qr.query(sql, new ScalarHandler())).intValue();
        return totalCount;
    }

    @Override
    public void delUser(String emp_no) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from user where emp_no = ?";
        qr.update(sql, emp_no);
    }

    @Override
    public User getUser(String emp_no) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where emp_no = ?";
        return qr.query(sql, new BeanHandler<>(User.class), emp_no);
    }

    @Override
    public void updateuser(User user) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update user set role = ?,emp_pass = ? where emp_no = ?";
        qr.update(sql, user.getRole(), user.getEmp_pass(), user.getEmp_no());
    }

    @Override
    public List<Employee> findByPage(Integer currPage, int pageSize, String str) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "SELECT * FROM employee WHERE NOT EXISTS (select `user`.emp_no FROM `user` WHERE `user`.emp_no=employee.emp_no) limit ?,?";
        return qr.query(sql, new BeanListHandler<>(Employee.class), (currPage - 1) * pageSize, pageSize);
    }

    @Override
    public int getTotalCount(int i) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from employee WHERE NOT EXISTS (select `user`.emp_no FROM `user` WHERE `user`.emp_no=employee.emp_no)";
        int totalCount = ((Long) qr.query(sql, new ScalarHandler())).intValue();
        return totalCount;
    }

    @Override
    public void addUser(String emp_no) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "INSERT INTO `user` (`emp_no`) VALUES (?)";
        qr.update(sql, emp_no);
    }
}
