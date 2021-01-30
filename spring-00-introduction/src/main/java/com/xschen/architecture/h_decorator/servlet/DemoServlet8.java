package com.xschen.architecture.h_decorator.servlet;

import com.xschen.architecture.h_decorator.decorator.DemoServiceDecorator;
import com.xschen.architecture.h_decorator.factory.BeanFactory;
import com.xschen.architecture.h_decorator.service.DemoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 使用装饰器模式
 * @author xschen
 */


@WebServlet(urlPatterns = {"/demo8"})
public class DemoServlet8 extends HttpServlet {
    DemoService demoService = new DemoServiceDecorator((DemoService) BeanFactory.getBean("demoService"));


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(demoService.findAll());
        demoService.add("bear", 666);
    }
}
