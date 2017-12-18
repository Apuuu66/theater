package com.ttms.serviceImpl;

import com.ttms.dao.SeatDao;
import com.ttms.service.SeatService;
import com.ttms.utils.BeanFactory;
import com.ttms.vo.Studio;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 * Time: 2017/12/17 22:20
 */
public class SeatServiceImpl implements SeatService {
    @Override
    public void add() {

    }

    @Override
    public List<Studio> getStudio() throws Exception {
        SeatDao sd = (SeatDao) BeanFactory.getBean("SeatDao");
        return sd.getStudio();
    }
}
