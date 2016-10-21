package com.example.hangzhao;

import com.example.hangzhao.data.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hangzhao on 7/10/16.
 */
@Component
public class InitDB implements CommandLineRunner{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BicycleRepository bicycleRepository;

    @Autowired
    private DockBayRepository dockBayRepository;

    private static Log logger = LogFactory.getLog(InitDB.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("clean data");

        customerRepository.deleteAll();
        bicycleRepository.deleteAll();
        dockBayRepository.deleteAll();

        logger.info("init bicycle data");

        List<Bicycle> bicycleList = new ArrayList<Bicycle>();

        Bicycle bicycle3=null;
        int bicycle_id_base = 200000;
        for(int i=0;i<10;i++){
            if(i==3){
                bicycle3  = new Bicycle(false);
                bicycle3.setId(String.valueOf(bicycle_id_base+i));
                bicycleList.add(bicycle3);
            }else{
                Bicycle bicycle = new Bicycle(true);
                bicycle.setId(String.valueOf(bicycle_id_base+i));
                bicycleList.add(bicycle);
            }
        }

        DockBay dockBay1 = new DockBay(-37.788683,175.316946);
        dockBay1.setId("1001");
        DockBay dockBay2 = new DockBay(-37.787871,175.316264);
        dockBay2.setId("1002");
        DockBay dockBay3 = new DockBay(-37.787765,175.318662);
        dockBay3.setId("1003");
        bicycleList.get(0).setDockBay(dockBay1);
        bicycleList.get(1).setDockBay(dockBay1);
        bicycleList.get(2).setDockBay(dockBay1);
        bicycleList.get(4).setDockBay(dockBay2);
        bicycleList.get(5).setDockBay(dockBay2);
        bicycleList.get(6).setDockBay(dockBay2);
        bicycleList.get(7).setDockBay(dockBay3);
        bicycleList.get(8).setDockBay(dockBay3);
        bicycleList.get(9).setDockBay(dockBay3);
        bicycleRepository.save(bicycleList);


        logger.info("init dockbay data");


        List<Bicycle> bicycleSet1 = new ArrayList<Bicycle>();
        bicycleSet1.add(bicycleList.get(0));
        bicycleSet1.add(bicycleList.get(1));
        bicycleSet1.add(bicycleList.get(2));
        dockBay1.setBicycleSet(bicycleSet1);
        dockBayRepository.save(dockBay1);


        List<Bicycle> bicycleSet2 = new ArrayList<Bicycle>();
        bicycleSet2.add(bicycleList.get(4));
        bicycleSet2.add(bicycleList.get(5));
        bicycleSet2.add(bicycleList.get(6));
        dockBay2.setBicycleSet(bicycleSet2);
        dockBayRepository.save(dockBay2);


        List<Bicycle> bicycleSet3 = new ArrayList<>();
        bicycleSet3.add(bicycleList.get(7));
        bicycleSet3.add(bicycleList.get(8));
        bicycleSet3.add(bicycleList.get(9));
        dockBay3.setBicycleSet(bicycleSet3);
        dockBayRepository.save(dockBay3);


        logger.info("init customer data");

        Customer customer1 = new Customer("Steve","Rogers",bicycle3);
        customer1.setId("DR724688");
        customer1.setRentTime(new Date());
        Customer customer2 = new Customer("Jack","Sparrow",null);
        customer2.setId("DR724686");
        customerRepository.save(customer1);
        customerRepository.save(customer2);

    }
}
