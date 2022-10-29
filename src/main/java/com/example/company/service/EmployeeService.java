package com.example.company.service;

import com.example.company.entity.Employee;

import java.util.List;

public interface EmployeeService  {
    public List<Employee> findAll();
    public Employee findById(int employeeId);
    public void save(Employee employee);
    public void saveList(List<Employee> employeeList);
    public void deleteEmployeeFromCompany(int companyId,int employeeId);
    public List<Employee> getAllEmployeeByCompanyId(int companyId);
    List<Employee> findEmployeeByCompanyIdAndIdIn(int companyId, List<Integer> employeeId);
    void deleteAll(List<Employee> employees);
    Employee findEmployee(int companyId, int employeeId);

}
