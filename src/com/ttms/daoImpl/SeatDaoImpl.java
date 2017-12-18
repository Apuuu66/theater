package com.ttms.daoImpl;

import com.ttms.dao.SeatDao;
import com.ttms.utils.DataSourceUtils;
import com.ttms.vo.Studio;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 * Time: 2017/12/17 22:21
 */
public class SeatDaoImpl implements SeatDao {
    QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
    @Override
    public List<Studio> getStudio() throws SQLException {
        String sql = "select studio_id,studio_name from studio";
        return qr.query(sql,new BeanListHandler<>(Studio.class));
    }
}
