package com.prakhar.repository;

import com.prakhar.model.employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface emprepo extends JpaRepository<employee, Integer> {
    @Query(value = "select * from employee where age= :age",nativeQuery = true)
    List<employee> getByage(Integer age);

}
