package com.galvanize.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello from Spring!";
    }

    @PostMapping("/messages")
    public String helloNewWorld() {
        return "POST to messages route";
    }

    @GetMapping("/math/pi")
    public String helloPiWorld() {
        return "3.141592653589793";
    }

        /*
            In order to respond to the following HTTP request:

            GET /tasks HTTP/1.1
            Host: example.com

            You would write:

            @GetMapping("/tasks")
            public String getTasks() {
            return "These are tasks";}

            NOTE: The name of the method getTasks is not important. It could be foo or bar and it would still work

            You can test this method out locally with:

            curl -X GET http://localhost:8080/tasks
     */

}