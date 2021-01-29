package com.xschen.architecture.f_pointslog.servlet;

import com.xschen.architecture.f_pointslog.factory.BeanFactory;
import com.xschen.architecture.f_pointslog.service.DemoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xschen
 */


@WebServlet(urlPatterns = {"/demo6"})
public class DemoServlet6 extends HttpServlet {
    DemoService demoService = (DemoService) BeanFactory.getBean("demoService");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(demoService.findAll());
    }
}
