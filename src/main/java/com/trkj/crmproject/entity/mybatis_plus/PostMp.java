package com.trkj.crmproject.entity.mybatis_plus;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "post")
public class PostMp {
    private int postId;
    /**
     * 职务名称
     */
    private String postName;

    /**
     * 职务描述
     */
    private String postDescribe;
}
