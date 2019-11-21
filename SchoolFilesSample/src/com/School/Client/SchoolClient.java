package com.School.Client;

import java.util.List;
import java.util.Scanner;

import com.School.Dao.ScahoolDaoImpl;
import com.School.baen.SchoolBean;

public class SchoolClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ScahoolDaoImpl scd = new ScahoolDaoImpl();
		int k = 1;
		while (k == 1) {
			System.out.println("1)AddRecord");
			System.out.println("2)View Record");
			System.out.println("3)View Specific Record");
			System.out.println("4)Update Record");
			System.out.println("5)Delete Record");
			System.out.println("6)Exit");
			System.out.println("enter your choice");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				scd.AddSchool();
				break;
			case 2:
				List<SchoolBean> addRecords = scd.viewSchool();

				for (SchoolBean bean : addRecords)
					System.out.println(bean);
				break;
			case 3:
				System.out.println("enter school no");
				int sno = sc.nextInt();
				scd.ViewSpecificSchool(sno);
				break;
			case 4:
				System.out.println("enter school number");
				int sno1 = sc.nextInt();
				scd.UpdateSchool(sno1);
				break;
			case 5:
				System.out.println("enter school number");
				int sno2 = sc.nextInt();
				scd.DeleteSchool(sno2);
				break;
			case 6:
				System.out.println("tq u for using ");
				System.exit(0);
			default:
				System.out.println("enter your choice from 1 to 6");
			}

		}

	}
}