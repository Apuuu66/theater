package com.ttms.serviceImpl;

import com.ttms.dao.UserDao;
import com.ttms.service.UserService;
import com.ttms.utils.BeanFactory;
import com.ttms.vo.User;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 */
public class UserServiceImpl implements UserService {

    @Override
    public User getUserByNameAndPwd(String emp_no, String emp_pass) throws Exception {
        UserDao userDao = (UserDao) BeanFactory.getBean("UserDao");
        return userDao.getUserByNameAndPwd(emp_no,emp_pass);
    }
}
