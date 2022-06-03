package com.prakhar.repository;

import com.prakhar.model.employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface emprepo extends JpaRepository<employee, Integer> {

}
