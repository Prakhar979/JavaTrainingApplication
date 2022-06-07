package com.prakhar.controller;

import com.prakhar.service.*;
import com.prakhar.model.employee;
import com.prakhar.repository.emprepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class empcontroller {

    @Autowired
    empservice empservice;


    @GetMapping("/emp")
    public List<employee> getemp(){
        return empservice.getemp();
    }

    @GetMapping("/")
    public String home(){
        return "<h1>WELCOME TO PRAKHAR'S FIRST SPRING BOOT APPLICATION<h1>";
    }


    @PostMapping("/add")
    public String addemp(@RequestBody employee employee){
        return empservice.saveemp(employee);
    }

    @GetMapping("/emp/{age}")
    public List<employee> findEmpByAge(@PathVariable("age") Integer age){
        return empservice.findByAge(age);
    }
}
