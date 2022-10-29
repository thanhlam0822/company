package com.example.company.service;

import com.example.company.entity.Company;
import com.example.company.entity.Employee;
import com.example.company.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyRepository companyRepository;
    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company findById(int companyId) {
        Optional<Company> list = companyRepository.findById(companyId);
        Company theCompany= list.get();
        return  theCompany;
    }

    @Override
    public void save(Company theCompany) {
        companyRepository.save(theCompany);
    }

    @Override
    public void deleteById(int companyId) {
        companyRepository.deleteById(companyId);
    }


}
