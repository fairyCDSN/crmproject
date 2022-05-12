package com.trkj.crmproject.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.PdDao;
import com.trkj.crmproject.entity.Pd;
import com.trkj.crmproject.util.BeanTools;
import com.trkj.crmproject.vo.PdVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PdServiceImpl implements PdService{

    @Autowired
    private PdDao pdDao;

    //盘点单  全部查询
    @Override
    public List<Pd> selectAllpd() {
        return pdDao.selectList(null);
    }

    @Override
    public PageInfo<PdVo> findpd(int pageNum, int pageSize) {
        Page<PdVo> page= PageHelper.startPage(pageNum,pageSize);
        List<PdVo> list=pdDao.selectPdproName();
        Page<PdVo> pds=new Page<>();
        BeanTools.copyList(list,pds, PdVo.class);
        PageInfo<PdVo> pageInfo=new PageInfo<>(pds);
        System.out.println(pageInfo);
        return pageInfo;
    }

    //盘点单  查询全部（根据proId外键查询proName
    public List<PdVo> selectPdproName(){
        return pdDao.selectPdproName();
    }
}
