package com.trkj.crmproject.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.BsDao;
import com.trkj.crmproject.util.BeanTools;
import com.trkj.crmproject.vo.BsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BsServiceImpl implements BsService{
    @Autowired
    private BsDao bsDao;

    // 报损列表 查询全部（仓库名称，商品名称）
    @Override
    public List<BsVo> selectbsAll() {
        return bsDao.selectbsAll();
    }

    //分页
    @Override
    public PageInfo<BsVo> findbs(int pageNum, int pageSize) {
        Page<BsVo> page= PageHelper.startPage(pageNum,pageSize);
        List<BsVo> list=bsDao.selectbsAll();
        Page<BsVo> depts=new Page<>();
        BeanTools.copyList(list,depts,BsVo.class);
        PageInfo<BsVo> pageInfo=new PageInfo<>(depts);
        System.out.println(pageInfo);
        return pageInfo;
    }


    //报损列表  根据商品名称proName模糊查询
    @Override
    public List<BsVo> selectBsproNamelike(String proName){
        return bsDao.selectBsproNamelike(proName);
    }

    //报损列表  根据报溢编号查询
    @Override
    public BsVo selectBsbsId(int bsId){
        return bsDao.selectBsbsId(bsId);
    }


    //报损列表 修改（修改备注）
    @Override
    public int updateBs(BsVo bsVo){
        return bsDao.updateBs(bsVo);
    }

    //报损列表  根据ckName查询全部
    @Override
    public List<BsVo> selectBsckName(String ckName){
        return bsDao.selectBsckName(ckName);
    }
}
