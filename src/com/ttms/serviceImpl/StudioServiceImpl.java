package com.ttms.serviceImpl;

import com.ttms.dao.StudioDao;
import com.ttms.service.StudioService;
import com.ttms.utils.BeanFactory;
import com.ttms.vo.PageBean;
import com.ttms.vo.Studio;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 * Time: 2017/12/14 14:53
 */
public class StudioServiceImpl implements StudioService {
    @Override
    public PageBean<Studio> findAllStudioByPage(int pageSize, Integer currPage) throws Exception {
        StudioDao sd = (StudioDao) BeanFactory.getBean("StudioDao");
        List<Studio> list = sd.findAllStudioByPage(pageSize,currPage);
        int totalCount = sd.getTotalCount();
        return new PageBean<>(pageSize,currPage,totalCount, list);
    }

    @Override
    public void add() {

    }

    @Override
    public boolean update(Studio studio) throws Exception {
        StudioDao sd = (StudioDao) BeanFactory.getBean("StudioDao");
        return sd.update(studio);
    }

    @Override
    public void delete(String studio_id) throws Exception {
        StudioDao sd = (StudioDao) BeanFactory.getBean("StudioDao");
        sd.delete(studio_id);
    }
}
