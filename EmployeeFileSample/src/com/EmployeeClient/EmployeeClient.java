package com.EmployeeClient;

import java.util.List;
import java.util.Scanner;

import com.EmployeeBean.EmployeeBean;
import com.EmployeeDao.EmployeeDaoImpl;

public class EmployeeClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		EmployeeDaoImpl emp=new EmployeeDaoImpl();
		
		int k=1;
		while(k==1)
		{
		System.out.println("1)AddRecords");
		System.out.println("2)ViewRecord");
		System.out.println("3)ViewSpecificRecord");
		System.out.println("4)UpdateRecord");
		System.out.println("5)DeleteRecord");
		System.out.println("6)Exit");
		
		
		System.out.println("enter your choice");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			emp.addEmployee();
			break;
		case 2:
			List<EmployeeBean> viewRecord=	emp.viewEmployee();
			for(EmployeeBean e : viewRecord)
				System.out.println(e);
			break;
		case 3:
			System.out.println("enter employee no");
			int eno=sc.nextInt();
			emp.viewSpecificEmployee(eno);
			break;
		case 4:
			System.out.println("enter employee no");
			int eno1=sc.nextInt();
			emp.UpdateEmployee(eno1);
			break;
		case 5:
			System.out.println("enter employee no");
			int eno2=sc.nextInt();
			emp.DeleteEmployee(eno2);
			break;
		case 6:
			System.out.println("tq for using Application");
			System.exit(0);
			default:
				System.out.println("enter your choice from 1 to 6");
		}
		

	}

}
}