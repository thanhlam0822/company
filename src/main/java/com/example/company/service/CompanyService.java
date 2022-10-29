package com.example.company.service;

import com.example.company.entity.Company;
import com.example.company.entity.Employee;

import java.util.List;

public interface CompanyService {
    public List<Company> findAll();
    public Company findById(int companyId);
    public void save(Company theCompany);
    public void deleteById(int companyId);
}
