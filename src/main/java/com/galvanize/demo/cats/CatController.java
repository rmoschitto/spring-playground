package com.galvanize.demo.cats;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatController {

//    @GetMapping("/cats")
//    public String getSpecificCats(@RequestParam String name, @RequestParam String color){
//        return String.format("The name of the cat is %s and it is a %s.", name, color);
//    }

    //Creating a POJO Plain old Java Object
    @GetMapping("/cats")
    public String getSpecificCats(Cat newCat){
        return String.format("The name of the cat is %s and it is a %s.", newCat.getName(), newCat.getColor());
    }



}
