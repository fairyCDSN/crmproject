package com.trkj.crmproject.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class CollectionVo {
    private int pcId;
    private int orderId;
    private int orderBh;
    private int maxpcda;
    private int sumpcmn;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date minpcpcda;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date maxpcpcda;
    private String minpcstate;
    private String maxpcstate;
    private String orderstate;
    @TableField(exist = false)
    private String state;
}
