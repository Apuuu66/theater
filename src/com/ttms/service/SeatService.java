package com.ttms.service;

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
}
