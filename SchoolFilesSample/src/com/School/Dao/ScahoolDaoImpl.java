package com.School.Dao;

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

import com.School.baen.SchoolBean;

public class ScahoolDaoImpl implements SchoolDao {
	Scanner sc=new Scanner(System.in);
	List<SchoolBean>tempRecords=new ArrayList<SchoolBean>();
	List<SchoolBean>addRecords=null;
	SchoolBean sb=null;
	
	FileOutputStream fos=null;
	ObjectOutputStream oos=null;
	FileInputStream fis=null;
	ObjectInputStream ois=null;
	
	File orginalfile=new File("orginal.txt");
	File tempfile=new File("temp.txt");

	@Override
	public void AddSchool() {
		// TODO Auto-generated method stub
		addRecords=new ArrayList<SchoolBean>();
		int k=1;
		while(k==1)
		{
		System.out.println("enter school number");
		int sno=sc.nextInt();
		System.out.println("enter school name");
		String sname=sc.next();
		System.out.println("enter school address");
		String saddr=sc.next();
		System.out.println("enter school fees");
		double sfees=sc.nextDouble();
		sb=new SchoolBean(sno,sname,saddr,sfees);
		addRecords.add(sb);
		System.out.println("do u want to add records 1)Yes 2)No");
		k=sc.nextInt();
		}
		try {
			fos=new FileOutputStream(orginalfile);
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
		System.out.println("record is inserted sucessfully");
		

	}

	@Override
	public List<SchoolBean> viewSchool() {
		// TODO Auto-generated method stub
		List<SchoolBean>addRecords=null;
		try {
			fis=new FileInputStream(orginalfile);
			ois=new ObjectInputStream(fis);
			addRecords=(List<SchoolBean>)ois.readObject();
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
			if(ois!=null)
			{
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return addRecords;
	}

	@Override
	public void ViewSpecificSchool(int sno) {
		// TODO Auto-generated method stub
		addRecords=new ArrayList<SchoolBean>();
		try {
			fis=new FileInputStream(orginalfile);
			ois=new ObjectInputStream(fis);
			addRecords=(List<SchoolBean>)ois.readObject();
			for(SchoolBean bean:addRecords)
			{
				if(bean.getSno()==sno)
				{
					System.out.println(bean);
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
			if(ois!=null)
			{
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		

	}

	@Override
	public void UpdateSchool(int sno) {
		// TODO Auto-generated method stub
		addRecords=new ArrayList<SchoolBean>();
		try {
			fis=new FileInputStream(orginalfile);
			ois=new ObjectInputStream(fis);
			addRecords=(List<SchoolBean>)ois.readObject();
			for(SchoolBean bean:addRecords)
			{
				if(bean.getSno()==sno)
				{
					System.out.println("which record u want to update 1)Name 2)Address 3)Fees");
					int choice=sc.nextInt();
					switch(choice)
					{
					case 1:
						System.out.println("enter updated name");
						String sname=sc.next();
						bean.setSname(sname);
						break;
					case 2:
						System.out.println("enter updated address");
						String saddr=sc.next();
						bean.setSaddr(saddr);
						break;
					case 3:
						System.out.println("enter updated fees");
						double sfees=sc.nextDouble();
						bean.setSfees(sfees);
						break;
						default:
							System.out.println("enter your choice from 1 to 3");
					}
					tempRecords.add(bean);
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
			fos=new FileOutputStream(orginalfile);
			oos=new ObjectOutputStream(fos);
			oos.writeObject(tempRecords);
			orginalfile.delete();
			tempfile.renameTo(orginalfile);
			
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(ois!=null)
			{
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("record is updated sucessfully");
		

	}

	@Override
	public void DeleteSchool(int sno) {
		// TODO Auto-generated method stub
		addRecords=new ArrayList<SchoolBean>();
		SchoolBean sb=null;
		try {
			fis=new FileInputStream(orginalfile);
			ois=new ObjectInputStream(fis);
			addRecords=(List<SchoolBean>)ois.readObject();
			Iterator<SchoolBean>it=addRecords.iterator();
			while(it.hasNext())
			{
				sb=it.next();
				
					if(sb.getSno()==sno)
					{
					addRecords.remove(sb);
					break;
					}
					
					}
				
			
			fos=new FileOutputStream(orginalfile);
			oos=new ObjectOutputStream(fos);
			oos.writeObject(addRecords);
			oos.flush();
			orginalfile.delete();
			tempfile.renameTo(orginalfile);
			
			
			
			
			
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
			if(ois!=null)
			{
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("record is deleted sucessfully");
		
		}
}
