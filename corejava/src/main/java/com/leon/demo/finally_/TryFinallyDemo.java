package com.leon.demo.finally_;

public class TryFinallyDemo {
	public static void main(String[] args) throws InterruptedException {
		System.out.println(getNum(5));
		System.out.println(getNum2(5));
		StringBuffer sb = new StringBuffer("");
		System.out.println(test(sb));
	}
	public static int getNum(int a){
		try{
			++a;
			return a++;
		}finally{
			a++;
			System.out.println(a);
		}
	}

	@SuppressWarnings("finally")
	public static int getNum2(int a){
		try{
			++a;
		}finally{
			return a++;
		}
	}
	public static StringBuffer test(StringBuffer sb) throws InterruptedException{
		try{
			sb.append("try");
			return sb;
		}finally{
			Thread.sleep(10000);
			sb.append("finally");
		}
	}
	
}
