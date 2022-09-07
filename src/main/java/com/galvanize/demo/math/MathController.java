package com.galvanize.demo.math;


import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MathController {
    @GetMapping("/math/pi")
    public Double getPi(){
        return 3.141592653589793;
    }


    //question what's difference between variables and parameters
    //how organize the service vs controller vs test
            //the service holds teh logic and the methods...
            //the controller is interacting with the HTTP methods

    //circles require radius
    //rectangles require width and height
    //anything else render invalid

    @PostMapping("/math/area")  // the {} are the variables for math/area
    public String calculateAreas(@RequestParam Map<String, String> params){
        String areaOutput = "";
        if (params.get("type").equals("circle")) {
            if (params.containsKey("height") | params.containsKey("width")) {
                areaOutput = "Invalid.";
            } else {
            double radius = Double.parseDouble(params.get("radius"));
               areaOutput = MathService.calculateAreaCircle(radius);
            }} else if (params.get("type").equals("rectangle")) {
                if (params.containsKey("radius")) {
                    areaOutput = "Invalid.";
                } else {
                    double height = Double.parseDouble(params.get("height"));
                    double width = Double.parseDouble(params.get("width"));
              areaOutput = MathService.calculateAreaRectangle(width, height);
            }
        }
        return areaOutput;
    }
}