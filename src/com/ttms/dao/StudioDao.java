package com.ttms.dao;

import com.ttms.vo.Studio;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 * Time: 2017/12/14 14:54
 */
public interface StudioDao {

    int getTotalCount() throws SQLException;

    List<Studio> findAllStudioByPage(int pageSize, Integer currPage) throws SQLException;

    boolean update(Studio studio) throws SQLException;

    void delete(String studio_id) throws SQLException;
}
