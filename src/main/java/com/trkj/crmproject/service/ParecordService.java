package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.Parecord;
import com.trkj.crmproject.vo.ParecordVo;

import java.util.List;

public interface ParecordService {
    public int addfkjh(Parecord parecord);
    public int upfk(Parecord parecord,int sqid);
    public PageInfo<ParecordVo> findfkjh(int pageNum,int pageSize);
    public PageInfo<ParecordVo> selectfkjh(int pageNum,int pageSize,String cgDh,Integer total);
    public ParecordVo selectpayment(int paId);
    public List<ParecordVo> selectfkjhmx(int sqid);
    public ParecordVo selectonefkjh(int sqid);
    public int upstate(int paId);
    public int uppare(int paId,int paMn);
    public int addpare(Parecord parecord);
    public int uppateqc(Parecord parecord);
}
