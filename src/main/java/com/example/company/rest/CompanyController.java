package com.example.company.rest;

import com.example.company.entity.Company;
import com.example.company.entity.Employee;
import com.example.company.service.CompanyService;
import com.example.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CompanyController {
    @Autowired
    CompanyService companyService;
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/company")
    public List<Company> findAll() {
        return companyService.findAll();
    }
    @GetMapping("company/{companyId}")
    public Company getEmployee(@PathVariable("companyId") int companyId)  {
        Company  theCompany = companyService.findById(companyId);

        return  theCompany;
    }
    @GetMapping("company/{companyId}/employees")
    public List <Employee> getEmployeeByCompanyId(@PathVariable("companyId") int companyId) {
        List<Employee>  theEmployee1 = employeeService.getAllEmployeeByCompanyId(companyId);

        return  theEmployee1;
    }
    @PostMapping("/company")
    public Company addCompany(@RequestBody Company theCompany) {

        companyService.save(theCompany);
        return theCompany;
    }
    @PutMapping("/company/{companyId}")
    public Company updateCompany(@PathVariable("companyId") int companyId,@RequestBody Company theCompany) {
        
        theCompany.setId(companyId);
        companyService.save(theCompany);
        return theCompany;
    }

//    @DeleteMapping("/company/{companyId}/employees/{employeeId}")
//    public String deleteEmployee(@PathVariable("companyId") int companyId,@PathVariable("employeeId") int employeeId) {
//        employeeService.deleteEmployeeFromCompany(companyId,employeeId);
//        return "Delete employee id: " + employeeId +" from company id: " +companyId;
//    }

    @PostMapping("company/{companyId}/employees")
    public List<Employee> addList(@PathVariable("companyId") int companyId, @RequestBody List<Employee> theEmployee) {
        Company tempCompany = companyService.findById(companyId);
        for(Employee e : theEmployee) {
            e.setCompany(tempCompany);
        }
        employeeService.saveList(theEmployee);
        return theEmployee;
    }
    @PutMapping("company/{companyId}/employees/{employeeId}")
    public Employee updateEmployee(@PathVariable("companyId") int companyId,@PathVariable("employeeId") int employeeId, @RequestBody Employee theEmployee) {
        Company tempCompany = companyService.findById(companyId);
        theEmployee.setCompany(tempCompany);
        theEmployee.setId(employeeId);
        employeeService.save(theEmployee);
        return theEmployee;
    }
    @DeleteMapping("company/{companyId}/employees/{employeeId}")
    public String getList(@PathVariable("companyId") int companyId, @PathVariable("employeeId") int employeeId ) {
        Company tempCompany = null;
        Employee tempEmloyee = employeeService.findById(employeeId);
        tempEmloyee.setCompany(tempCompany);
        employeeService.save(tempEmloyee);

        return "Success!!!!!";
    }
    @GetMapping("company/{companyId}/employees/{employeeId}")
    public Employee getEmployeeCustom(@PathVariable("companyId") int companyId, @PathVariable("employeeId") int employeeId ) {
        return employeeService.findEmployee(companyId, employeeId);
    }


}
