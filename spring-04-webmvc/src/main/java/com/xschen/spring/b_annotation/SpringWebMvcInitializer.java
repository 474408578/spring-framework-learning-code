package com.xschen.spring.b_annotation;

import com.xschen.spring.b_annotation.config.RootConfiguration;
import com.xschen.spring.b_annotation.config.WebMvcConfiguration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContainerInitializer;

/**
 * 基于 servlet3.0 {@link WebApplicationInitializer}
 * @see ServletContainerInitializer
 * @author xschen
 */
public class SpringWebMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {RootConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {WebMvcConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
