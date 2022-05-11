package com.trkj.crmproject.entity.mybatis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * sonmenu
 * @author
 */
@Data
public class Sonmenu implements Serializable {
    /**
     * 子类菜单id
     */
    private Integer son_id;

    /**
     * 父类菜单id
     */
    private Integer father_id;

    /**
     * 是否是叶子节点
     */
    private Integer is_leaf;

    /**
     * 菜单名称
     */
    private String menu_name;

    /**
     * 允许提交方法
     */
    private String submit_method;

    /**
     * 跳转url
     */
    private String url;

    /**
     * 组件名称
     */
    private String sub_name;

    /**
     * 组件地址
     */
    private String sub_url;

    /**
     * 图标
     */
    private String icon;

    /**
     * 图标颜色
     */
    private String icon_color;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 菜单层级
     */
    private Integer menu_lv;

    /**
     * 是否启用
     */
    private Integer is_qy;

    private static final long serialVersionUID = 1L;

    /** 侧边栏子菜单 */
    private List<Sonmenu> asideChildren = new ArrayList<Sonmenu>();
}
