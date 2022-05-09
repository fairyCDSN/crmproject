package com.trkj.crmproject.service;

import com.trkj.crmproject.dao.CkDao;
import com.trkj.crmproject.entity.Ck;
import com.trkj.crmproject.exception.CustomError;
import com.trkj.crmproject.exception.CustomErrorType;
import com.trkj.crmproject.util.BeanTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CkServicelmpl implements CkService{

    @Autowired
    private CkDao dao;

    //仓库管理  全部查询
    @Override
    public List<Ck> selectCkall() {
        return dao.selectList(null);
    }

    //仓库管理  添加
    @Override
    public Ck addCk(Ck ck) {
        int row=dao.insert(ck);
        if (row==0){
            throw new CustomError(CustomErrorType.DATABASE_OP_ERROR,"数据插入失败");
        }
        return ck;
    }

    //仓库管理  根据id删除
    @Override
    public int deleteCk(int ckId) {
        System.out.println("==================ckId:"+ckId);
        return dao.deleteById(ckId);
    }

    //仓库管理  修改
    @Override
    public Ck updateCk(Ck ck) {
        Ck cks=new Ck();
        BeanTools.copyProperties(ck,cks);
        int row=dao.updateById(cks);
        System.out.println("修改:"+row);
        if (row==0){
            throw new CustomError(CustomErrorType.DATABASE_OP_ERROR,"数据修改失败");
        }
        return ck;
    }

    //根据id查询
    @Override
    public Ck setectCkid(int ckId) {
        return dao.selectById(ckId);
    }

//    //仓库管理  分页
//    @Override
//    public PageInfo<Ck> findck(int pageNum, int pageSize) {
//        Page<Ck> page= PageHelper.startPage(pageNum,pageSize);
//        List<Ck> list=dao.selectList(null);
//        Page<Ck> depts=new Page<>();
//        BeanTools.copyList(list,depts,Ck.class);
//        PageInfo<Ck> pageInfo=new PageInfo<>(depts);
//        System.out.println(pageInfo);
//        return pageInfo;
//    }

}
