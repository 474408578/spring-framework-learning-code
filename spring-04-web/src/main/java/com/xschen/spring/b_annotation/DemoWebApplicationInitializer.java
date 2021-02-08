package com.xschen.spring.b_annotation;

import org.springframework.web.context.AbstractContextLoaderInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContainerInitializer;

/**
 *
 *
 * 借助Java的SPI技术，可以从项目或者项目依赖的Jar包中，找到一个
 * /META-INF/org.springframework.web.SpringServletContainerInitializer 的文件，并加载项目中所有它的实现类。
 * {@link ServletContainerInitializer} 这个接口通常会配合 @HandlesTypes使用，这个注解中可以传入一些我们所需要
 * 接口/抽象类。支持 Servlet 3.0 规范的 Web 容器会在容器启动项目初始化时，
 * 把这些接口 / 抽象类的实现类全部都找出来，整合为一个 Set ，
 * 传入 ServletContainerInitializer 的 onStartup 方法参数中，
 * 这样我们就可以在 onStartUp 中拿到这些实现类，随机反射创建调用等等的动作。
 * @author xschen
 */

public class DemoWebApplicationInitializer extends AbstractContextLoaderInitializer {
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(UserConfiguration.class);
        return ctx;
    }
}
