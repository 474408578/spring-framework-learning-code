package com.xschen.architecture.a_original.servlet;

import com.xschen.architecture.a_original.service.DemoService;
import com.xschen.architecture.a_original.service.impl.DemoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xschen
 */

@WebServlet(urlPatterns = "/demo1")
public class DemoServlet1 extends HttpServlet {


    DemoService demoService = new DemoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().println(demoService.findAll().toString());
    }

}