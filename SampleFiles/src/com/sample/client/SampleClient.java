package com.sample.client;

import java.util.List;
import java.util.Scanner;

import com.sample.bean.SampleBean;
import com.sample.doa.SampleDaoImpl;

public class SampleClient {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		SampleDaoImpl sb=new SampleDaoImpl();
		int k=1;
		while(k==1)
		{
		System.out.println("1)AddSample");
		System.out.println("2)View Sample");
		System.out.println("3)View Specific Sample");
		System.out.println("4)Update Sample");
		System.out.println("5)Delete Sample");
		System.out.println("6)Exit");
		System.out.println("enter your choice");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			sb.AddSample();
			break;
		case 2:
			List<SampleBean>addRecords=sb.ViewSample();
			for(SampleBean sb1:addRecords)
			{
				System.out.println(sb1);
				break;
			}
		case 3:
			System.out.println("enter sample number");
			int sno=sc.nextInt();
			sb.ViewSpecificSample(sno);
			break;
		case 4:
			System.out.println("enter sample number");
			int sno1=sc.nextInt();
			sb.UpdateSample(sno1);
			break;
		case 5:
			System.out.println("enter sample number");
			int sno2=sc.nextInt();
			sb.DeleteSample(sno2);
			break;
		case 6:
			System.out.println("tq u for using");
			System.exit(0);
		
		}
	}

}
}