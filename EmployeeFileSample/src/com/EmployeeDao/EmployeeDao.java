package com.EmployeeDao;

import java.util.List;

import com.EmployeeBean.EmployeeBean;

public interface EmployeeDao {
	void addEmployee();
	List<EmployeeBean>viewEmployee();
	void viewSpecificEmployee(int eno);
	void UpdateEmployee(int eno);
	void DeleteEmployee(int eno);

}
