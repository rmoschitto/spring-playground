package com.galvanize.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EndpointsController {

    @GetMapping("/test")
    public String getIndex() {
        return "GET to index route";
    }


    //NOTE: The name of the method getTasks is not important. It could be foo or bar and it would still work
    @GetMapping("/tasks")
    public String getTasks() {
        return "These are tasks";
    }

}
