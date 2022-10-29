package com.example.company.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "companyid",nullable = true)
    private int id;

    @Column(name = "companyname")
    private String name;
    @OneToMany(mappedBy = "company",cascade = {CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.DETACH,CascadeType.REFRESH })

    @JsonIgnoreProperties("company")
    @JsonIgnore
    private List<Employee> employees;
    public Company() {

    }
    public Company( String name) {

        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
