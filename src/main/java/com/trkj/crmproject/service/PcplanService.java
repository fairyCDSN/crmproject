package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.PcPlan;
import com.trkj.crmproject.vo.PcPlanVo;

public interface PcPlanService {
    public PageInfo<PcPlanVo> findPcplan(int pageNum, int pageSize, String qs, String state,
                                         String monery1, String monery2,String user_name);
}
