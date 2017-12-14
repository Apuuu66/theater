package com.ttms.daoImpl;

import com.ttms.dao.StudioDao;
import com.ttms.utils.DataSourceUtils;
import com.ttms.vo.Employee;
import com.ttms.vo.Studio;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 * Time: 2017/12/14 14:54
 */
public class StudioDaoImpl implements StudioDao {
    QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
    @Override
    public int getTotalCount() throws SQLException {
        String sql = "select count(*) from studio";
        int totalCount = ((Long) qr.query(sql, new ScalarHandler())).intValue();
        System.out.println(totalCount);
        return totalCount;
    }
    @Override
    public List<Studio> findAllStudioByPage(int pageSize, Integer currPage) throws SQLException {
        String sql = "select * from studio limit ?,?";
        return qr.query(sql, new BeanListHandler<>(Studio.class), (currPage - 1) * pageSize, pageSize);
    }
}
