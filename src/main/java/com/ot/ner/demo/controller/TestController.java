package com.ot.ner.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TestController {

    @RequestMapping("/")
    public String sampleMessage(){
        return "It works!";
    }

}
