package com.galvanize.demo;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/math/calculate")
    public String getCalculations(@RequestParam(required = false, value = "operation", defaultValue = "add") String operationType, @RequestParam int x, @RequestParam int y) {
        float solution = 0.f;
        String printEnding = "";
        switch (operationType) {
            case "add" -> {
                solution = x + y;
                printEnding = String.format("%d + %d = %f", x, y, solution);
            }
            case "subtract" -> {
                solution = x - y;
                printEnding = String.format("%d - %d = %f", x, y, solution);
            }
            case "multiply" -> {
                solution = x * y;
                printEnding = String.format("%d * %d = %f", x, y, solution);
            }
            case "divide" -> {
                solution = x / y;
                printEnding = String.format("%d / %d = %f", x, y, solution);
            }
        }
        return printEnding;
    }

    @PostMapping("/math/sum")
    public String passMathSumParameters(@RequestParam MultiValueMap<String, String> requestParams) {
        int sum = 0;
        StringBuilder sb = new StringBuilder(); // Empty String waiting to add the n #'s
        for (int i = 0; i < requestParams.get("n").size(); i++) {
            int currentNumber = Integer.parseInt(requestParams.get("n").get(i));
            sum += currentNumber;
            sb.append(currentNumber);
            if (i == requestParams.get("n").size() - 1) {
                sb.append(" = ");
                sb.append(sum);
            } else {
                sb.append(" + ");
            }
        }
        return sb.toString();
    }
}


//
//
//
//
//
//        double totalSum = 0;
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < requestParams.size(); i++) {
//            String currentValue = String.valueOf(requestParams.get(i));
//            int currentNumber = Integer.parseInt(currentValue);
//            totalSum += currentNumber;
//            //string builder to add each n value for the return statement
//        }
//        return String.format("This is sum %s", totalSum);
//    }




    //    @GetMapping("/cats")
//    public String getSpecificCats(@RequestParam String name, @RequestParam String color){
//        return String.format("The name of the cat is %s and it is a %s.", name, color);
//    }


