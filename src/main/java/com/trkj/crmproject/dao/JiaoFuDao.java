package com.trkj.crmproject.dao;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.JiaoFu;
import com.trkj.crmproject.vo.JiaoFuVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JiaoFuDao {
    public JiaoFu findJiaoFu(int order_id);
    public int[] findorderId();
    public String findmint(int order_id);
    public String findmaxt(int order_id);
}
