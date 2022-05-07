package com.trkj.crmproject.handler;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trkj.crmproject.exception.CustomError;
import com.trkj.crmproject.exception.CustomErrorType;
import com.trkj.crmproject.util.ResponseUtil;
import com.trkj.crmproject.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * @author 大熊
 * @date 2020-07-03
 * @Description:自定义用户未登录处理类，AuthenticationEntryPoint有默认实现，但无法返回JSON数据
 * @version 1.0
 */
@Component
@Slf4j
public class UserAuthenticationEntryPointHandler implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws JsonProcessingException {
        log.info("没有登录，无法访问");
        AjaxResponse ajaxResponse= AjaxResponse.error(new CustomError(CustomErrorType.ACCOUNT_ERROR,"未登录"));
        ObjectMapper om=new ObjectMapper();
        ResponseUtil.responseJson(response, HttpStatus.UNAUTHORIZED, om.writeValueAsString(ajaxResponse));
    }
}
