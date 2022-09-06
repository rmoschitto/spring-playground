package com.galvanize.demo.math;

import org.springframework.util.MultiValueMap;


public class MathService {


    //404 error check the URLs
    public String getCalculations(String operationType, int x, int y) {
        float solution = 0.f;
        String output = "";
        switch (operationType) {
            case "add" -> {
                solution = x + y;
                output = String.format("%d + %d = %f", x, y, solution);
            }
            case "subtract" -> {
                solution = x - y;
                output = String.format("%d - %d = %f", x, y, solution);
            }
            case "multiply" -> {
                solution = x * y;
                output = String.format("%d * %d = %f", x, y, solution);
            }
            case "divide" -> {
                solution = x / y;
                output = String.format("%d / %d = %f", x, y, solution);
            }
        }
        return output;
    }

    public String sumOfN( MultiValueMap<String, String> requestParams) {
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
//        //iteration
//        for (String number : requestParams.get("n")) {
//            sb.append(number);
//            sb.append(" + ");
//
//            sum += Integer.parseInt(number);
//
//            //need to replace the last + sign with an equals sign
//
//            sb.replace(sb.length() - 3, sb.length() -1, " = ");
//            sb.append(sum);
//        }
//        return sb.toString();


//
//    @PostMapping("/math/sum")
//    public String passMathSumParameters(@RequestParam MultiValueMap<String, String> requestParams) {
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


