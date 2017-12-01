package com.ttms.serviceImpl;

import com.ttms.dao.EmpDao;
import com.ttms.service.EmpService;
import com.ttms.utils.BeanFactory;
import com.ttms.vo.Employee;
import com.ttms.vo.PageBean;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 */
public class EmpServiceImpl implements EmpService {

    @Override
    public PageBean<Employee> findByPage(int pageSize, Integer currPage) throws Exception {
        EmpDao empDao = (EmpDao) BeanFactory.getBean("EmpDao");
        List<Employee> list = empDao.findByPage(currPage, pageSize);
        int totalCount = empDao.getTotalCount();
        return new PageBean<>(pageSize, currPage, totalCount, list);
    }

    @Override
    public Employee getEmpById(String emp_id) throws Exception {
        EmpDao empDao = (EmpDao) BeanFactory.getBean("EmpDao");
        return empDao.getEmpById(emp_id);
    }

    @Override
    public void update(Employee emp) throws Exception {
        EmpDao empDao = (EmpDao) BeanFactory.getBean("EmpDao");
        empDao.update(emp);

    }

    @Override
    public void delEmp(String emp_id) throws Exception {
        EmpDao empDao = (EmpDao) BeanFactory.getBean("EmpDao");
        empDao.delEmp(emp_id);
    }

    @Override
    public PageBean<Employee> getEmps(String condition, int pageSize, Integer currPage) throws Exception {
        EmpDao empDao = (EmpDao) BeanFactory.getBean("EmpDao");
        List<Employee> list = null;
        int totalCount = 0;
        if (condition == null || condition.trim().length() <= 0) {
            list = empDao.findByPage(currPage, pageSize);
            totalCount=empDao.getTotalCount();
            System.out.println("调用无条件");
            return new PageBean<>(pageSize, currPage, totalCount, list);
        } else {
            list = empDao.getEmps(condition, pageSize, currPage);
            totalCount = empDao.getTotalCount(condition);
            return new PageBean<>(pageSize, currPage, totalCount, list);
        }
    }
}
