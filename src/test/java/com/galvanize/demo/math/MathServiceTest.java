package com.galvanize.demo.math;

import com.galvanize.demo.EndpointsController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EndpointsController.class)
public class MathServiceTest {

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
    void sumReturnsCorrectly() throws Exception {
        this.mvc.perform(post("/math/sum?n=4&n=5&n=6"))
                .andExpect(status().isOk())
                .andExpect(content().string("4 + 5 + 6 = 15"));
    }
}

