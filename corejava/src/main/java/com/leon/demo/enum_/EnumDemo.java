package com.leon.demo.enum_;

/**
 * 枚举作为一种数据类型可以用于约束传入参数
 */
public class EnumDemo {
	public static void main(String[] args) {
		System.out.println(IdentifyType.IDCARD.code());
		System.out.println(IdentifyType.IDCARD);
		System.out.println("ID_CARD".equals(IdentifyType.IDCARD.toString()));
		printIdentifyType(IdentifyType.IDCARD);
	}

	public static void printIdentifyType(IdentifyType idType){
		System.out.println("params : " + idType);
	}
}




