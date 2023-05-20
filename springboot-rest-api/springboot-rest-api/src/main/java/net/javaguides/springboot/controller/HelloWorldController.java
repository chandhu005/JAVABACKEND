package net.javaguides.springboot.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Spring MVS REST controller
@RestController
public class HelloWorldController {
    //Http GET Request
    //http://localhost:8080/hellow-world
    @GetMapping("/hellow-world")
    public String helloWorld(){
        return "hellow mawa BRO";

    }

}
