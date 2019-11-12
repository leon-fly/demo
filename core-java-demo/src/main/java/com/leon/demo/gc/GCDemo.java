package com.leon.demo.gc;
import com.leon.bean.People;

import java.util.ArrayList;
import java.util.List;

public class GCDemo {
	public static ArrayList<People> array = new ArrayList<>();
	public static void main(String[] args) throws InterruptedException {
		
		for (int i = 0; i < 1000000; i++) {
			People p = new People();
			p.setId(i+"");
			p.setName("LEON"+i);
			p.setSex("M");
			array.add(p);
			System.out.println(Thread.currentThread().getName()+"装入第"+i+"个people");
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*int threadNum = 5;
		for (int i=0;i<threadNum;i++){
			Mythread mt = new Mythread();
			mt.setName("线程"+i);
			mt.start();
			System.out.println("启动线程"+i);
		}*/
	}
}

class Mythread extends Thread{
	@Override
	public void run() {
		List<People> list = new ArrayList<People>();
		for (int i = 0; i < 1000000; i++) {
			People p = new People();
			p.setId(i+"");
			p.setName("LEON"+i);
			p.setSex("M");
			list.add(p);
			System.out.println(Thread.currentThread().getName()+"装入第"+i+"个people");
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("list添加完毕，线程休眠");
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list.size());
		for(People p : list){
			System.out.println("读："+p.getName());
		}
		super.run();
	}
}