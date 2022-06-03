package com.prakhar.service;

import com.prakhar.model.employee;
import com.prakhar.repository.emprepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class empservice {
    @Autowired
    emprepo emprepo;

    public List<employee> getemp(){
        List<employee> employeeList= emprepo.findAll();
        return employeeList;
    }
    public String saveemp(employee employee){
        if(emprepo.existsById(employee.getId())){
            return "Couldn't save data id already exists";
        }
        else {
            emprepo.save(employee);
            return "Employee added";

        }
    }
}
