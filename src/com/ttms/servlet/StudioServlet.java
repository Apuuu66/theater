package com.ttms.servlet;

import com.ttms.service.StudioService;
import com.ttms.utils.BeanFactory;
import com.ttms.vo.PageBean;
import com.ttms.vo.Studio;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 * Time: 2017/12/7 20:07
 */
@WebServlet(name = "StudioServlet", urlPatterns = "/studio")
public class StudioServlet extends BaseServlet {

    public String findAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer currPage = Integer.valueOf(request.getParameter("currPage"));
        if (currPage == null) {
            currPage = 1;
        }
        int pageSize = 6;
        StudioService ss = (StudioService) BeanFactory.getBean("StudioService");
        PageBean<Studio> pb = ss.findAllStudioByPage(pageSize, currPage);
        System.out.println(pb.getList()+"条数");
        request.setAttribute("pb", pb);
        return "/user/studio.jsp";
    }
}
