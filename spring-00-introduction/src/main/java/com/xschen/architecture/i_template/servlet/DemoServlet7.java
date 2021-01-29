package com.xschen.architecture.i_template.servlet;

import com.xschen.architecture.i_template.factory.BeanFactory;
import com.xschen.architecture.i_template.service.DemoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xschen
 */


@WebServlet(urlPatterns = {"/demo7"})
public class DemoServlet7 extends HttpServlet {
    DemoService demoService = (DemoService) BeanFactory.getBean("demoService");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(demoService.findAll());
    }
}
