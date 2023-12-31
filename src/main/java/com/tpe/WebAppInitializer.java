package com.tpe;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//instead of web.xml we will use config classes

//we need to register dispatcher servlet
//AbstractAnnotationConfigDispatcherServletInitializer is used to start dispatcher servlet
public class WebAppInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer {

    /*
    Dispatcher servlet Webcontext -> Controller, Handler Mapping, View Resolver(render)
     */

    @Override //DB and hibernate configuration
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]
                {
                        RootContextConfig.class
                };
    }

    @Override //MVC Configs (Controller, Handler Mapping, View Resolver(render))
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                WebMvcConfigurer.class
        };
    }

    @Override //servlet and url mapping
    protected String[] getServletMappings() {
        return new String[]{
                "/" //all request will be received
        };
    }
}
