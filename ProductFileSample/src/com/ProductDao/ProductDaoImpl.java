package com.ProductDao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.ProductBean.ProductBean;

public class ProductDaoImpl implements ProductDao {
	Scanner sc=new Scanner(System.in);
	
	List<ProductBean>tempRecords=new ArrayList<ProductBean>();
	List<ProductBean>addRecords=null;
	ProductBean pb=null;
	
	FileOutputStream fos=null;
	ObjectOutputStream oos=null;
	FileInputStream fis=null;
	ObjectInputStream ois=null;
	
	File orginal=new File("orginalFile.txt");
	File temp=new File("tempFile.txt");
	

	@Override
	public void addProduct() {
		addRecords=new ArrayList<ProductBean>();
		// TODO Auto-generated method stub
		int k=1;
		while(k==1)
		{
		System.out.println("enter product number");
		int pno=sc.nextInt();
		System.out.println("enter product name");
		String pname=sc.next();
		System.out.println("enter product qunatity");
		int pquantity=sc.nextInt();
		System.out.println("enter product weight");
		double pweight=sc.nextDouble();
		System.out.println("enter product price");
		double pprice=sc.nextDouble();
		pb=new ProductBean(pno,pname,pquantity,pweight,pprice);
		addRecords.add(pb);
		System.out.println("do u want to add record 1)yes 2)No");
		k=sc.nextInt();
		}
		
		try {
			fos=new FileOutputStream(orginal,true);
			oos=new ObjectOutputStream(fos);
			oos.writeObject(addRecords);
			oos.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(oos!=null)
			{
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public List<ProductBean> viewProduct() {
		List<ProductBean>addRecords=null;
		try {
			fis=new FileInputStream(orginal);
			ois=new ObjectInputStream(fis);
            addRecords=(List<ProductBean>)ois.readObject();		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(oos!=null)
			{
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return addRecords;
		
		
	}

	@Override
	public void viewSpecificProduct(int pno) {
		// TODO Auto-generated method stub
		addRecords=new ArrayList<ProductBean>();
		try {
			fis=new FileInputStream(orginal);
			ois=new ObjectInputStream(fis);
			addRecords=(List<ProductBean>)ois.readObject();
			for(ProductBean pb:addRecords)
			{
				if(pb.getPno()==pno)
				{
					System.out.println(pb);
					break;
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(oos!=null)
			{
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public void UpdateProduct(int pno) {
		// TODO Auto-generated method stub
		addRecords=new ArrayList<ProductBean>();
		try {
			fis=new FileInputStream(orginal);
			ois=new ObjectInputStream(fis);
			addRecords=(List<ProductBean>)ois.readObject();
			for(ProductBean pb:addRecords)
			{
				if(pb.getPno()==pno)
				{
					System.out.println("which record you want to update 1)Name 2)Quantity 3)Weight 4)Price");
					System.out.println("enter your choice");
					int choice=sc.nextInt();
					switch(choice)
					{
					case 1:
						System.out.println("enter updated product name");
						String pname=sc.next();
						pb.setPname(pname);
						break;
					case 2:
						System.out.println("enter updated quantity");
						int pquantity=sc.nextInt();
						pb.setPquantity(pquantity);
						break;
					case 3:
						System.out.println("enter updated weight");
						double pweight=sc.nextDouble();
						pb.setPweight(pweight);
						break;
					case 4:
						System.out.println("enter updated price");
						double pprice=sc.nextDouble();
						pb.setPprice(pprice);
						break;
						default:
							System.out.println("enter from 1 to 4");
					}
					tempRecords.add(pb);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fos=new FileOutputStream(orginal,true);
			oos=new ObjectOutputStream(fos);
			oos.writeObject(addRecords);
			oos.flush();
			orginal.delete();
			temp.renameTo(orginal);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(oos!=null)
			{
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		

	}

	@Override
	public void DeleteProduct(int pno) {
		// TODO Auto-generated method stub
		addRecords=new ArrayList<ProductBean>();
		ProductBean pb=null;
		
		try {
			fis=new FileInputStream(orginal);
			ois=new ObjectInputStream(fis);
			addRecords=(List<ProductBean>)ois.readObject();
			Iterator<ProductBean>pb1=addRecords.iterator();
			while(pb1.hasNext())
			{
				pb=pb1.next();
				{
					if(pb.getPno()==pno)
					{
					}
					else
					{
						tempRecords.add(pb);
					
					}
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(oos!=null)
			{
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		

	}

}
