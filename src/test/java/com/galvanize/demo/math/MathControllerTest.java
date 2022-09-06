package com.galvanize.demo.math;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class MathControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void getPIReturnsValidPiString() throws Exception {       //when you expect an exception add it here
        //setup
        //execute
        this.mvc.perform(get("/math/pi"))
                //assignment
                .andExpect(status().isOk())
                .andExpect(content().string("3.141592653589793"));
    }

}
