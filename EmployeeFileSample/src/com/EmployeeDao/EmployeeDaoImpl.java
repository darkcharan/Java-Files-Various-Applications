package com.EmployeeDao;

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

import com.EmployeeBean.EmployeeBean;

public class EmployeeDaoImpl implements EmployeeDao {
	Scanner sc=new Scanner(System.in);
	
	List<EmployeeBean>TempRecords=new ArrayList<EmployeeBean>();
	List<EmployeeBean>addRecords=null;
	EmployeeBean emp=null;
	
	FileOutputStream fos=null;
	ObjectOutputStream oos=null;
	FileInputStream fis=null;
	ObjectInputStream ois=null;
	
	File orginalFile=new File("orginalFile.txt");
	File tempFile=new File("TempFile.txt");

	@Override
	public void addEmployee() {
		// TODO Auto-generated method stub
		addRecords=new ArrayList<EmployeeBean>();
		int k=1;
		while(k==1)
		{
		System.out.println("enter employee no");
		int eno=sc.nextInt();
		System.out.println("enter employee name");
		String ename=sc.next();
		System.out.println("enter employee address");
		String eaddr=sc.next();
		System.out.println("enter employee salary");
		double esalr=sc.nextDouble();
		emp=new EmployeeBean(eno,ename,eaddr,esalr);
		addRecords.add(emp);
		System.out.println("do you want to add record 1)Yes 2)No");
		k=sc.nextInt();
		}
		try {
			fos=new FileOutputStream(orginalFile,true);
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
	public List<EmployeeBean> viewEmployee() {
		// TODO Auto-generated method stub
		List<EmployeeBean>viewRecords=null;
		try {
			fis=new FileInputStream(orginalFile);
			ois=new ObjectInputStream(fis);
			viewRecords=(List<EmployeeBean>)ois.readObject();
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
		return viewRecords;
	}

	@Override
	public void viewSpecificEmployee(int eno) {
		// TODO Auto-generated method stub
		addRecords=new ArrayList<EmployeeBean>();
		try {
			fis=new FileInputStream(orginalFile);
			ois=new ObjectInputStream(fis);
			addRecords=(List<EmployeeBean>)ois.readObject();
			for(EmployeeBean emp:addRecords)
			{
				if(emp.getEno()==eno)
				{
					System.out.println(emp);
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
		
		System.out.println("updated sucessfully");
	}

	@Override
	public void UpdateEmployee(int eno) {
		// TODO Auto-generated method stub
		addRecords=new ArrayList<EmployeeBean>();
		try {
			fis=new FileInputStream(orginalFile);
			ois=new ObjectInputStream(fis);
			addRecords=(List<EmployeeBean>)ois.readObject();
			for(EmployeeBean emp:addRecords)
			{
				if(emp.getEno()==eno)
				{
					System.out.println("which record you want to update 1)name 2)address 3)salary");
					int choice=sc.nextInt();
					switch(choice)
					{
					case 1:
						System.out.println("enter updated employee name");
						String ename=sc.next();
						emp.setEname(ename);
						break;
					case 2:
						System.out.println("enter updated address");
						String eaddr=sc.next();
						emp.setEaddr(eaddr);
						break;
					case 3:
						System.out.println("enter updated salary");
						double esalr=sc.nextDouble();
						break;
					}
					TempRecords.add(emp);
				}
			fos=new FileOutputStream(orginalFile,true);
			oos=new ObjectOutputStream(fos);
			oos.writeObject(TempRecords);
			oos.flush();
			orginalFile.delete();
			tempFile.renameTo(orginalFile);
					
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
		System.out.println("deleted sucessfully");

	}

	@Override
	public void DeleteEmployee(int eno) {
		// TODO Auto-generated method stub
		addRecords=new ArrayList<EmployeeBean>();
		EmployeeBean emp=null;
		try {
			fis=new FileInputStream(orginalFile);
			ois=new ObjectInputStream(fis);
		    addRecords=(List<EmployeeBean>)ois.readObject();
		    Iterator<EmployeeBean>emp1=addRecords.iterator();
		    while(emp1.hasNext())
		    {
		      emp=emp1.next();
		      if(emp.getEno()==eno)
		      {
		      }
		      else
		      {
		    	  TempRecords.add(emp);  
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
			fos=new FileOutputStream(orginalFile,true);
			oos=new ObjectOutputStream(fos);
			oos.writeObject(addRecords);
			oos.flush();
			orginalFile.delete();
			tempFile.renameTo(orginalFile);
			
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
		System.out.println("deleted sucessfully");

	}

}
