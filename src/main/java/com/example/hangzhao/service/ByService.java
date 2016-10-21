package com.example.hangzhao.service;

import com.example.hangzhao.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by hangzhao on 7/10/16.
 */
@Service
public class ByService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BicycleRepository bicycleRepository;

    @Autowired
    private DockBayRepository dockBayRepository;

    @Value("${name:World}")
    private String name;

    public String getHelloMessage() {
        return "Hello " + this.name;
    }


    //assume the bicycle only can be returned to the dockBay where it's originally rent.
    public String returnBicycle(String customerID, String bicycleID, String dockBayID){
        Bicycle bicycle = bicycleRepository.findOne(bicycleID);

        if(bicycle==null) return "bicycle not exist";
        if(!dockBayID.equals(bicycle.getDockBay().getId())) return "bicycle could not return to different place";

        Customer customer = customerRepository.findOne(customerID);
        customer.setKept_bicycle(null);
        bicycle.setAvailable(true);

        bicycleRepository.save(bicycle);
        customerRepository.save(customer);

        return "return succeed";
    }


    public String rent(String customerID,String dockBayID){
        Customer customer = customerRepository.findOne(customerID);
        DockBay dockBay = dockBayRepository.findOne(dockBayID);

        if(customer==null||dockBay==null) return "user or dockbay doesn't exsit";

        if(customer.getKept_bicycle()!=null) return "user already has a bicycle with id "+customer.getKept_bicycle().getId();

        List<Bicycle> bicycleSet = dockBay.getBicycleSet();

        if (bicycleSet.isEmpty()) return "no more bicycle can be rent";

        Iterator<Bicycle> it = bicycleSet.iterator();

        while(it.hasNext()){
            Bicycle bicycle = it.next();
            if(bicycle.isAvailable()){
                customer.setKept_bicycle(bicycle);
                customer.setRentTime(new Date());
                bicycle.setAvailable(false);
                customerRepository.save(customer);
                bicycleRepository.save(bicycle);
                dockBayRepository.save(dockBay);
                return "rent succeed!!!";
            }
        }

        return "no available bicycle";

    }


    public Bicycle findBicycleInDockBay(String bicycleID,String dockBayID){
        List<Bicycle> bicycleList = dockBayRepository.findOne(dockBayID).getBicycleSet();
        return bicycleList.stream().filter(it->it.getId().equals(bicycleID)).findFirst().get();
    }



    public List<Bicycle> getAllBicycles(){
        return this.bicycleRepository.findAll();
    }

    public List<Customer> getAllCustomers(){
        return this.customerRepository.findAll();
    }

    public List<DockBay> getAllDockBay(){
        return this.dockBayRepository.findAll();
    }


    public Bicycle getBicycle(String id){return bicycleRepository.findOne(id);}

    public Customer getCustomer(String id){return customerRepository.findOne(id);}

    public DockBay getDockBay(String id){return dockBayRepository.findOne(id);}


    public Customer customerStatus(String customerID) {
        return customerRepository.findOne(customerID);
    }
}
