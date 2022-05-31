package com.trkj.crmproject.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.BaoJiaDao;
import com.trkj.crmproject.dao.CustomerDao;
import com.trkj.crmproject.dao.StaffDao;
import com.trkj.crmproject.entity.BaoJia;
import com.trkj.crmproject.entity.customer;
import com.trkj.crmproject.entity.product;
import com.trkj.crmproject.exception.CustomError;
import com.trkj.crmproject.exception.CustomErrorType;
import com.trkj.crmproject.service.BaoJiaService;
import com.trkj.crmproject.service.CustomerService;
import com.trkj.crmproject.util.BeanTools;
import com.trkj.crmproject.vo.AddVo;
import com.trkj.crmproject.vo.BaoJiaVo;
import com.trkj.crmproject.vo.customerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaoJiaServiceImpl implements BaoJiaService {
    @Autowired
    private BaoJiaDao baoJiaDao;
    @Autowired
    private StaffDao staffDao;
    @Override
    public PageInfo<BaoJiaVo> findBaojia(int pageNum, int pageSize, String user_name, String customer_name, String state,
                                         String time1, String time2, int salesperson_id) {
        Page<BaoJia> page= PageHelper.startPage(pageNum,pageSize);
        List<BaoJia> list = baoJiaDao.findBaojia(user_name,customer_name,state,time1,time2,salesperson_id);
        System.out.println(list+"adjskbfhajsbfhafha");
        Page<BaoJiaVo> baoJias=new Page<>();
        BeanTools.copyList(list,baoJias,BaoJiaVo.class);
        PageInfo<BaoJiaVo> pageInfo=new PageInfo<>(baoJias);
        return pageInfo;
    }

    @Override
//    @Transactional(transactionManager = "tm")
    public int insertProduct(product[] ss, int user_id, String jfstyle, String plan_jftime) {
        int count=0;
        for(int i=0;i<ss.length;i++){
            count=baoJiaDao.insertProduct(ss[0],staffDao.findStaffId(user_id));
        }
        if(count==0){
            throw new CustomError(CustomErrorType.DATABASE_OP_ERROR,"数据更新异常");
        }
        return count;
    }

}
