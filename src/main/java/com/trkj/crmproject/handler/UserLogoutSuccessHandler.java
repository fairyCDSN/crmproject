package com.trkj.crmproject.handler;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trkj.crmproject.util.ResponseUtil;
import com.trkj.crmproject.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * @author 大熊
 * @date 2020-07-03
 * @Description:自定义用户注销处理类，LogoutSuccessHandler有默认实现，但无法返回JSON数据
 * @version 1.0
 */
@Component
@Slf4j
public class UserLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws JsonProcessingException {
        log.info("退出系统！！！");
        AjaxResponse ajaxResponse= AjaxResponse.success("已退出");
        //SecurityContextHolder是SpringSecurity最基本的组件了，是用来存放SecurityContext的对象
        //在SecurityContextHolder中保存的是当前访问者的信息。Spring Security使用一个Authentication对象来表示这个信息。
        SecurityContextHolder.clearContext();
        ObjectMapper om=new ObjectMapper();
        ResponseUtil.responseJson(response, HttpStatus.OK, om.writeValueAsString(ajaxResponse));

    }
}
