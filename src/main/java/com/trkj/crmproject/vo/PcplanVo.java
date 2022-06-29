package com.trkj.crmproject.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class PcplanVo {
    private int pcId;
    private int orderId;
    private int orderBh;
    private int minpcda;
    private int pcmn;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date pcpcda;
    @TableField(exist = false)
    private int pcMnnn;
    @TableField(exist = false)
    private Date pcPcda;
    @TableField(exist = false)
    private String pcPcstate;
    @TableField(exist = false)
    private int pcIddd;
    @TableField(exist = false)
    private String bh;
    @TableField(exist = false)
    private Date paMntime;
}
