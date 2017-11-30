package com.ttms.servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 通用的servlet
 */
public class BaseServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class clazz = this.getClass();
            // 2.获取请求的方法
            String m = request.getParameter("method");
            if (m == null) {
                m = "index";
            }
            // 3.获取方法对象
            Method method = clazz.getMethod(m, HttpServletRequest.class, HttpServletResponse.class);
            // 4.让方法执行 返回值为请求转发的路径
            String s = (String) method.invoke(this, request, response);//相当于 userservlet.add(request,response)
            // 5.判断s是否为空
            if (s != null) {
                request.getRequestDispatcher(s).forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/jsp/index.jsp";
    }

    public String XXX(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return null;
    }

}