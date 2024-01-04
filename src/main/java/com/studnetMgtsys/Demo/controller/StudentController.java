package com.studnetMgtsys.Demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/student")
public class StudentController {

    @GetMapping
    public String name(){
        return "ransilu";
    }
}
