package com.ttms.service;

import com.ttms.vo.Seat;
import com.ttms.vo.Studio;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 * Time: 2017/12/17 22:20
 */
public interface SeatService {

    void add();

    List<Studio> getStudio() throws Exception;

    List<Seat> getSeatByStudioID(String studioId) throws Exception;

    void update(String seat_id, String seat_status) throws Exception;
}
