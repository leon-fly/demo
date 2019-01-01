package com.leon.demo.io;
import com.leon.testbean.People;

import java.io.*;
public class SerializableTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File("student.txt");
		/*ObjectOutputStream os = null;
		try {
			People p = new People("leon","M","1"); 
			os = new ObjectOutputStream(new FileOutputStream(file));
			os.writeObject(p);
			System.out.println("写入结束");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(os!=null)
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}*/
		
		ObjectInputStream oi = null;
		try {
			oi = new ObjectInputStream(new FileInputStream(file));
			People p = (People) oi.readObject();
			System.out.println(p.getName()+"=="+p.getSex());
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
		
		
		
		
		
		
	}
}


