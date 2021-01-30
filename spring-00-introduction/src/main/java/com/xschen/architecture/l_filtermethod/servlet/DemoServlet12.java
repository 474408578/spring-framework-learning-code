package com.xschen.architecture.l_filtermethod.servlet;

import com.xschen.architecture.l_filtermethod.factory.BeanFactory;
import com.xschen.architecture.l_filtermethod.service.DemoService;
import com.xschen.architecture.l_filtermethod.utils.LogUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @author xschen
 */


@WebServlet(urlPatterns = {"/demo12"})
public class DemoServlet12 extends HttpServlet {
    DemoService demoService;

    @Override
    public void init() throws ServletException {

        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getClassLoader().getResourceAsStream("proxy.properties"));
        } catch (IOException e) {
            throw new ExceptionInInitializerError("DemoServlet12 initialize error, cause: " + e.getMessage());
        }

        DemoService demoService = (DemoService) BeanFactory.getBean("demoService");
        Class<? extends DemoService> clazz = demoService.getClass();
        this.demoService = (DemoService) Proxy.newProxyInstance(clazz.getClassLoader(),
                clazz.getInterfaces(),
                ((proxy, method, args) -> {
                    List<String> list = Arrays.asList(properties.getProperty("log.methods").replaceAll(" ", "").split(","));
                    if (list.contains(method.getName())) {
                        LogUtils.printLog("DemoService", method.getName(), args);
                    }
                    return method.invoke(demoService, args);
                }));

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(demoService.findAll());
        demoService.add("bear", 666);
        demoService.subtract("bear", 333);
    }
}
