package com.galvanize.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EndpointsController.class)
public class EndpointsControllerTest {

    @Autowired
    MockMvc mvc;

//    @Test
//    public void testIndexEndpoint() throws Exception {
//        this.mvc.perform(get("vehicles?year=1987&doors=2"))
//                .andExpect(status().isOk());
//    }

    @Test
    public void getAndPerformCalculation() {
        //setup
        //execute
        try {
            this.mvc.perform(get("/math/calculate?operation=multiply&x=4&y=6"))
                    //assignment
                    .andExpect(status().isOk())
                    .andExpect(content().string("4 * 6 = 24.000000"));
        } catch (Exception e) {
            throw new RuntimeException(e);

        }

        try {
            this.mvc.perform(get("/math/calculate?operation=add&x=4&y=6"))
                    //assignment
                    .andExpect(status().isOk())
                    .andExpect(content().string("4 + 6 = 10.000000"));
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
        try {
            this.mvc.perform(get("/math/calculate?operation=subtract&x=4&y=6"))
                    //assignment
                    .andExpect(status().isOk())
                    .andExpect(content().string("4 - 6 = -2.000000"));
        } catch (Exception e) {
            throw new RuntimeException(e);

        }

        try {
            this.mvc.perform(get("/math/calculate?operation=divide&x=30&y=5"))
                    //assignment
                    .andExpect(status().isOk())
                    .andExpect(content().string("30 / 5 = 6.000000"));
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }

    @Test
    void getVolumeOfRectangelWorks() throws Exception{
        this.mvc.perform(post("/math/volume/3/4/5"))
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 3x4x5 rectangle is 60"));

        this.mvc.perform(post("/math/volume/6/7/8"))
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 6x7x8 rectangle is 336"));
    }

}
