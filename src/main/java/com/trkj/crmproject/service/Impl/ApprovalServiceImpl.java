package com.trkj.crmproject.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.*;
import com.trkj.crmproject.entity.*;
import com.trkj.crmproject.exception.CustomError;
import com.trkj.crmproject.exception.CustomErrorType;
import com.trkj.crmproject.service.ApprovalService;
import com.trkj.crmproject.util.BeanTools;
import com.trkj.crmproject.vo.ApprecordsVo;
import com.trkj.crmproject.vo.ApprovalRoleVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
@Slf4j
public class ApprovalServiceImpl implements ApprovalService {

    @Autowired
    private ApprovalDao dao;
    @Autowired
    private ApprecordsSonDao apprecordsSonDao;
    @Autowired
    private ApprecordsDao apprecordsDao;
    @Autowired
    private AppRoleDao appRoleDao;
    @Autowired
    private RoleDao roleDao;


    @Override
    public Approval selectapptype() {
        QueryWrapper<Approval> qw=new QueryWrapper<>();
        String type="采购审批";
        qw.eq("app_type",type);
        Approval approval=dao.selectOne(qw);
        System.out.println("我在impl层"+approval);
        return approval;
    }


    //wq
    //查询所有审批类别和人数
    public PageInfo<Approval> selectAllApp(int pageNum, int pageSize){
        Page<Approval> page= PageHelper.startPage(pageNum,pageSize);
        //去重
        List<Approval> approvals = new ArrayList<>(new HashSet<>(dao.selectAllApp()));
        log.debug(approvals+"这是去重的approvals");
        Page<Approval> approvalPage=new Page<>();
        BeanTools.copyList(approvals,approvalPage,Approval.class);
        PageInfo<Approval> approvalPageInfo=new PageInfo<>(approvalPage);
        log.debug("approval:{}",approvalPageInfo);
        return approvalPageInfo;
    }

    //根据审批id查询拥有审批权限的人
    public List<ApprovalRoleVo> selectRoleByApp(int id){
        List<ApprovalRoleVo> approvalRoleVos=dao.selectRoleByApp(id);
        return approvalRoleVos;
    }

    //修改审批状态[根据审批人id修改审批状态、输入失败理由]
    public int updateApprecords(int id,ApprecordsVo apprecordsVo){
        int row=0;
        String state=null;
        String bz=null;
        //判断这是不是最后一个审批的子记录
        List<ApprecordsSon> apprecordsSons=apprecordsSonDao.selectByAppId(apprecordsVo.getApp_records_id());
        if(apprecordsSons.size()!=0){
            if(apprecordsVo.getApp_son_state()=="审批未通过"){
                //如果该审批人审批时不是最后一个【还存在未审批的子记录】，那么将未审批的子记录表状态改为”申请已被驳回“，备注改为当前失败的备注
                log.debug("查询到的其他未审批的子记录：{}",apprecordsVo);
                for (ApprecordsSon a:apprecordsSons){
                    //调用修改状态的方法
                    row=apprecordsSonDao.updateApprecords(a.getUser_id(),a.getApp_state(),apprecordsVo.getApp_son_bz());
                    if(row<=0){
                        log.debug("第一次：修改子记录表出问题啦！");
                        throw new CustomError(CustomErrorType.USER_INPUT_ERROR);
                    }
                }
                //修改审批记录表
                row=apprecordsDao.updateStateAndBzById(apprecordsVo.getApp_records_id(),apprecordsVo.getApp_son_state(),apprecordsVo.getApp_son_bz());
                if(row<=0){
                    log.debug("第一次：修改审批记录表出问题啦！");
                    throw new CustomError(CustomErrorType.USER_INPUT_ERROR);
                }
            }
        }else if(apprecordsSons.size()==0){
            //这是最后一条审批的子记录表了【直接修改记录表的状态】
            state=apprecordsVo.getApp_son_state();
            bz=apprecordsVo.getApp_son_bz();
            //修改子记录表
            row=apprecordsSonDao.updateApprecords(id,state,bz);
            if(row<=0){
                log.debug("第二次：修改子记录表出问题啦！");
                throw new CustomError(CustomErrorType.USER_INPUT_ERROR);
            }
            //修改审批记录表【证明审批全部通过了，状态改为”审批通过“】
            row=apprecordsDao.updateStateAndBzById(apprecordsVo.getApp_records_id(),apprecordsVo.getApp_son_state(),apprecordsVo.getApp_son_bz());
            if(row<=0){
                log.debug("第二次：修改审批记录表出问题啦！");
                throw new CustomError(CustomErrorType.USER_INPUT_ERROR);
            }
        }
        return row;
    }

    //查询审批记录[根据登录人的id和审批状态查询]
    public PageInfo<Apprecords> selectApprecordsByUserIdAndState(int pageNum,int pageSize,int id,String state){
        Page<Apprecords> page=PageHelper.startPage(pageNum,pageSize);
        List<Apprecords> apprecords=apprecordsDao.selectApprecordsByUserIdAndState(id,state);
        Page<Apprecords> apprecordsPage=new Page<>();
        BeanTools.copyList(apprecords,apprecordsPage,Apprecords.class);
        PageInfo<Apprecords> apprecordsPageInfo=new PageInfo<>(apprecordsPage);
        log.debug("apprecords:{}",apprecordsPageInfo);
        return apprecordsPageInfo;
    }

    //按条件查询
    public PageInfo<Approval> selectByStateAndName(int state,String name,int pageNum,int pageSize){
        Page<Approval> page= PageHelper.startPage(pageNum,pageSize);
        //去重
        List<Approval> approvals=dao.selectByStateAndName(state,name);
        Page<Approval> approvalPage=new Page<>();
        BeanTools.copyList(approvals,approvalPage,Approval.class);
        PageInfo<Approval> approvalPageInfo=new PageInfo<>(approvalPage);
        log.debug("approval:{}",approvalPageInfo);
        return approvalPageInfo;
    }

    //添加审批类别
    @Transactional
    public int insertApproval(List<Integer> ids,Approval approval){
        int row=0;
        //调用添加的方法
        Approval a=new Approval();
        a.setAppType(approval.getAppType());
        a.setAppState(approval.getAppState());
        row=dao.insertApproval(a);
        if(row<=0){
            throw new CustomError(CustomErrorType.USER_INPUT_ERROR);
        }
        log.debug("这是自动生成的审批类别id："+a.getAppId());
        //添加类别表和角色表的中间表
        for(int i=0;i<ids.size();i++){
            AppRole appRole=new AppRole();
            appRole.setApp_id(a.getAppId());
            appRole.setRole_id(ids.get(i));
            row=appRoleDao.insert(appRole);
            if(row<=0){
                throw new CustomError(CustomErrorType.USER_INPUT_ERROR);
            }
        }
        return row;
    }

    public List<Role> selectUpdateText(int id){
        List<Role> roles=dao.selectRoleByAppId(id);
        return roles;
    }

    public List<Role> selectAppRole(){
        return roleDao.selectAll();
    }

    public int delectAppRole(int id,int app_id){
        return appRoleDao.delectAppRole(id,app_id);
    }

    //修改审批模板的中间表
    public int updateAppRole(int id,List<Integer> roleIds){
        int row=0;
        //根据id删除中间表
        row=appRoleDao.delectById(id);
        if(row<=0){
            throw new CustomError(CustomErrorType.USER_INPUT_ERROR);
        }
        //根据id新增中间表
        for(int i=0;i<roleIds.size();i++){
            AppRole appRole=new AppRole();
            appRole.setRole_id(roleIds.get(i));
            appRole.setApp_id(id);
            row=appRoleDao.insert(appRole);
            if(row<=0){
                throw new CustomError(CustomErrorType.USER_INPUT_ERROR);
            }
        }
        return row;
    }

    public List<String> selectName(){
        List<String> name=dao.selectName();
        log.debug("审批类别的名称：",name);
        return name;
    }


}
