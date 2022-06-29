package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.vo.JiaoFuVo;
import com.trkj.crmproject.vo.PcPlanVo;

public interface JiaoFuService {
    public PageInfo<JiaoFuVo> findJiaoFu(int pageNum, int pageSize,String qs,String state,String user_name);
}
