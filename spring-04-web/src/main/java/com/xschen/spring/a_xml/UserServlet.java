package com.xschen.spring.a_xml;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xschen
 */

@WebServlet(urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    private UserService userService;

    /**
     * Servlet初始化时，取出ServletContext --> 通过ServletContext 取出 IOC容器
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        // 取出ServletContext
        ServletContext servletContext = config.getServletContext();
        // 取出IOC容器
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        this.userService = context.getBean(UserService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = userService.get();
        resp.getWriter().println(user);
    }
}
