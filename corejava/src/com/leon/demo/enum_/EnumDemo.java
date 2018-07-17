package com.leon.demo.enum_;

/**
 * 枚举作为一种数据类型可以用于约束传入参数
 */
public class EnumDemo {
    public static void main(String[] args) {
        printIdentifyType(IdentifyType.IDENTIFY_TYPE);
    }

    public static void printIdentifyType(IdentifyType idType){
        System.out.println("I GOT "+idType+":"+idType.getCode());
    }
}
