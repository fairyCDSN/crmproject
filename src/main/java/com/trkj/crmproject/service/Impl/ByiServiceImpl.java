package com.trkj.crmproject.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.ByiDao;
import com.trkj.crmproject.service.ByiService;
import com.trkj.crmproject.util.BeanTools;
import com.trkj.crmproject.vo.ByiVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ByiServiceImpl implements ByiService {

    @Autowired
    private ByiDao byiDao;

    // 报溢列表 查询全部（仓库名称，商品名称）
    @Override
    public List<ByiVo> selectbyiAll() {
        return byiDao.selectbyiAll();
    }

    //分页
    @Override
    public PageInfo<ByiVo> findbyi(int pageNum, int pageSize) {
        Page<ByiVo> page= PageHelper.startPage(pageNum,pageSize);
        List<ByiVo> list=byiDao.selectbyiAll();
        Page<ByiVo> depts=new Page<>();
        BeanTools.copyList(list,depts,ByiVo.class);
        PageInfo<ByiVo> pageInfo=new PageInfo<>(depts);
        System.out.println(pageInfo);
        return pageInfo;
    }


    //报溢列表  根据商品名称proName模糊查询
    @Override
    public List<ByiVo> selectByiproNamelike(String proName,String ckName){
        return byiDao.selectByiproNamelike(proName,ckName);
    }

    //报溢列表  根据报溢编号查询
    @Override
    public ByiVo selectByibyiId(int byiId){
        return byiDao.selectByibyiId(byiId);
    }


    //报溢列表 修改（修改备注）
    @Override
    public int updateByi(ByiVo byiVo){
        return byiDao.updateByi(byiVo);
    }

    //报溢列表  根据ckName查询全部
    @Override
    public List<ByiVo> selectByickName(String ckName){
        return byiDao.selectByickName(ckName);
    }
}
