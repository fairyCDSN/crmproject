package com.trkj.crmproject.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.service.AddressService;
import com.trkj.crmproject.service.CustomerService;
import com.trkj.crmproject.vo.AddVo;
import com.trkj.crmproject.vo.AjaxResponse;
import com.trkj.crmproject.vo.customerVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(maxAge = 3600)
@Slf4j
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AddressService addressService;

    @GetMapping("/findCustomers")
    public AjaxResponse findCustomers(int pageNum, int pageSize,int salesperson_id){
        PageInfo<customerVo> info=customerService.findCustomers(pageNum,pageSize,salesperson_id);
        return AjaxResponse.success(info);
    }
    @GetMapping("/findCustomer")
    public AjaxResponse findCustomer(int pageNum, int pageSize,String customer_name, String customer_stage,String create_time1,
                                     String create_time2,int salesperson_id){
        PageInfo<customerVo> info=customerService.findCustomer(pageNum,pageSize,customer_name,customer_stage,
                create_time1,create_time2,salesperson_id);
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
    @GetMapping("/findConXq")
    public AjaxResponse findConXq(int customer_id){
        System.out.println(customerService.findConXq(customer_id));
        return AjaxResponse.success(customerService.findConXq(customer_id));
    }
    @PostMapping("/addcustomer")
    public AjaxResponse addCustomer(@RequestBody AddVo addVo){
        addressService.insertAddress(addVo);
        int address_id=addressService.findAddById(addVo);
        addVo.setAddress_id(address_id);
        customerService.addCustomer(addVo);
        int customer_id=addressService.findCustomerById(addVo);
        addVo.setCustomer_id(customer_id);
        customerService.addContact(addVo);
        int contact_id=addressService.findContactById(addVo);
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
//
        return AjaxResponse.success(customerService.updataCustomerById(customer_id));
    }

    @DeleteMapping("/customer/{customer_id}")
    public AjaxResponse delCustomers(@PathVariable("customer_id") int customer_id){
        int address_id=addressService.findAddressById(customer_id);
        customerService.deleteCusCon(customer_id);
        return AjaxResponse.success(customerService.deleteCustomerById(customer_id));
    }
}
