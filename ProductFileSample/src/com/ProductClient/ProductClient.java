package com.ProductClient;

import java.util.List;
import java.util.Scanner;

import com.ProductBean.ProductBean;
import com.ProductDao.ProductDaoImpl;

public class ProductClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		ProductDaoImpl pa=new ProductDaoImpl();
		int k=1;
		while(k==1)
		{
		System.out.println("1)Add Product");
		System.out.println("2)View Product");
		System.out.println("3)View Specific Product");
		System.out.println("4)Update Product");
		System.out.println("5)Delete Product");
		System.out.println("6)Exit");
		
		System.out.println("enter your choice");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			pa.addProduct();
			break;
		case 2:
			List<ProductBean>addRecords=pa.viewProduct();
			for(ProductBean pa1:addRecords)
			{
				System.out.println(pa1);
				break;
			}
		case 3:
			System.out.println("enter Product number");
			int pno=sc.nextInt();
			pa.viewSpecificProduct(pno);
			break;
		case 4:
			System.out.println("enter product number");
			int pno1=sc.nextInt();
			pa.UpdateProduct(pno1);
			break;
		case 5:
			System.out.println("enter product number");
			int pno2=sc.nextInt();
			pa.DeleteProduct(pno2);
			break;
		case 6:
			System.out.println("tq for using application");
			System.exit(0);
		}

	}

}
}