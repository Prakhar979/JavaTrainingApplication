package com.prakhar.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class employee {
    @Id
    private int id;
    private String name;
    private int age;

    private String password;

    private String authority;

    public employee() {
    }

    public employee(int id, String name, int age, String password,String authority) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.password=password;
        this.authority=authority;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
