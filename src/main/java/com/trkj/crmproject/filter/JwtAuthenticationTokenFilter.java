package com.trkj.crmproject.filter;


import com.trkj.crmproject.entity.mybatis.Users;
import com.trkj.crmproject.service.MyUserDetailsService;
import com.trkj.crmproject.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * @author 大熊
 * @date 2020-07-03
 * @Description:接口访问鉴权过滤器;当用户第一次登陆之后，我们将JWT令牌返回给了客户端，客户端将该令牌保存起来。
 *              在进行接口请求的时候，将令牌带上，放到HTTP的header里面，该过滤器进行令牌的解析
 * 1、拦截接口请求，从请求request获取token，从token中解析得到用户名
 * 然后通过UserDetailsService获得系统用户（从数据库、或其他其存储介质）
 * 根据用户信息和JWT令牌，验证系统用户与用户输入的一致性，并判断JWT是否过期。如果没有过期，至此表明了该用户的确是该系统的用户。
 * 但是，你是系统用户不代表你可以访问所有的接口。所以需要构造UsernamePasswordAuthenticationToken传递用户、权限信息，
 * 并将这些信息通过authentication告知Spring Security。
 * Spring Security会以此判断你的接口访问权限。
 * @version 1.0
 */
@Slf4j
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    // 令牌自定义标识
    @Value("${jwt.header}")
    private String header;
    @Resource
    JwtTokenUtil jwtTokenUtil;

    @Resource
    MyUserDetailsService myUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
//        log.debug(MyUserDetailsService.loadUserByUsername);
        String jwtToken = request.getHeader(header);
        log.info("在filter中，jwtToken:{}",jwtToken);
//        Enumeration en= request.getHeaderNames();
//        while (en.hasMoreElements()){
//            log.info("header ="+en.nextElement());
//        }
        if(!StringUtils.isEmpty(jwtToken)){
            String username = jwtTokenUtil.getUsernameFromToken(jwtToken);
            log.info("username={},Authentication={}",username,SecurityContextHolder.getContext().getAuthentication());
            if(username != null &&
                    SecurityContextHolder.getContext().getAuthentication() == null){
                //查询用户信息、权限信息、角色信息，并进行封装
                Users userDetails = myUserDetailsService.loadUserByUsername(username);
                log.info("userDetails:{}",userDetails);
                //效验
                if(jwtTokenUtil.validateToken(jwtToken,userDetails.getUsername())){
                    log.info("开始封装UsernamePasswordAuthenticationToken");
                    //给使用该JWT令牌的用户进行授权
                    UsernamePasswordAuthenticationToken authenticationToken
                            = new UsernamePasswordAuthenticationToken(userDetails,
                            null,userDetails.getAuthorities());
                    //SecurityContextHolder保留系统当前的安全上下文细节，其中就包括当前使用系统的用户的信息。
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }
        //去到下一个过滤器
        filterChain.doFilter(request,response);
    }

}
