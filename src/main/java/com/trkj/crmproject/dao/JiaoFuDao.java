package com.trkj.crmproject.dao;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.JiaoFu;
import com.trkj.crmproject.vo.JiaoFuVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface JiaoFuDao {
    public JiaoFu findJiaoFu(@Param("order_id")  int order_id,@Param("qs") String qs,@Param("state") String state);
    public int[] findorderId();
    public String findmint(int order_id);
    public String findmaxt(int order_id);
}
