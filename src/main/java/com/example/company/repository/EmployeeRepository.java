package com.example.company.repository;

import com.example.company.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value = "SELECT * FROM Employee e where e.companyid = ?1 ",nativeQuery = true)
    List<Employee> getAllEmployeeByCompanyId(int companyId);
    @Query(value = "SELECT * FROM Employee e where e.companyid = ?1 AND e.employeeid = ?2",nativeQuery = true)
    Employee getEmployeeByEmIdAndComId(int companyId,int employeeId);

    @Query(value = "DELETE FROM Employee e where e.companyid  = ?1 AND e.employeeid = ?2",nativeQuery = true)
    @Transactional
    @Modifying
    void deleteEmployeeFromCompany(int companyId, int employeeId);

    List<Employee> findEmployeeByCompanyIdAndIdIn(int companyId, List<Integer> employeeId);
    Employee findEmployeeByCompanyIdAndId(int companyId, int employeeId);

}
