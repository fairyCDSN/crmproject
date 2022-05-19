package com.trkj.crmproject.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.PdDao;
import com.trkj.crmproject.service.PdService;
import com.trkj.crmproject.util.BeanTools;
import com.trkj.crmproject.vo.PdVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PdServiceImpl implements PdService {

    @Autowired
    private PdDao pdDao;

    //盘盘点单  查询全部（根据ckId中间表外键查询ckName
    public List<PdVo> selectPdckNameAll(){
        return pdDao.selectPdckNameAll();
    }
    //分页
    @Override
    public PageInfo<PdVo> findpd(int pageNum, int pageSize) {
        Page<PdVo> page= PageHelper.startPage(pageNum,pageSize);
        List<PdVo> list=pdDao.selectPdckNameAll();
        Page<PdVo> pds=new Page<>();
        BeanTools.copyList(list,pds, PdVo.class);
        PageInfo<PdVo> pageInfo=new PageInfo<>(pds);
        System.out.println(pageInfo);
        return pageInfo;
    }

    //盘点单  查询全部（根据仓库名称查询）
    public List<PdVo> selectPdckName(String ckName){
        return pdDao.selectPdckName(ckName);
    }
}
