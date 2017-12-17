package com.ttms.service;

import com.ttms.vo.PageBean;
import com.ttms.vo.Studio;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 * Time: 2017/12/14 14:53
 */
public interface StudioService {
    PageBean<Studio> findAllStudioByPage(int pageSize, Integer currPage) throws Exception;

    public void add();

    public boolean update(Studio studio) throws Exception;

    public void delete(String studio_id) throws Exception;
}
