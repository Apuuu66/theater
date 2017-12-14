package com.ttms.servlet;

import com.ttms.service.UserService;
import com.ttms.utils.BeanFactory;
import com.ttms.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 */
@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends BaseServlet {
    public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getSession().removeAttribute("user");
        String emp_no = request.getParameter("emp_no");
        String emp_pass = request.getParameter("emp_pass");
        System.out.println(emp_no);
        UserService us = (UserService) BeanFactory.getBean("UserService");
        User user = us.getUserByNameAndPwd(emp_no, emp_pass);

        if (user == null) {
            request.setAttribute("msg", "用户名密码不匹配");
            return "/login.jsp";
        }
        System.out.println(user.getEmp_pass());
        request.getSession().setAttribute("userlogin", user);
        System.out.println(request.getContextPath());
        String path = "/";
        if (user.getRole() == 1) {
            path = "/admin/index.jsp";
        } else if (user.getRole() == 0) {
            path = "/user/index.jsp";
        }
        response.sendRedirect(request.getContextPath() + path);
        return null;
    }

    public String regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return null;
    }


    public String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("user");
        response.sendRedirect(request.getContextPath());
        return null;
    }
}
