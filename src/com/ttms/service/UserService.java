package com.ttms.service;

import com.ttms.vo.User;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 */
public interface UserService {

    User getUserByNameAndPwd(String emp_no, String emp_pass) throws Exception;
}
