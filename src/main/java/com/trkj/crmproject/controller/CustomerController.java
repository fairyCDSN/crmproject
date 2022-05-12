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

@Slf4j
@RestController
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
    public AjaxResponse findCustomer(String customer_name, String customer_stage,String create_time1,String create_time2,int salesperson_id){
        return AjaxResponse.success(customerService.findCustomer(customer_name,customer_stage,create_time1,create_time2,salesperson_id));
    }
    @GetMapping("/findCusXq")
    public AjaxResponse findCusXq(int customer_id){
        System.out.println();
        return AjaxResponse.success(customerService.findCusXq(customer_id));
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
        return AjaxResponse.success();
    }
    @PutMapping("/customer")
    public AjaxResponse updateCustomer(@RequestBody customerVo customerVo){
        System.out.println("customerVo"+customerVo);
        return AjaxResponse.success(customerService.updateCustomer(customerVo));
    }
    @DeleteMapping("/customer/{customer_id}")
    public AjaxResponse delCustomer(@PathVariable("customer_id") int customer_id){
        customerService.deleteContactById(customer_id);
        return AjaxResponse.success(customerService.deleteCustomerById(customer_id));
    }
}
