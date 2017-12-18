package com.ttms.servlet;

import com.google.gson.Gson;
import com.ttms.service.StudioService;
import com.ttms.utils.BeanFactory;
import com.ttms.vo.PageBean;
import com.ttms.vo.Studio;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

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
        request.setAttribute("pb", pb);
        return "/user/studio.jsp";
    }

    public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String json = request.getParameter("studio");
        Gson gson = new Gson();
        Studio studio = gson.fromJson(json, Studio.class);
        StudioService ss = (StudioService) BeanFactory.getBean("StudioService");
        boolean flag = ss.update(studio);
        PrintWriter out = response.getWriter();
        if (flag == true) {
            out.println(1);
        } else {
            out.println(0);
        }
        out.flush();
        out.close();
        return null;
    }


    public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String studio_id = request.getParameter("studio_id");
        String currPage = request.getParameter("currPage");
        StudioService ss = (StudioService) BeanFactory.getBean("StudioService");
        ss.delete(studio_id);
        response.sendRedirect(request.getContextPath()+"/studio?method=findAll&currPage="+currPage);
        return null;
    }

    public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Studio studio = new Studio();
        BeanUtils.populate(studio,request.getParameterMap());
        StudioService ss = (StudioService) BeanFactory.getBean("StudioService");
        ss.add(studio);
        response.sendRedirect(request.getContextPath()+"/studio?method=findAll&currPage=1");
        return null;
    }
}
