package com.trkj.crmproject.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * users
 * @author
 */
@Data
@Mapper
public class Users implements UserDetails {
    /**
     * id
     */
    private Integer user_id;

    /**
     * 用户名
     */
    private String user_name;

    /**
     * 密码
     */
    private String user_pass;

    /**
     * 创建时间
     */
    private Date create_time;

    /**
     * 组织id
     */
    private Integer org_id;

    /**
     * 手机号
     */
    private String phone;

    /**
     * email
     */
    private String email;

    /**
     * 是否有效
     */
    private boolean is_use;

    /**
     * 账号是否没有过期
     */
    private boolean account_non_expired;

    /**
     * 账户是否没有被锁定
     */
    private boolean account_non_locked;

    /**
     * 密码是否没有过期
     */
    private boolean credentials_non_expired;

    private String dept_son_name;

    private static final long serialVersionUID = 1L;

    Collection<? extends GrantedAuthority> authorities;  //用户的权限集合
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user_pass;
    }

    @Override
    public String getUsername() {
        return user_name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return account_non_expired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return account_non_locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentials_non_expired;
    }

    @Override
    public boolean isEnabled() {
        return is_use;
    }
}
