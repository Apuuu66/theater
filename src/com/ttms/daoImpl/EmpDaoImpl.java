package com.ttms.daoImpl;

import com.ttms.dao.EmpDao;
import com.ttms.utils.DataSourceUtils;
import com.ttms.vo.Employee;
import org.apache.commons.dbutils.QueryRunner;
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



}
