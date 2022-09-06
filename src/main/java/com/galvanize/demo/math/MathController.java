package com.galvanize.demo.math;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
    @GetMapping("/math/pi")
    public Double getPi(){
        return 3.141592653589793;
    }

}
