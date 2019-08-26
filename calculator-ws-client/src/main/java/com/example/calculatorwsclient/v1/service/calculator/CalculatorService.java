package com.example.calculatorwsclient.v1.service.calculator;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "calculator", url = "http://www.dneonline.com/calculator.asmx")
public interface CalculatorService {

    @RequestMapping(method = RequestMethod.POST, consumes = "text/xml", produces = "text/xml")
    public String add(String xml);

}
