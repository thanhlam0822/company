package com.example.company.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeid")
    private int id;
    @Column(name = "employeneame")
    private String name;
    @Column(name = "employeemail")
    private String mail;


    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,
                          CascadeType.DETACH,CascadeType.REFRESH })
//    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("employee")
    @JsonIgnore
    @JoinColumn(name = "companyid")
    private Company company;

    public Employee() {


    }
    public Employee( String name, String mail ) {
        this.name = name;
        this.mail = mail;

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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


}
