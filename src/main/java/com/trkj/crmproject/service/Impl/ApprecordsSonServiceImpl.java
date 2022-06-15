package com.trkj.crmproject.service.Impl;

import com.trkj.crmproject.dao.ApprecordsDao;
import com.trkj.crmproject.dao.ApprecordsSonDao;
import com.trkj.crmproject.dao.CaigousqDao;
import com.trkj.crmproject.dao.UsersDao;
import com.trkj.crmproject.entity.ApprecordsSon;
import com.trkj.crmproject.entity.Caigou;
import com.trkj.crmproject.entity.Caigousq;
import com.trkj.crmproject.exception.CustomError;
import com.trkj.crmproject.exception.CustomErrorType;
import com.trkj.crmproject.service.ApprecordsSonService;
import com.trkj.crmproject.vo.ApprecordsVo;
import com.trkj.crmproject.vo.CaigousqVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ApprecordsSonServiceImpl implements ApprecordsSonService {

    @Autowired
    private ApprecordsSonDao apprecordsSonDao;
    @Autowired
    private ApprecordsDao apprecordsDao;
    @Autowired
    private UsersDao usersDao;
    @Autowired
    private CaigousqDao caigousqDao;

    @Override
    public int addspzb(int app_records_id, int userId) {
        ApprecordsSon a=new ApprecordsSon();
        a.setApp_records_id(app_records_id);
        a.setUser_id(userId);
        a.setApp_state("待审批");
        return apprecordsSonDao.insert(a);
    }
    public List<ApprecordsSon> selectApprecordsByName(String username, String state){
        //根据用户名查出用户id
        int id=usersDao.selectUserId(username);
        log.debug("这是审核子记录表当中使用的用户id：{}",id);
        //根据用户id和状态查询审核子记录表
        List<ApprecordsSon> apprecordsVos=apprecordsSonDao.selectApprecordsByName(id,state);
        log.debug("查询出来的审核记录子表：{}",apprecordsVos);
        return apprecordsVos;
    }

    public List<Caigousq> selectAppCgsq(int id){
        List<Caigousq> caigousqs=caigousqDao.selectAppCaigousq(id);
        return caigousqs;
    }

    public List<CaigousqVo> selectAppCgGoods(int id){
        List<CaigousqVo> caigousqVos=caigousqDao.selectcgmx(id);
        return caigousqVos;
    }

    public int updateAppSon(int id,int son_id,String state,String bz){
        int row=0;
        //第一步：根据子记录id查询子记录
        List<ApprecordsSon> apprecordsSons=apprecordsSonDao.selectByAppId(son_id);

        if(apprecordsSons.size()!=0){
            //存在未审批的子记录
            //第二步：判断状态是审批失败还是成功
            if(state.equals("审批未通过")){
                //审批未通过
                //第三步：修改该条子记录
                row=apprecordsSonDao.updateApprecords(son_id,state,bz);
                if(row<=0){
                    log.debug("审批未通过中修改子表记录失败1");
                    throw new CustomError(CustomErrorType.USER_INPUT_ERROR);
                }
                //第四步：修改审批记录表【将记录表中的状态改为未通过，添加失败原因】
                row=apprecordsDao.updateStateAndBzById(id,state,bz);
                if(row<=0){
                    log.debug("审批未通过中修改审批记录表失败2");
                    throw new CustomError(CustomErrorType.USER_INPUT_ERROR);
                }
                //第五步：修改其余未审批的子表记录【将状态改为已被驳回】
                for(int i=0;i<apprecordsSons.size();i++){
                    if(apprecordsSons.get(i).getApprecords_son_id()!=son_id){
                        row=apprecordsSonDao.updateApprecords(apprecordsSons.get(i).getApprecords_son_id(),"已被驳回",bz);
                        if(row<=0){
                            log.debug("第"+i+"次"+"修改其余未审批的子记录失败3");
                            throw new CustomError(CustomErrorType.USER_INPUT_ERROR);
                        }
                    }
                }
                //修改成功！
                log.debug("修改成功！");
            }else if(state.equals("审批通过")){
                //状态为通过
                //第三步：只修改该条子记录【不动审批记录表】
                row=apprecordsSonDao.updateApprecords(son_id,state,bz);
                if(row<=0){
                    log.debug("审批未通过中修改子表记录失败4");
                    throw new CustomError(CustomErrorType.USER_INPUT_ERROR);
                }
            }
        }else{
            //该审批为最后一条，直接修改总记录
            row=apprecordsSonDao.updateApprecords(son_id,state,bz);
            if(row<=0){
                log.debug("审批未通过中修改子表记录失败5");
                throw new CustomError(CustomErrorType.USER_INPUT_ERROR);
            }
            //第四步：修改审批记录表【将记录表中的状态改为未通过，添加失败原因】
            row=apprecordsDao.updateStateAndBzById(id,state,bz);
            if(row<=0){
                log.debug("审批通过中修改审批记录表失败6");
                throw new CustomError(CustomErrorType.USER_INPUT_ERROR);
            }
        }
        return row;
    }
}
