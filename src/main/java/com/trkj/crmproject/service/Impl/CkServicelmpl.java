package com.trkj.crmproject.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.CkDao;
import com.trkj.crmproject.dao.DeptsonDao;
import com.trkj.crmproject.entity.Deptson;
import com.trkj.crmproject.entity.mybatis_plus.Ck;
import com.trkj.crmproject.exception.CustomError;
import com.trkj.crmproject.exception.CustomErrorType;
import com.trkj.crmproject.service.CkService;
import com.trkj.crmproject.util.BeanTools;
import com.trkj.crmproject.vo.CkStaffVo;
import com.trkj.crmproject.vo.CkVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CkServicelmpl implements CkService {

    @Autowired
    private CkDao dao;
    @Autowired
    private DeptsonDao deptsonDao;

    //仓库管理  全部查询
    @Override
    public List<Ck> selectCkall() {
        return dao.selectList(null);
    }

    //仓库管理  添加
    @Override
    @Transactional
    public Ck addCk(Ck ck) {
        Deptson deptson=new Deptson();
        deptson.setUser_id(ck.getGlyId());
        deptson.setDept_name(ck.getCkName());
        deptson.setDept_id(3);
        deptson.setState(1);
        int row=dao.insert(ck);
        if (row==0){
            throw new CustomError(CustomErrorType.DATABASE_OP_ERROR,"数据插入失败");
        }

        row=deptsonDao.insert(deptson);
        if (row==0){
            throw new CustomError(CustomErrorType.DATABASE_OP_ERROR,"数据插入失败");
        }
        return ck;
    }

    //仓库管理  根据id删除
    @Override
    @Transactional
    public int deleteCk(int ckId) {
        System.out.println("==================ckId:"+ckId);
        return dao.deleteById(ckId);
    }

    //仓库管理  修改
    @Override
    @Transactional
    public int updateCk(Ck ck) {
//        int row=deptsonDao.updateDeptSon();
        return dao.updateById(ck);
    }

    //仓库管理  根据id查询
    @Override
    public Ck setectCkid(int ckId) {
        return dao.selectById(ckId);
    }

    //仓库列表  查询全部（根据glyId,userId外键查询userName）
    @Override
    public List<CkVo> selectCkuserName() {
        return dao.selectCkuserName();
    }

    //仓库列表  查询全部（根据CkName模糊查询）
    @Override
    public List<CkVo> selectCkuserNamelike(String ckName) {
        return dao.selectCkuserNamelike(ckName);
    }

    //查询管理员（users表）
//    @Override
//    public List<CkUserVo> selectUserName() {
//        return dao.selectUserName();
 //   }
    //仓库管理  分页
    @Override
    public PageInfo<CkVo> findck(int pageNum, int pageSize) {
        Page<CkVo> page= PageHelper.startPage(pageNum,pageSize);
        List<CkVo> list=dao.selectCkuserName();
        Page<CkVo> depts=new Page<>();
        BeanTools.copyList(list,depts,CkVo.class);
        PageInfo<CkVo> pageInfo=new PageInfo<>(depts);
        System.out.println(pageInfo);
        return pageInfo;
    }
    // //查询管理员username（glyId外键到staff表，userId到users表 ）
    public List<CkStaffVo> selectGlyid(){
        return dao.selectGlyid();
    }



    //仓库列表  删除（根据ckId把ckState改为0）
    @Transactional
    public int updateCkState(int ckId){
        return dao.updateCkState(ckId);
    }
    //仓库列表  启用（根据ckId把ckState改为1）
    @Transactional
    public int updateCkState1(int ckId){
        return dao.updateCkState1(ckId);
    }

    // 仓库列表 查询仓库的商品总数量为0的
    public String selectCknumber(int ckId){
        return dao.selectCknumber(ckId);
    }

    //仓库管理 查询当前登录人的职位（角色名）（判断是否能修改仓库信息）
    public String selectCkroleName(String userName){
        return dao.selectCkroleName(userName);
    }
}
