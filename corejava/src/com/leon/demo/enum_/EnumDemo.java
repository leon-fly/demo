package com.leon.demo.enum_;

public class EnumDemo {
	public static void main(String[] args) {
		System.out.println(IdType.ID_CARD.code());
		System.out.println(IdType.ID_CARD);
		System.out.println("ID_CARD".equals(IdType.ID_CARD.toString()));
	}
}

enum IdType {
	ID_CARD(1), // 身份证
	PASSPORT(2), // 护照
	MILITARY_ID(3); // 军官证
	private int code;

	private IdType(int code) {
		this.code = code;
	}

	public int code() {
		return code;
	}
}