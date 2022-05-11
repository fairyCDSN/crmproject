package com.trkj.crmproject.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.reimbursement;

public interface CostdetailsService {
    public PageInfo<reimbursement> selectbx(String reimbursementType, int pageNum, int pageSize);
    public PageInfo<reimbursement> findrb(int pageNum, int pageSize);
    public IPage<reimbursement> selectpage(reimbursement vo);
    public reimbursement selectmx(int cdId);
    public int updateup(int up,int cdId);
}
