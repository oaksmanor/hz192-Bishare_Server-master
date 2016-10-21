package com.example.hangzhao;

import com.example.hangzhao.data.*;
import com.example.hangzhao.service.ByService;
import com.example.hangzhao.web.ByController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ByController.class)
public class BishareServerMVCTests {

    @Autowired
    private MockMvc mvc;


    @MockBean
    private ByService byService;




    @Before
    public void setup() throws Exception {

    }

    @Test
    public void contextLoads() {
    }


    @Test
    public void rent() {
//        try {
//            mvc.perform(post("/rent").param("dockingBayID", "123").param("customerID", "456"))
//                    .andExpect(status().isOk())
//                    .andExpect(content().string("user or dockbay doesn't exsit"));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void loadCustomers() {
        try {
            mvc.perform(get("/customer"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
