package com.leon.demo.enum_;

public enum IdentifyType {
    IDCARD("1"), //身份证
    PASSPORT("2"); //护照
    private IdentifyType(String code){
        this.code = code;
    }
    private String code;
    public String code() {
        return code;
    }
}
