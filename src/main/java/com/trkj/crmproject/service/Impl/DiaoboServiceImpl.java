package com.trkj.crmproject.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.DiaoboDao;
import com.trkj.crmproject.entity.Diaobo;
import com.trkj.crmproject.service.DiaoboService;
import com.trkj.crmproject.util.BeanTools;
import com.trkj.crmproject.vo.DiaoboVo;
import com.trkj.crmproject.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaoboServiceImpl implements DiaoboService {

    @Autowired
    private DiaoboDao diaoboDao;

    //调拨列表 查询全部（ckName[dcName,drName]
    @Override
    public List<DiaoboVo> selectDbAll(){
        return diaoboDao.selectDbAll();
    }
    //分页
    @Override
    public PageInfo<DiaoboVo> finddb(int pageNum, int pageSize) {
        Page<DiaoboVo> page= PageHelper.startPage(pageNum,pageSize);
        List<DiaoboVo> list=diaoboDao.selectDbAll();
        Page<DiaoboVo> depts=new Page<>();
        BeanTools.copyList(list,depts,DiaoboVo.class);
        PageInfo<DiaoboVo> pageInfo=new PageInfo<>(depts);
        System.out.println(pageInfo);
        return pageInfo;
    }

    //调拨详情  根据调拨id查询商品信息
    @Override
    public List<ProductVo> selectDbidproName(int dbId) {
        return diaoboDao.selectDbidproName(dbId);
    }
    //调拨详情 根据调拨id查询调拨信息
    @Override
    public DiaoboVo selectDbidxq(int dbId) {
        return diaoboDao.selectDbidxq(dbId);
    }

    //调拨管理  修改
    @Override
    public int updateDbidbz(Diaobo diaobo) {
        return diaoboDao.updateById(diaobo);
    }

}
