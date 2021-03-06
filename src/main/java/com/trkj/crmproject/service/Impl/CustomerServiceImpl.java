package com.trkj.crmproject.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.CustomerDao;
import com.trkj.crmproject.dao.StaffDao;
import com.trkj.crmproject.entity.customer;
import com.trkj.crmproject.exception.CustomError;
import com.trkj.crmproject.exception.CustomErrorType;
import com.trkj.crmproject.service.CustomerService;
import com.trkj.crmproject.util.BeanTools;
import com.trkj.crmproject.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private StaffDao staffDao;

    @Override
    public PageInfo<customerVo> findCustomer(int pageNum, int pageSize,String customer_name, String customer_stage,
                                             String create_time1,String create_time2,int salesperson_id) {
        Page<customer> page= PageHelper.startPage(pageNum,pageSize);
        int salesperson_i=staffDao.findStaffId(salesperson_id);
        List<customer> list = customerDao.findCustomer(customer_name,customer_stage,create_time1,create_time2,salesperson_id);
        Page<customerVo> customers=new Page<>();
        BeanTools.copyList(list,customers,customerVo.class);
        PageInfo<customerVo> pageInfo=new PageInfo<>(customers);
        System.out.println(pageInfo+"ajsifdhiuasfguiasfg");
        return pageInfo;
    }

    @Override
    public PageInfo<customerVo> findCustomer1(int pageNum, int pageSize,String customer_name, String customer_stage,
                                             String create_time1,String create_time2) {
        Page<customer> page= PageHelper.startPage(pageNum,pageSize);
        List<customer> list = customerDao.findCustomer1(customer_name,customer_stage,create_time1,create_time2);
        Page<customerVo> customers=new Page<>();
        BeanTools.copyList(list,customers,customerVo.class);
        PageInfo<customerVo> pageInfo=new PageInfo<>(customers);
        return pageInfo;
    }

    @Override
    public PageInfo<customerVo> findCustomer2(int pageNum, int pageSize,String customer_name, String customer_stage,
                                             String create_time1,String create_time2,int salesperson_id) {
        Page<customer> page= PageHelper.startPage(pageNum,pageSize);
        List<customer> list = customerDao.findCustomer2(customer_name,customer_stage,create_time1,create_time2,staffDao.findStaffId(salesperson_id));
        Page<customerVo> customers=new Page<>();
        BeanTools.copyList(list,customers,customerVo.class);
        PageInfo<customerVo> pageInfo=new PageInfo<>(customers);
        return pageInfo;
    }

    @Override
    public PageInfo<customerVo> findCustomers(int pageNum, int pageSize,int salesperson_id) {
        Page<customer> page= PageHelper.startPage(pageNum,pageSize);
        List<customer> list=customerDao.findCustomers(staffDao.findStaffId(salesperson_id));
        Page<customerVo> customers=new Page<>();
        BeanTools.copyList(list,customers,customerVo.class);
        PageInfo<customerVo> pageInfo=new PageInfo<>(customers);
        return pageInfo;
    }

    @Override
    public PageInfo<customerVo> findCustomers2(int pageNum, int pageSize) {
        Page<customer> page= PageHelper.startPage(pageNum,pageSize);
        List<customer> list=customerDao.findCustomers2();
        Page<customerVo> customers=new Page<>();
        BeanTools.copyList(list,customers,customerVo.class);
        PageInfo<customerVo> pageInfo=new PageInfo<>(customers);
        return pageInfo;
    }

    @Override
    public CusXqVo findCusXq(int customer_id) {
        CusXqVo cusXqVo = customerDao.findCusXq(customer_id);
        return cusXqVo;
    }


    @Override
    public int findCustomerById(AddVo addVo) {
        int customer_id = customerDao.findCustomerById(addVo);
        return customer_id;
    }

    @Override
//    @Transactional(transactionManager = "tm")
    @Transactional
    public AddVo addCustomer(AddVo addVo) {
        int count=customerDao.addCustomer(addVo);
        if(count==0){
            throw new CustomError(CustomErrorType.DATABASE_OP_ERROR,"??????????????????");
        }
        return addVo;
    }

    @Override
//    @Transactional(transactionManager = "tm")
    @Transactional
    public AddVo addConCus(AddVo addVo) {
        int count=customerDao.addConCus(addVo);
        if(count==0){
            throw new CustomError(CustomErrorType.DATABASE_OP_ERROR,"??????????????????");
        }
        return addVo;
    }

    @Override
    @Transactional
    public int addfollow(String user_name,String contact_name,String customer_source,String customer_name) {
            String follow_content="?????????"+customer_name+"????????????"+user_name+"????????????,??????????????????"+contact_name;
        return customerDao.addfollow(user_name,contact_name,"???????????????",customer_source,follow_content);
    }

    @Override
    @Transactional
    public customerVo updateCustomer(customerVo customerVo) {
        customer customer=new customer();
        BeanTools.copyProperties(customerVo,customer);
        int count=customerDao.updateCustomer(customer);
        // int i=9/0;
        if(count==0){
            throw new CustomError(CustomErrorType.DATABASE_OP_ERROR,"??????????????????");
        }
        return customerVo;
    }
    @Override
//    @Transactional(transactionManager = "tm")
    @Transactional
    public int updataCustomerType1(int customer_id) {
        int count =0;
        if(customerDao.checkdeCus1(customer_id).length==0){
            if(customerDao.checkdeCus2(customer_id).length==0){
                count=customerDao.updataCustomerType1(customer_id);
            }
        }
        return count;
    }
    @Override
    @Transactional
    public int updataCustomerType2(int customer_id) {
        return customerDao.updataCustomerType2(customer_id);
    }

    @Override
    @Transactional
    public int updateSeId(AddVo[] addVo,int user_id,String user_name) {
        for(int i=0;i<addVo.length;i++) {
            int customer_id = addVo[i].getCustomer_id();
            String follow_content="??????"+user_name+"?????????"+addVo[i].getCustomer_name()+"?????????????????????";
            if(user_id!=0){
                customerDao.updateSeId(customer_id, staffDao.findStaffId(user_id));
                customerDao.insertfollow(customer_id,user_name, addVo[i].getContact_name(),
                        "????????????","????????????",follow_content);
            }else if(user_id==0){
                customerDao.updateSeId(customer_id,0);
                customerDao.insertfollow(customer_id,user_name,addVo[i].getContact_name(),"???????????????????????????",
                        "????????????","??????"+user_name+"?????????"+addVo[i].getCustomer_name()+"?????????????????????");
            }
        }
        return 1;
    }
    @Override
    @Transactional
    public int updateLinQu(int customer_id,int user_id,String user_name) {
        customerDao.updateSeId(customer_id, staffDao.findStaffId(user_id));
        String follow_content="??????"+user_name+"????????????";
        customerDao.insertfollow(customer_id,user_name,"", "????????????","????????????",follow_content);
        return 1;
    }
}
