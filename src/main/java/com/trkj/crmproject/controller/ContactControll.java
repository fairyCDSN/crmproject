package com.trkj.crmproject.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.service.AddressService;
import com.trkj.crmproject.service.ContactService;
import com.trkj.crmproject.service.CustomerService;
import com.trkj.crmproject.vo.AddVo;
import com.trkj.crmproject.vo.AjaxResponse;
import com.trkj.crmproject.vo.contactVo;
import com.trkj.crmproject.vo.customerVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Service;

@RestController
@CrossOrigin(maxAge = 3600)
@Slf4j
public class ContactControll {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private ContactService contactService;


    @GetMapping("/findContacts")
    public AjaxResponse findContacts(int pageNum, int pageSize, int salesperson_id){
        PageInfo<contactVo> info=contactService.findContacts(pageNum,pageSize,salesperson_id);
        return AjaxResponse.success(info);
    }

    @GetMapping("/findContacts2")
    public AjaxResponse findContacts2(int pageNum, int pageSize,String contactName, String customerName,String customerType,
                                      int salesperson_id){
        PageInfo<contactVo> info=contactService.findContacts2(pageNum,pageSize,contactName,customerName, customerType,salesperson_id);
        System.out.println(info+"======================================================asdasdasd");
        return AjaxResponse.success(info);
    }

    @GetMapping("/findConXq")
    public AjaxResponse findConXq(int customer_id){
        return AjaxResponse.success(contactService.findConXq(customer_id));
    }
    @GetMapping("/findConCusXq")
    public AjaxResponse findConCusXq(int contactId){
        System.out.println(contactService.findConCusXq2(contactId));
        return AjaxResponse.success(contactService.findConCusXq2(contactId));
    }
    @PutMapping("/contact")
    public AjaxResponse updateContact(@RequestBody contactVo contactVo){
        System.out.println(contactVo);
        return AjaxResponse.success(contactService.updateContact(contactVo));
    }
    @PostMapping("/insertContact")
    public AjaxResponse insertContact(@RequestBody AddVo addVo){
        if (contactService.addContact(addVo)==null) {
            String asd="该客户联系人数量已达上限";
            return AjaxResponse.success(asd);
        }else{
            int contact_id=contactService.findContactById(addVo);
            addVo.setContact_id(contact_id);
            customerService.addConCus(addVo);
            return AjaxResponse.success();
        }
    }
    @DeleteMapping("/contact")
    public AjaxResponse deletecontact(int contactId){
        contactService.deletecontact(contactId);
        return AjaxResponse.success();
    }
}
