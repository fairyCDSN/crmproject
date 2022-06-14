package com.trkj.crmproject.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * role
 * @author
 */
@Data
public class Role implements Serializable {
    /**
     * 角色id
     */
    @TableId(value = "role_id",type = IdType.AUTO)
    private Integer role_id;

    /**
     * 角色名称
     */
    private String role_name;

    /**
     * 角色描述
     */
    private String role_desc;

    /**
     * 角色顺序
     */
    private Integer role_sort;

    /**
     * 是否可用
     */
    private Integer is_use;

    /**
     * 创建时间
     */
    private Date create_time;

    //权限菜单
    private List<Sonmenu> sonmenuList;

    //菜单id
    private List<Integer> role_menus;

    private static final long serialVersionUID = 1L;
}
