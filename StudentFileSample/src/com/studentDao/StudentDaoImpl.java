package com.studentDao;

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

import com.studentbean.StudentBean;

public class StudentDaoImpl implements StudentDao {
	Scanner sc=new Scanner(System.in);
	
	List<StudentBean>tempRecords=new ArrayList<StudentBean>();
	List<StudentBean>addRecords=null;
    StudentBean st=null;
    
    File orginal=new File("orginal.txt");
    File temp=new File("temp.txt");
    
    FileOutputStream fos=null;
    ObjectOutputStream oos=null;
    FileInputStream fis=null;
    ObjectInputStream ois=null;

	@Override
	public void AddStudent() {
		// TODO Auto-generated method stub
		addRecords=new ArrayList<StudentBean>();
		int k=1;
		while(k==1)
		{
		System.out.println("enter student number");
		int sno=sc.nextInt();
		System.out.println("enter student name");
		String sname=sc.next();
		System.out.println("enter student address");
		String saddr=sc.next();
		st=new StudentBean(sno,sname,saddr);
		addRecords.add(st);
		System.out.println("do you want to add record 1)Yes 2)No");
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
	public List<StudentBean> viewStudents() {
		// TODO Auto-generated method stub
		List<StudentBean>addRecords=null;
		
		try {
			fis=new FileInputStream(orginal);
			ois=new ObjectInputStream(fis);
			addRecords=(List<StudentBean>)ois.readObject();
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
	public void viewSpecificStudent(int sno) {
		// TODO Auto-generated method stub
		addRecords=new ArrayList<StudentBean>();
		
		try {
			fis=new FileInputStream(orginal);
			ois=new ObjectInputStream(fis);
			addRecords=(List<StudentBean>)ois.readObject();
			for(StudentBean st:addRecords)
			{
				if(st.getSno()==sno)
				{
					System.out.println(st);
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
	public void UpdateStudent(int sno) {
		// TODO Auto-generated method stub
		addRecords=new ArrayList<StudentBean>();
		try {
			fis=new FileInputStream(orginal);
			ois=new ObjectInputStream(ois);
			addRecords=(List<StudentBean>)ois.readObject();
			for(StudentBean st:addRecords)
			{
				if(st.getSno()==sno)
				{
					System.out.println("which record you want to update 1)Name 2)address");
					int choice=sc.nextInt();
					switch(choice)
					{
					case 1:
						System.out.println("enter updated name");
						String sname=sc.next();
						st.setSname(sname);
						break;
					case 2:
						System.out.println("enter updated address");
						String saddr=sc.next();
						st.setSaddr(saddr);
						break;
						default:
							System.out.println("enter your choice from 1 to 2");
					}
					tempRecords.add(st);
				}
				fos=new FileOutputStream(orginal,true);
				oos=new ObjectOutputStream(fos);
				oos.writeObject(tempRecords);
			    oos.flush();
			    orginal.delete();
			    temp.renameTo(orginal);
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
	public void DeleteStudent(int sno) {
		// TODO Auto-generated method stub
		addRecords=new ArrayList<StudentBean>();
		StudentBean stu=null;
		try {
			fis=new FileInputStream(orginal);
			ois=new ObjectInputStream(ois);
			addRecords=(List<StudentBean>)ois.readObject();
			Iterator<StudentBean>stu1=addRecords.iterator();
			while(stu1.hasNext())
			{
				stu=stu1.next();
				if(stu.getSno()==sno)
				{
				}
				else
				{
					tempRecords.add(stu);
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


}
