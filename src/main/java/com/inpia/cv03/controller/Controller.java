package com.inpia.cv03.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/")
    @ResponseBody
    public String sayHello(){
        return "<html><head><link rel=\"stylesheet\" href=\"./style.css\" /></head><body>" +
                "Hello World" +
                "</body></html>";
    }

}
