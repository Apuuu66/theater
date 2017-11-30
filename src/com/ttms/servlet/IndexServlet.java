package com.ttms.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 */
@WebServlet(name = "IndexServlet",urlPatterns = "/index")
public class IndexServlet extends BaseServlet {
    public String index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "/login.jsp";
    }
}
