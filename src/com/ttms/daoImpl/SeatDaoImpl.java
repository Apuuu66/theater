package com.ttms.daoImpl;

import com.ttms.dao.SeatDao;
import com.ttms.utils.DataSourceUtils;
import com.ttms.vo.Seat;
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
        String sql = "select studio_id,studio_name ,studio_row_count,studio_col_count from studio";
        return qr.query(sql,new BeanListHandler<>(Studio.class));
    }

    @Override
    public List<Seat> getSeatByStudioID(String studioId) throws SQLException {
        String sql = "select * from seat where studio_id = ?";
        return qr.query(sql,new BeanListHandler<>(Seat.class),studioId);
    }

    @Override
    public void update(String seat_id, String seat_status) throws SQLException {
        String sql = "update seat set seat_status = ? where seat_id = ?";
        qr.update(sql,seat_status,seat_id);
    }
}
