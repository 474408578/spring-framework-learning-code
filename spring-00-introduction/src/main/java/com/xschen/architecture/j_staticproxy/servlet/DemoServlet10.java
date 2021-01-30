package com.xschen.architecture.j_staticproxy.servlet;


import com.xschen.architecture.j_staticproxy.factory.BeanFactory;
import com.xschen.architecture.j_staticproxy.service.DemoService;
import com.xschen.architecture.j_staticproxy.service.DemoServiceProxy;
import com.xschen.architecture.j_staticproxy.service.impl.DemoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xschen
 */


@WebServlet(urlPatterns = {"/demo10"})
public class DemoServlet10 extends HttpServlet {
    DemoService demoService = new DemoServiceProxy((DemoServiceImpl) BeanFactory.getBean("demoService"));

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(demoService.findAll());
        demoService.add("bear", 666);
    }
}
