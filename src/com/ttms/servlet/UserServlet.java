package com.ttms.servlet;

import com.ttms.service.UserService;
import com.ttms.utils.BeanFactory;
import com.ttms.vo.User;
import org.apache.commons.io.IOUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 */
@MultipartConfig
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

    public String replace(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");
        String realPath = this.getServletContext().getRealPath("/uuu/");
        User user = (User) request.getSession().getAttribute("userlogin");
        //获取上传文件
        Part part = request.getPart("part");
        String name = part.getName();

        //获取文件名
        String header = part.getHeader("Content-Disposition");

        String filename = header.substring(header.lastIndexOf("."), header.length() - 1);

        InputStream is = part.getInputStream();
        String head_path = realPath + user.getEmp_no() + filename;
        FileOutputStream os = new FileOutputStream(head_path);
        IOUtils.copy(is, os);
        os.close();
        is.close();
        user.setHead_path("/uuu/"+user.getEmp_no()+filename);
        UserService us = (UserService) BeanFactory.getBean("UserService");
        us.update(user);
        request.getSession().removeAttribute("userlogin");
        request.getSession().setAttribute("userlogin", user);
        response.sendRedirect(request.getContextPath()+"/userInfo.jsp");
        return null;
    }
}
