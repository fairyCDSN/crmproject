package com.trkj.crmproject.entity.mybatis_plus;

import com.baomidou.mybatisplus.annotation.TableName;
import com.trkj.crmproject.entity.Sonmenu;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@TableName("sonmenu")
public class SonmenuMp {

    private Integer sonId;

    private Integer fatherId;

    private Integer isLeaf;

    private String menuName;

    private String submitMethod;

    private String url;

    private String subName;

    private String subUrl;

    private String icon;

    private String iconColor;

    private Integer sort;

    //菜单层级
    private Integer menuLv;

    private Integer isQy;

    private static final long serialVersionUID = 1L;
}
