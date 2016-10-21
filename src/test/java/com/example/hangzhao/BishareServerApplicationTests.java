package com.example.hangzhao;

import com.example.hangzhao.service.ByService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BishareServerApplicationTests {


    @Autowired
    private ByService byService;


	@Test
	public void contextLoads() {
	}


	@Test
	public void testRent(){
        //not found
        assertThat(byService.rent("111","222"),is("user or dockbay doesn't exsit"));
        //already taken
        assertThat(byService.rent("DR724688","1001"),is("user already has a bicycle with id 200003"));
        //succeed
        assertThat(byService.rent("DR724686","1001"),is("rent succeed!!!"));
        //assert id=200000 is rent  and user has bicycle id=20000

        assertThat(byService.getBicycle("200000").isAvailable(),is(false));
        assertThat(byService.getCustomer("DR724686").getKept_bicycle().getId(),is("200000"));
        assertThat(byService.getDockBay("1001").getBicycleSet().get(0).isAvailable(),is(false));
    }


    @Test
    public void testReturn(){

        byService.rent("DR724686","1001");

        assertThat(byService.returnBicycle("DR724686","200000","1001"),is("return succeed"));

        assertThat(byService.findBicycleInDockBay("200000","1001").isAvailable(),is(true));
        assertThat(byService.getCustomer("DR724686").getKept_bicycle(),is(nullValue()));
        assertThat(byService.getBicycle("200000").isAvailable(),is(true));
    }
}
