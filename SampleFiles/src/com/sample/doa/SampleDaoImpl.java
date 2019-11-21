package com.sample.doa;

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

import com.sample.bean.SampleBean;

public class SampleDaoImpl implements SampleDao {
	
	Scanner sc=new Scanner(System.in);
	List<SampleBean>tempRecords=new ArrayList<SampleBean>();
	List<SampleBean>addRecords=null;
	
	FileOutputStream fos=null;
	ObjectOutputStream oos=null;
	FileInputStream fis=null;
	ObjectInputStream ois=null;
	
	File orginalfile=new File("orginal.txt");
	File tempfile=new File("temp.txt");
	
	SampleBean sb=null;
	

	@Override
	public void AddSample() {
		// TODO Auto-generated method stub
		addRecords=new ArrayList<SampleBean>();
		int k=1;
		while(k==1)
		{
		System.out.println("enter sample number");
		int sno=sc.nextInt();
		System.out.println("enter sample name");
		String sname=sc.next();
		System.out.println("enter sample address");
		String saddress=sc.next();
		System.out.println("enter sample amount");
		double samount=sc.nextDouble();
		sb=new SampleBean(sno,sname,saddress,samount);
		addRecords.add(sb);
		System.out.println("do u want to add record 1)Yes 2)No");
		k=sc.nextInt();
		}
		
		try {
			fos=new FileOutputStream(orginalfile,true);
			oos=new ObjectOutputStream(oos);
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
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		

	}

	@Override
	public List<SampleBean> ViewSample() {
		// TODO Auto-generated method stub
		List<SampleBean>addRecords=null;
		try {
			fis=new FileInputStream(orginalfile);
			ois=new ObjectInputStream(fis);
			addRecords=(List<SampleBean>)ois.readObject();
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
	public void ViewSpecificSample(int sno) {
		// TODO Auto-generated method stub
		addRecords=new ArrayList<SampleBean>();
		try {
			fis=new FileInputStream(orginalfile);
			ois=new ObjectInputStream(fis);
			addRecords=(List<SampleBean>)ois.readObject();
			for(SampleBean sb:addRecords)
			{
				if(sb.getSno()==sno)
				{
					System.out.println(sb);
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
	public void UpdateSample(int sno) {
		// TODO Auto-generated method stub
		addRecords=new ArrayList<SampleBean>();
		try {
			fis=new FileInputStream(orginalfile);
			ois=new ObjectInputStream(fis);
			addRecords=(List<SampleBean>)ois.readObject();
			for(SampleBean sb:addRecords)
			{
				if(sb.getSno()==sno)
				{
					System.out.println("which record u want to update )1Name 2)Address 3)Amount");
					System.out.println("enter your choice");
					int choice=sc.nextInt();
					switch(choice)
					{
					case 1:
						System.out.println("enter updated sample name");
						String sname=sc.next();
						sb.setSname(sname);
						break;
					case 2:
						System.out.println("enter updated sample address");
						String saddress=sc.next();
						sb.setSaddress(saddress);
						break;
					case 3:
						System.out.println("enter updated sample amount");
					    double samount=sc.nextDouble();
					    sb.setSamount(samount);
						break;
					}
					tempRecords.add(sb);

				}
				fos=new FileOutputStream(orginalfile);
				oos=new ObjectOutputStream(fos);
				oos.writeObject(addRecords);
				oos.flush();
				orginalfile.delete();
				tempfile.renameTo(orginalfile);
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
	public void DeleteSample(int sno) {
		// TODO Auto-generated method stub
		addRecords=new ArrayList<SampleBean>();
		SampleBean sb=null;
		try {
			fis=new FileInputStream(orginalfile);
			ois=new ObjectInputStream(fis);
			addRecords=(List<SampleBean>)ois.readObject();
			Iterator<SampleBean>sb1=addRecords.iterator();
			while(sb1.hasNext())
			{
				sb=sb1.next();
				if(sb.getSno()==sno)
				{
					System.out.println(sno);
				}
				else
				{
					tempRecords.add(sb);
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

}
