package com.ttms.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.ttms.service.SeatService;
import com.ttms.utils.BeanFactory;
import com.ttms.vo.Studio;
import jdk.nashorn.internal.parser.TokenType;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 * DateTime: 2017/12/14 14:49
 */
@WebServlet(name = "SeatServlet", urlPatterns = "/seat")
public class SeatServlet extends BaseServlet {
    public String query(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SeatService ss = (SeatService) BeanFactory.getBean("SeatService");
        Gson gson = new Gson();
//        Gson gson = new GsonBuilder().serializeNulls().create();//支持对值为null的对象进行封装

        List<Studio> studios=ss.getStudio();
        response.setContentType("text/html;charset=utf-8");
        String studio = gson.toJson(studios, new TypeToken<List<Studio>>(){}.getType());
        System.out.println(studio);
        PrintWriter out = response.getWriter();
        out.println(studio);
        out.flush();
        out.close();
        return null;
    }

    public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SeatService ss = (SeatService) BeanFactory.getBean("SeatService");
        ss.add();
        return null;
    }

    public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SeatService ss = (SeatService) BeanFactory.getBean("SeatService");
        return null;
    }

    public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SeatService ss = (SeatService) BeanFactory.getBean("SeatService");

        return null;
    }



}
