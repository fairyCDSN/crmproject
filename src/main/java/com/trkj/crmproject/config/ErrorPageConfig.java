package com.trkj.crmproject.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ErrorPageConfig implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage page404 = new ErrorPage(HttpStatus.NOT_FOUND, "/error404");//需要给改请求加一个Controller
        ErrorPage page403 = new ErrorPage(HttpStatus.FORBIDDEN, "/error403");
        //ErrorPage page500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error500");
        //registry.addErrorPages(page404, page500);
        registry.addErrorPages(page404,page403);
    }
}
