package com.trkj.crmproject.interceptor;


import com.trkj.crmproject.util.JwtTokenUtil;
import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {

    @Resource
    private JwtTokenUtil jwtTokenUtil;
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws SignatureException {
        /** 地址过滤 */
        String uri = request.getRequestURI() ;
        log.debug("请求地址为："+uri);
        if (uri.contains("/login")){
            return true ;
        }
        log.debug("这是浏览器的方法"+request.getMethod());
        /** Token 验证 */
        //获取到Token
        String token = request.getHeader(jwtTokenUtil.getHeader());
        log.debug("这是登录的Token验证"+token);
//        String token = request.getHeader("JWTDemo");
        if(StringUtils.isEmpty(token)){
            token = request.getParameter(jwtTokenUtil.getHeader());
        }
        if(StringUtils.isEmpty(token)){
            throw new SignatureException("token为空");
        }
        if(jwtTokenUtil.isTokenExpired(token))
            throw new SignatureException(jwtTokenUtil.getHeader() + "失效，请重新登录。");
//        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
//            response.setStatus(HttpServletResponse.SC_OK);
//            return false;
//        }
        /** 设置 identityId 用户身份ID */
       // request.setAttribute("identityId", jwtTokenUtil.getUsernameFromToken(token));
        return true;
    }
}
