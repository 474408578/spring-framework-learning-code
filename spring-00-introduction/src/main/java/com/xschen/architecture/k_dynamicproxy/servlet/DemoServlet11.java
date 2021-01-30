package com.xschen.architecture.k_dynamicproxy.servlet;

import com.xschen.architecture.k_dynamicproxy.factory.BeanFactory;
import com.xschen.architecture.k_dynamicproxy.service.DemoService;
import com.xschen.architecture.k_dynamicproxy.utils.LogUtils;

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


@WebServlet(urlPatterns = {"/demo11"})
public class DemoServlet11 extends HttpServlet {
    DemoService demoService;

    @Override
    public void init() throws ServletException {
        DemoService demoService = (DemoService) BeanFactory.getBean("demoService");
        Class<? extends DemoService> clazz = demoService.getClass();
        this.demoService = (DemoService) Proxy.newProxyInstance(clazz.getClassLoader(),
                clazz.getInterfaces(),
                (proxy, method, args) -> {
                    LogUtils.printLog("DemoService", method.getName(), args);
                    return method.invoke(demoService, args);
        });
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(demoService.findAll());
        demoService.add("bear", 666);
        demoService.subtract("bear", 333);
    }
}
