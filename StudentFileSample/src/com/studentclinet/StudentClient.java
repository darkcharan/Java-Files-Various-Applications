package com.studentclinet;

import java.util.List;
import java.util.Scanner;

import com.studentDao.StudentDaoImpl;
import com.studentbean.StudentBean;

public class StudentClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		StudentDaoImpl st=new StudentDaoImpl();
		int k=1;
		while(k==1)
		{
		System.out.println("1)Add Records");
		System.out.println("2)View Records");
		System.out.println("3)View Specific Record");
		System.out.println("4)Update Record");
		System.out.println("5)Delete Record");
		System.out.println("6)exit");
		
		System.out.println("enter your choice from 1 to 6");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:st.AddStudent();
		break;
		case 2:List<StudentBean>addRecords=st.viewStudents();
		for(StudentBean st1:addRecords)
		{
		  System.out.println(st1);	
		}
		break;
		case 3:
			System.out.println("enter student no");
			int sno=sc.nextInt();
			st.viewSpecificStudent(sno);
			break;
		case 4:
			System.out.println("enter student no");
			int sno1=sc.nextInt();
			st.UpdateStudent(sno1);
			break;
		case 5:
			System.out.println("enter student no");
			int sno2=sc.nextInt();
			break;
		case 6:
			System.out.println("tq u for using student");
			System.exit(0);
		}
		
		
		}
	}

}
