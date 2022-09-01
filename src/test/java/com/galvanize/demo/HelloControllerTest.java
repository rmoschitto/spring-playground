package com.galvanize.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testIndexEndpoint() throws Exception {
        this.mvc.perform(get("/").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello from Spring!"));
    }

    @Test
    public void testPostMessageEndpoint() throws Exception {
        this.mvc.perform(post("/messages"))
                .andExpect(status().isOk())
                .andExpect(content().string("POST to messages route"));
    }
    @Test
    public void testPIWeb() throws Exception {
        this.mvc.perform(get("/math/pi"))
                .andExpect(status().isOk())
                .andExpect(content().string("3.141592653589793"));
    }



}


