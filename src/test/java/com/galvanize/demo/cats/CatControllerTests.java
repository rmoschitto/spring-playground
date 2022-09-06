package com.galvanize.demo.cats;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class CatControllerTests {

    @Autowired
    MockMvc mvc;

    @Test
    public void getCatsReturnsNameOfCat() throws Exception {       //when you expect an exception add it here
        //setup
        //execute
        this.mvc.perform(get("/cats?name=fluffy&Color=tabby"))
                //assignment
                .andExpect(status().isOk())
                .andExpect(content().string("The name of the cat is fluffy and it is a tabby."));


        this.mvc.perform(get("/cats?name=midnight&Color=black"))
                //assignment
                .andExpect(status().isOk())
                .andExpect(content().string("The name of the cat is midnight and it is a black."));

//        this.mvc.perform(get("/cats?name=midnight")) // this tests the optionality of the default color is brown
//                //assignment
//                .andExpect(status().isOk())
//                .andExpect(content().string("The name of the cat is midnight and it is a brown."));
    }


}