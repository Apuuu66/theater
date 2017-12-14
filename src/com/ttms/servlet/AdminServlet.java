package com.ttms.servlet;

import com.ttms.service.EmpService;
import com.ttms.utils.BeanFactory;
import com.ttms.vo.Employee;
import com.ttms.vo.PageBean;
import com.ttms.vo.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 */
@SuppressWarnings("all")
@WebServlet(name = "AdminServlet", urlPatterns = "/admin")
public class AdminServlet extends BaseServlet {
    public String byPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer currPage = Integer.valueOf(request.getParameter("currPage"));
        if (currPage == null) {
            currPage = 1;
        }
        int pageSize = 6;
        EmpService s = (EmpService) BeanFactory.getBean("EmpService");
        PageBean<Employee> pb = s.findByPage(pageSize, currPage);
        request.setAttribute("pb", pb);
        return "/admin/emps.jsp";
    }

    public String getEmp(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String emp_id = request.getParameter("emp_id");
        EmpService s = (EmpService) BeanFactory.getBean("EmpService");
        Employee emp = s.getEmpById(emp_id);
        request.setAttribute("emp", emp);
        return "/admin/update.jsp";
    }

    public String getEmps(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String condition = request.getParameter("condition");
        System.out.println(condition);
        Integer currPage = Integer.valueOf(request.getParameter("currPage"));
        if (currPage == null) {
            currPage = 1;
        }
        int pageSize = 6;
        EmpService s = (EmpService) BeanFactory.getBean("EmpService");
        PageBean<Employee> pb = s.getEmps(condition, pageSize, currPage);
        request.setAttribute("pb", pb);
        return "/admin/query.jsp";


    }

    public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer page = Integer.valueOf(request.getParameter("page"));
        Employee emp = new Employee();
        Map<String, String[]> map = request.getParameterMap();
        BeanUtils.populate(emp, map);
        EmpService s = (EmpService) BeanFactory.getBean("EmpService");
        System.out.println(emp.getEmp_sex());
        s.update(emp);
        response.sendRedirect(request.getContextPath() + "/admin?method=byPage&currPage=" + page);
        return null;
    }

    public String delEmp(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String emp_id = request.getParameter("emp_id");
        Integer currPage = Integer.valueOf(request.getParameter("currPage"));
        if (currPage == null) {
            currPage = 1;
        }
        EmpService s = (EmpService) BeanFactory.getBean("EmpService");
        s.delEmp(emp_id);
        response.sendRedirect(request.getContextPath() + "/admin?method=byPage&currPage=" + currPage);
        return null;
    }

    public String addEmp(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println(1);
        Employee emp = new Employee();
        BeanUtils.populate(emp, request.getParameterMap());
        EmpService s = (EmpService) BeanFactory.getBean("EmpService");
        s.addEmp(emp);
        response.sendRedirect(request.getContextPath() + "/admin/emps.jsp");
        return null;
    }

    public String checkNo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String emp_no = request.getParameter("emp_no");
        System.out.println(emp_no);
        EmpService s = (EmpService) BeanFactory.getBean("EmpService");
        boolean flag = s.checkNo(emp_no);
        System.out.println(flag);

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(String.valueOf(flag));
        return null;
    }

    public String manageLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer currPage = Integer.valueOf(request.getParameter("currPage"));
        if (currPage == null) {
            currPage = 1;
        }
        int pageSize = 6;
        EmpService s = (EmpService) BeanFactory.getBean("EmpService");
        PageBean<User> pb = s.findUserByPage(pageSize, currPage);
        request.setAttribute("pb", pb);
        return "/admin/users.jsp";
    }

    public String delUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String emp_no = request.getParameter("emp_no");
        Integer currPage = Integer.valueOf(request.getParameter("currPage"));
        if (currPage == null) {
            currPage = 1;
        }
        EmpService s = (EmpService) BeanFactory.getBean("EmpService");
        s.delUser(emp_no);
        response.sendRedirect(request.getContextPath() + "/admin?method=manageLogin&currPage=" + currPage);
        return null;
    }

    public String getUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String emp_no = request.getParameter("emp_no");
        String currPage = request.getParameter("currPage");
        System.out.println(emp_no + currPage);
        EmpService s = (EmpService) BeanFactory.getBean("EmpService");
        User user = s.getUser(emp_no);
        request.setAttribute("user", user);
        return "/admin/updateuser.jsp";
    }

    public String updateuser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer currPage = Integer.valueOf(request.getParameter("currPage"));
        User user = new User();
        Map<String, String[]> map = request.getParameterMap();
        BeanUtils.populate(user, map);
        EmpService s = (EmpService) BeanFactory.getBean("EmpService");
        System.out.println(user.getEmp_no());
        s.updateuser(user);
        response.sendRedirect(request.getContextPath() + "/admin?method=manageLogin&currPage=" + currPage);
        return null;
    }

    public String getUsers(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String str = "";
        Integer currPage = Integer.valueOf(request.getParameter("currPage"));
        int pageSize = 6;
        EmpService s = (EmpService) BeanFactory.getBean("EmpService");
        PageBean<Employee> pb = s.findByPage(pageSize, currPage, str);
        request.setAttribute("pb", pb);
        return "/admin/adduser.jsp";
    }

    public String addUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String emp_no = request.getParameter("emp_no");
        EmpService s = (EmpService) BeanFactory.getBean("EmpService");
        s.addUser(emp_no);
        request.setAttribute("msg","添加成功");
        return "/admin/adduser.jsp";
    }
}
