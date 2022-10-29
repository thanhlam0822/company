package com.example.company.service;

import com.example.company.entity.Company;
import com.example.company.entity.Employee;
import com.example.company.repository.CompanyRepository;
import com.example.company.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int employeeId) {
        Optional<Employee> list = employeeRepository.findById(employeeId);
        Employee theEmployee = list.get();
        return  theEmployee;

    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void saveList(List<Employee> employeeList) {
        employeeRepository.saveAll(employeeList);
    }


    @Override
    public void deleteEmployeeFromCompany(int companyId, int employeeId) {
        employeeRepository.deleteEmployeeFromCompany(companyId,employeeId);
    }



    @Override
    public List<Employee> getAllEmployeeByCompanyId(int companyId) {
        return employeeRepository.getAllEmployeeByCompanyId(companyId);
    }

    @Override
    public List<Employee> findEmployeeByCompanyIdAndIdIn(int companyId, List<Integer> employeeId) {
        return employeeRepository.findEmployeeByCompanyIdAndIdIn(companyId, employeeId);
    }

    @Override
    public void deleteAll(List<Employee> employees) {
        employeeRepository.deleteAll(employees);
    }

    @Override
    public Employee findEmployee(int companyId, int employeeId) {
        return  employeeRepository.findEmployeeByCompanyIdAndId(companyId, employeeId);
    }


}
