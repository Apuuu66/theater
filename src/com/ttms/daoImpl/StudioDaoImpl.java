package com.ttms.daoImpl;

import com.ttms.dao.StudioDao;
import com.ttms.utils.DataSourceUtils;
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
        return totalCount;
    }

    @Override
    public List<Studio> findAllStudioByPage(int pageSize, Integer currPage) throws SQLException {
        String sql = "select * from studio limit ?,?";
        return qr.query(sql, new BeanListHandler<>(Studio.class), (currPage - 1) * pageSize, pageSize);
    }

    @Override
    public boolean update(Studio studio) throws SQLException {
        String sql = "update studio set studio_name=?,studio_row_count=?,studio_col_count=?," +
                "studio_introduction=?,studio_flag=? where studio_id=?";
        int update = qr.update(sql, studio.getStudio_name(), studio.getStudio_row_count(), studio.getStudio_col_count(),
                studio.getStudio_introduction(), studio.getStudio_flag(), studio.getStudio_id());
        if (update > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void delete(String studio_id) throws SQLException {
        String sql = "delete from studio where studio_id = ?";
        qr.update(sql,studio_id);
    }
}
