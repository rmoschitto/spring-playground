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

//    @GetMapping("/math/pi") // this is the path
//    public String helloPiWorld() {
//        return "3.141592653589793";
//    } // this is the method

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

    /*

    www.google.com/search?q=cats&sort=desc
    domain          path   query string or request parameter

        @RequestParam has arguments that you can pass it.
        Required = false,
        Default value = cats;
        value = "q"
        // q must match the q in the query string

    @GetMapping("/search")
    public String getCats( @RequestParam(Required = false, defaultValue = "cats", value = "q") String q ) {
    return q;
        }



    www.amazon.com/product/101918
    domain          path(through the 101918) path variable is 101918

    @GetMapping("/product/{id}" )     // the "id" here is created by me. it is the path variable
    public String getProduct(@PathVariable int id)   // can declare int or String, but if it comes in wrong type may throw error
    return id;
    }
     */

}