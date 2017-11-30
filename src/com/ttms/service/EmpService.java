package com.ttms.service;

import com.ttms.vo.Employee;
import com.ttms.vo.PageBean;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 */
public interface EmpService {

    PageBean<Employee> findByPage(int pageSize, Integer currPage) throws Exception;
}
