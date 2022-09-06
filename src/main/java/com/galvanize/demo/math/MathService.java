package com.galvanize.demo.math;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MathService {

    @GetMapping("/math/calculate")
    public String getCalculations(@RequestParam(required = false, value = "operation", defaultValue = "add") String operationType, @RequestParam int x, @RequestParam int y) {
        float solution = 0.f;
        String output = "";
        switch (operationType) {
            case "add" -> {
                solution = x + y;
                output = String.format("%d + %d = %f", x, y, solution);
            }
            case "subtract" -> {
                solution = x - y;
                output =  String.format("%d - %d = %f", x, y, solution);
            }
            case "multiply" -> {
                solution = x * y;
                output =  String.format("%d * %d = %f", x, y, solution);
            }
            case "divide" -> {
                solution = x / y;
                output =  String.format("%d / %d = %f", x, y, solution);
            }
        }
        return output;
    }

    @PostMapping("/math/sum")
    public String passMathSumParameters(@RequestParam MultiValueMap<String, String> requestParams) {
        double totalSum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < requestParams.size(); i++) {
            String currentValue = String.valueOf(requestParams.get(i));
            int currentNumber = Integer.parseInt(currentValue);
            totalSum += currentNumber;
            //string builder to add each n value for the return statement
        }
        return String.format("This is sum %s", totalSum);
    }

}
