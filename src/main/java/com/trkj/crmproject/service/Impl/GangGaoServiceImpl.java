package com.trkj.crmproject.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.*;
import com.trkj.crmproject.entity.*;
import com.trkj.crmproject.exception.CustomError;
import com.trkj.crmproject.exception.CustomErrorType;
import com.trkj.crmproject.service.GangGaoService;
import com.trkj.crmproject.util.BeanTools;
import com.trkj.crmproject.vo.StaffVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class GangGaoServiceImpl implements GangGaoService {

    @Autowired
    private GonggaoDao gonggaoDao;
    @Autowired
    private UsersDao usersDao;
    @Autowired
    private GgReadDao ggReadDao;
    @Autowired
    private DeptsonDao deptsonDao;
    @Autowired
    private TzDao tzDao;
    @Autowired
    private TzUserDao tzUserDao;
    @Autowired
    private WarnDao warnDao;

    public List<Gonggao> selectAllGg(){
        List<Gonggao> gonggaos=gonggaoDao.selectAllGg();
        log.debug("公告查询：{}",gonggaos);
        return gonggaos;
    }

    public Gonggao selectById(int id,String name){
        Gonggao gonggao=gonggaoDao.selectById(id);
        String state=usersDao.selectStateByUserName(name,id);
        log.debug("ggState:{}",state);
        //根据公告id以及用户id查询
        gonggao.setReadState(state);
        log.debug("gg:{}",gonggao);
        return gonggao;
    }

    public PageInfo<Gonggao> selectGgPage(int pageNum,int pageSize){
        Page<Gonggao> page=PageHelper.startPage(pageNum,pageSize);
        List<Gonggao> gonggaoList=gonggaoDao.selectAllGg();
        Page<Gonggao> gonggaoPage=new Page<>();
        BeanTools.copyList(gonggaoList,gonggaoPage,Gonggao.class);
        PageInfo<Gonggao> gonggaoPageInfo=new PageInfo<>(gonggaoPage);
        log.debug("公告：{}",gonggaoPageInfo);
        return gonggaoPageInfo;
    }

    //根据用户名查询角色名称
    public Role selectRoleName(String name){
        return usersDao.selectRole(name);
    }

    @Transactional
    public int addGg(Gonggao gonggao){
        int row=0;
        row=gonggaoDao.insert(gonggao);
        if(row<=0){
            throw new CustomError(CustomErrorType.ACCOUNT_ERROR,"数据更新异常");
        }
        return row;
    }

    @Transactional
    public int readGg(String userName,int id){
        int row=0;
        //根据用户姓名查询员工id
        int staff_id=usersDao.selectStaff_idByUserName(userName);
        GgRead ggRead=new GgRead();
        ggRead.setGonggao_id(id);
        ggRead.setStaff_id(staff_id);
        ggRead.setState("已阅读");
        //添加公告和读者的中间表
        row=ggReadDao.insert(ggRead);
        if(row<=0){
            throw new CustomError(CustomErrorType.ACCOUNT_ERROR,"数据更新异常");
        }
        return row;
    }

    public String selectReadNames(int id){
        //根据id查询所有浏览过的员工姓名
        List<String> namesList=ggReadDao.selectReadNames(id);
        String names="";
        for(String n:namesList){
            names=n+"、"+names;
        }
        log.debug("已阅读的人名：{}",names);
        return names;
    }

    public PageInfo<StaffVo> selectGgRead(int pageNum,int pageSize,int id){
        Page<StaffVo> page=PageHelper.startPage(pageNum,pageSize);
        List<StaffVo> staffVos=ggReadDao.selectGgRead(id);
        Page<StaffVo> staffVoPage=new Page<>();
        BeanTools.copyList(staffVos,staffVoPage,StaffVo.class);
        PageInfo<StaffVo> staffVoPageInfo=new PageInfo<>(staffVoPage);
        log.debug("已阅读的员工：{}",staffVoPageInfo);
        return staffVoPageInfo;
    }

    public PageInfo<Gonggao> selectGgByTypeAndState(int pageNum,int pageSize,String type,String state,String username){
        Page<Gonggao> page=PageHelper.startPage(pageNum,pageSize);
        int id=usersDao.selectUserId(username);
        String ids="";
        List<Gonggao> gonggaos=null;
        List<Integer> ggIds=ggReadDao.selectGgIds(id);
        for(int i=0;i<ggIds.size();i++){
            if(i==(ggIds.size()-1)){
                ids=ggIds.get(i)+ids;
            }else{
                if(ids.equals("")){
                    ids= String.valueOf(ggIds.get(i));
                }else{
                    ids=ggIds.get(i)+","+ids;
                }
            }
        }
        log.debug("拼凑出来的已阅读的公告id：{}",ids);
        if(state.equals("") || state .equals("已阅读") ){
            gonggaos=gonggaoDao.selectGgByTypeAndState(type,id);
        }else if(state.equals("待阅读")){
            //判断中间表是否存在该用户id，若存在则表示已读，若不存在，则表示未读
            gonggaos=gonggaoDao.selectReadWd(ids,type);
        }
        Page<Gonggao> gonggaoPage=new Page<>();
        BeanTools.copyList(gonggaos,gonggaoPage,Gonggao.class);
        PageInfo<Gonggao> pageInfo=new PageInfo<>(gonggaoPage);
        log.debug("条件查询的公告：{}",pageInfo);
        return pageInfo;

    }

    public List<Users> selectDqLogin(String name){
        return deptsonDao.selectDqLogin(name);
    }

    public List<Users> selectPeopleOther(String name){
        int id=deptsonDao.selectDeptSonId(name);
        return deptsonDao.selectPeopleOther(id);
    }

    //Boss查询各自部门负责人
    public List<Users> selectPeopleBoss(){
        return deptsonDao.selectPeopleBoss();
    }

    @Transactional
    public int addTz(Tz tz,List<Integer> user_ids,String name){
        //查询用户id
        int id=usersDao.selectUserId(name);
        tz.setUser_id(id);
        int row=0;
        if(tz!=null){
            row=tzDao.insert(tz);
            if(row<=0){
                throw new CustomError(CustomErrorType.ACCOUNT_ERROR,"数据更新异常");
            }
            for(int a=0;a<user_ids.size();a++){
                TzUser tzUser=new TzUser();
                tzUser.setTz_id(tz.getTz_id());
                tzUser.setUser_id(user_ids.get(a));
                row=tzUserDao.insert(tzUser);
                if(row<=0){
                    throw new CustomError(CustomErrorType.ACCOUNT_ERROR,"数据更新异常");
                }
            }
        }
        return row;
    }

    public List<Tz> selectTz(String name){
        return tzDao.selectTz(name);
    }

    public Tz selectTzById(String name,int id){
        return tzDao.selectTzById(name,id);
    }

    public List<Deptson> selectDeptSonName(){
        return deptsonDao.selectDeptSonName();
    }

    public PageInfo<StaffVo> selectReadByDeptAndName(int pageNum,int pageSize,int deptName,String userName,int id){
        Page<StaffVo> page=PageHelper.startPage(pageNum,pageSize);
        List<StaffVo> staffVos=ggReadDao.selectReadByDeptAndName(deptName,userName,id);
        Page<StaffVo> staffVoPage=new Page<>();
        BeanTools.copyList(staffVos,staffVoPage,StaffVo.class);
        PageInfo<StaffVo> staffVoPageInfo=new PageInfo<>(staffVoPage);
        log.debug("已阅读的员工：{}",staffVoPageInfo);
        return staffVoPageInfo;
    }

    public List<Warn> selectWarning(){
        return warnDao.selectByState();
    }
}
