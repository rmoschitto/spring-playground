package com.galvanize.demo.math;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

    @Test
    public void canCalculateCircleArea() throws Exception {       //when you expect an exception add it here
        MockHttpServletRequestBuilder request1 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "circle")
                .param("radius", "4");

        this.mvc.perform(request1)
                .andExpect(status().isOk())
                .andExpect(content().string("Area of a circle with a radius of 4.000000 is 50.265482."));
    }
    @Test
    public void canCalculateRectangleArea() throws Exception {       //when you expect an exception add it here
        MockHttpServletRequestBuilder request1 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "rectangle")
                .param("width", "4")
                .param("height", "7");

        this.mvc.perform(request1)
                .andExpect(status().isOk())
                .andExpect(content().string("Area of a 4.000000x7.000000 rectangle is 28.000000."));
    }

    @Test
    public void sendsOutInvalid() throws Exception {       //when you expect an exception add it here
        MockHttpServletRequestBuilder request1 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "rectangle")
                .param("radius", "5");

        this.mvc.perform(request1)
                .andExpect(status().isOk())
                .andExpect(content().string("Invalid."));
    }
}
