package com.example.company.repository;

import com.example.company.entity.Company;
import com.example.company.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company,Integer> {

}
