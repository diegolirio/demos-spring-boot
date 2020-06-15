package com.example.calculatorwsclient.v1.api;

import com.example.calculatorwsclient.v1.service.calculator.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CalculatorRestController {

    @Autowired
    private CalculatorService service;

    @GetMapping("/add")
    public String add(String n1, String n2) {
        StringBuilder xml = new StringBuilder();
        xml.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">");
        xml.append("<soapenv:Header/>");
        xml.append("<soapenv:Body>");
        xml.append("<tem:Add>");
        xml.append("<tem:intA>" + n1 + "</tem:intA>");
        xml.append("<tem:intB>" + n2 + "</tem:intB>");
        xml.append("</tem:Add>");
        xml.append("</soapenv:Body>");
        xml.append("</soapenv:Envelope>");
        String xmlResult = this.service.add(xml.toString());
        return xmlResult;
    }

}
