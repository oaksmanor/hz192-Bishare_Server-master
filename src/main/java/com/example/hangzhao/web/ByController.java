package com.example.hangzhao.web;

import com.example.hangzhao.data.*;
import com.example.hangzhao.service.ByService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by hangzhao on 7/10/16.
 */

@Controller
public class ByController {

    @Autowired
    private ByService byService;

    @GetMapping("/")
    @ResponseBody
    public String helloWorld(){
        return this.byService.getHelloMessage();
    }

    @GetMapping("/bicycle")
    @ResponseBody
    public List<Bicycle> getAllBicycles(){
        return byService.getAllBicycles();
    }

    @GetMapping("/customer")
    @ResponseBody
    public List<Customer> getAllCustomers(){
        return byService.getAllCustomers();
    }

    @GetMapping("/dockbay")
    @ResponseBody
    public List<DockBay> getAllDockBay(){
        return byService.getAllDockBay();
    }

    @PostMapping("/rent")
    @ResponseBody
    public String rentBicycle(@RequestParam String dockingBayID, @RequestParam String customerID){
        return byService.rent(customerID,dockingBayID);
    }

    @PostMapping("/return")
    @ResponseBody
    public String returnBicycle(@RequestParam String dockingBayID, @RequestParam String customerID, @RequestParam String bicycleID){
        return byService.returnBicycle(customerID,bicycleID,dockingBayID);
    }

    @GetMapping("/status/{customerID}")
    @ResponseBody
    public Customer customerStatus(@PathVariable String customerID){
        return byService.customerStatus(customerID);
    }
}
