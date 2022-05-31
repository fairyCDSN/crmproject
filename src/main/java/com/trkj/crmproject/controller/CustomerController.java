package com.trkj.crmproject.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.service.AddressService;
import com.trkj.crmproject.service.ContactService;
import com.trkj.crmproject.service.CustomerService;
import com.trkj.crmproject.vo.AddVo;
import com.trkj.crmproject.vo.AjaxResponse;
import com.trkj.crmproject.vo.customerVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@Slf4j
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private ContactService contactService;

    //查询属于编号为salesperson_id的员工的所有状态不为过期客户的客户信息
    @GetMapping("/findCustomers")
    public AjaxResponse findCustomers(int pageNum, int pageSize,int salesperson_id){
        PageInfo<customerVo> info=customerService.findCustomers(pageNum,pageSize,salesperson_id);
        return AjaxResponse.success(info);
    }
    //查询所有共享客户的状态不为过期客户的客户信息
    @GetMapping("/findCustomers2")
    public AjaxResponse findCustomers2(int pageNum, int pageSize){
        PageInfo<customerVo> info=customerService.findCustomers2(pageNum,pageSize);
        return AjaxResponse.success(info);
    }
    //根据客户名称、客户阶段、日期范围搜索编号为salesperson_id的员工的所有状态不为过期客户的客户信息
    @GetMapping("/findCustomer")
    public AjaxResponse findCustomer(int pageNum, int pageSize,String customer_name, String customer_stage,String create_time1,
                                     String create_time2,int salesperson_id){
        PageInfo<customerVo> info=customerService.findCustomer(pageNum,pageSize,customer_name,customer_stage,
                create_time1,create_time2,salesperson_id);
        return AjaxResponse.success(info);
    }
    //根据客户名称、客户阶段、日期范围搜索所有状态不为过期客户的共享客户的客户信息
    @GetMapping("/findCustomer1")
    public AjaxResponse findCustomer1(int pageNum, int pageSize,String customer_name, String customer_stage,String create_time1,
                                      String create_time2){
        PageInfo<customerVo> info=customerService.findCustomer1(pageNum,pageSize,customer_name,customer_stage,
                create_time1,create_time2);
        return AjaxResponse.success(info);
    }
    @GetMapping("/findCustomer2")
    public AjaxResponse findCustomer2(int pageNum, int pageSize,String customer_name, String customer_stage,String create_time1,
                                      String create_time2,int salesperson_id){
        PageInfo<customerVo> info=customerService.findCustomer2(pageNum,pageSize,customer_name,customer_stage,
                create_time1,create_time2,salesperson_id);
        return AjaxResponse.success(info);
    }
    @GetMapping("/findCusXq")
    public AjaxResponse findCusXq(int customer_id){
        return AjaxResponse.success(customerService.findCusXq(customer_id));
    }

    @PostMapping("/addCustomer")
    public AjaxResponse addCustomer(@RequestBody AddVo addVo){
        System.out.println(addVo+"asdasdasfdjkvbasdjkbnglaskjdbfakl");
        addressService.insertAddress(addVo);
        int address_id=addressService.findAddById(addVo);
        addVo.setAddress_id(address_id);
        customerService.addCustomer(addVo);
        int customer_id=customerService.findCustomerById(addVo);
        addVo.setCustomer_id(customer_id);
        contactService.addContact(addVo);
        int contact_id=contactService.findContactById(addVo);
        addVo.setContact_id(contact_id);
        customerService.addConCus(addVo);
        return AjaxResponse.success();
    }
    @PutMapping("/customer")
    public AjaxResponse updateCustomer(@RequestBody customerVo customerVo){
        return AjaxResponse.success(customerService.updateCustomer(customerVo));
    }

    @PutMapping("/customers")
    public AjaxResponse delCustomer(@RequestBody int customer_id){
        return AjaxResponse.success(customerService.updataCustomerType1(customer_id));
    }

    @PutMapping("/customers2")
    public AjaxResponse delCustomers(@RequestBody int customer_id){
        return AjaxResponse.success(customerService.updataCustomerType2(customer_id));
    }

    @PutMapping("/updateSeId")
    public AjaxResponse updateSeId(@RequestBody AddVo[] ss,int user_id){
        System.out.println(user_id+"asfokjsadfiasjidfhnakjsdf");
        customerService.updateSeId(ss,user_id);
        return AjaxResponse.success();
    }
}
