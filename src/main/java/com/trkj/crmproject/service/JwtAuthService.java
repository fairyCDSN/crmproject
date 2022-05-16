package com.trkj.crmproject.service;


import com.trkj.crmproject.entity.mybatis.Users;
import com.trkj.crmproject.exception.CustomError;
import com.trkj.crmproject.exception.CustomErrorType;
import com.trkj.crmproject.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Objects;

//对自定义登录类进行封装
@Slf4j
@Repository
public class JwtAuthService {
    //AuthenticationManager接口的作用是对用户的未授信凭据进行认证，认证通过则返回授信状态的凭据，否则将抛出认证异常
    @Resource
    AuthenticationManager authenticationManager;

    @Resource
    UserDetailsService userDetailsService;

    @Resource
    JwtTokenUtil jwtTokenUtil;

    public String login(String username,String password) throws CustomError {

        Authentication authentication=null;
        try{
            //关于UsernamePasswordAuthenticationToken接口的详细知识：https://blog.csdn.net/qq_43072399/article/details/122226582
            log.debug("开始登录验证");
            //进行登录验证
            UsernamePasswordAuthenticationToken upToken=new UsernamePasswordAuthenticationToken(username,password);
            //登录验证
            log.debug(upToken+"这是登录Token");
            authentication=authenticationManager.authenticate(upToken);
            //如果认证通过，使用userId生成一个jwt
            log.debug(authentication+"");
            log.debug("验证成功");
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }catch (AuthenticationException e){
            log.info("++++++++++++++++++" + e.getClass().toString()+"++++++++++++++++++");
            if (e instanceof LockedException) {
                throw new CustomError(CustomErrorType.ACCOUNT_ERROR
                        , "账户已被锁定");
            }
            if (e instanceof DisabledException) {
                throw new CustomError(CustomErrorType.ACCOUNT_ERROR
                        , "账户已被禁用");
            }

            if (e instanceof CredentialsExpiredException) {
                throw new CustomError(CustomErrorType.ACCOUNT_ERROR
                        , "密码过期");
            }

            if(e instanceof InternalAuthenticationServiceException){
                throw new CustomError(CustomErrorType.ACCOUNT_ERROR
                        , "该用户不存在");
            }
            if (e instanceof AccountExpiredException) {
                throw new CustomError(CustomErrorType.ACCOUNT_ERROR
                        , "账户已过期");
            }
            if(e instanceof BadCredentialsException){
                throw new CustomError(CustomErrorType.ACCOUNT_ERROR
                        , "账户异常,"+e.getMessage());
            }
        }
        //获取到当前用户。这个对象通常是UserDetails的实例。
        Users userDetails = (Users) authentication.getPrincipal();
        log.debug(userDetails.toString());
        //generateToken是生成Token的方法
        return jwtTokenUtil.generateToken(userDetails.getUsername(),userDetails.getUser_id()+"");
    }

    public String refreshToken(String oldToken) {
        if (!jwtTokenUtil.isTokenExpired(oldToken)) {
            return jwtTokenUtil.refreshToken(oldToken);
        }
        return null;
    }

}
