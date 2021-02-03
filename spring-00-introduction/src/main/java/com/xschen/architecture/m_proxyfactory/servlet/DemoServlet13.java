package com.xschen.architecture.m_proxyfactory.servlet;


import com.xschen.architecture.m_proxyfactory.factory.BeanFactory;
import com.xschen.architecture.m_proxyfactory.service.DemoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * @author xschen
 */


@WebServlet(urlPatterns = {"/demo13"})
public class DemoServlet13 extends HttpServlet {
    DemoService demoService = (DemoService) BeanFactory.getBean("demoService");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(demoService.findAll());
        demoService.add("bear", 666);
        demoService.subtract("bear", 333);
    }
}
