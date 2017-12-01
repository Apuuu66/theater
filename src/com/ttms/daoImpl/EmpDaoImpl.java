package com.ttms.daoImpl;

import com.ttms.dao.EmpDao;
import com.ttms.utils.DataSourceUtils;
import com.ttms.vo.Employee;
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
        return qr.query(sql,new BeanListHandler<>(Employee.class),(currPage-1)*pageSize,pageSize);
    }

    @Override
    public int getTotalCount() throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from employee";
        int totalCount = ((Long)qr.query(sql, new ScalarHandler())).intValue();
        return totalCount;
    }

    @Override
    public Employee getEmpById(String emp_id) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from employee where emp_id = ?";
        return qr.query(sql,new BeanHandler<Employee>(Employee.class),emp_id);
    }

    @Override
    public void update(Employee e) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update employee set emp_name = ?,emp_sex = ?,emp_tel_num = ?,emp_addr = ?,emp_email = ? where emp_id = ?";
        qr.update(sql,e.getEmp_name(),e.getEmp_sex(),e.getEmp_tel_num(),e.getEmp_addr(),e.getEmp_email(),e.getEmp_id());
    }

    @Override
    public void delEmp(String emp_id) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from employee where emp_id = ?";
        qr.update(sql, emp_id);
    }
}
