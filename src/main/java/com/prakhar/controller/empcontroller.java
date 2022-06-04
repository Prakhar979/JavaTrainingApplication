package com.prakhar.controller;

import com.prakhar.service.*;
import com.prakhar.model.employee;
import com.prakhar.repository.emprepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class empcontroller {

    @Autowired
    empservice empservice;


    @GetMapping("/emp")
    public List<employee> getemp(){
        return empservice.getemp();
    }

    @PostMapping("/add")
    public String addemp(@RequestBody employee employee){
        return empservice.saveemp(employee);
    }
}
