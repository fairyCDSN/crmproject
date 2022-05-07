package com.trkj.crmproject.vo;

import com.trkj.crmproject.entity.Sonmenu;
import lombok.Data;

import java.util.List;

@Data
public class UserVo {
    //主键id
    private int id;
    //用户名
    private String username;
    //密码
    private String password;
    //密钥
    private String token;
    //
    private boolean isValidate;
    //子菜单【根据权限查出子菜单】
    private List<Sonmenu> menus;
}
