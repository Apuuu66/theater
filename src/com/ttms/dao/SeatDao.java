package com.ttms.dao;

import com.ttms.vo.Studio;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 * Time: 2017/12/17 22:20
 */
public interface SeatDao {
    List<Studio> getStudio() throws SQLException;

}
