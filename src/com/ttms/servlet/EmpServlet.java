package com.ttms.servlet;

import com.ttms.service.EmpService;
import com.ttms.utils.BeanFactory;
import com.ttms.vo.Employee;
import com.ttms.vo.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 */
@WebServlet(name = "EmpServlet",urlPatterns = "/emp")
public class EmpServlet extends BaseServlet {
    public String byPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer currPage = Integer.valueOf(request.getParameter("currPage"));
        int pageSize=10;
        EmpService s = (EmpService) BeanFactory.getBean("EmpService");
        PageBean<Employee> pb=s.findByPage(pageSize,currPage);
        request.setAttribute("pb",pb);
        return "/admin/emps.jsp";
    }
}
