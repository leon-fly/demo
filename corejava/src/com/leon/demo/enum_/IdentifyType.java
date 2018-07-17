package com.leon.demo.enum_;

public enum IdentifyType {
    IDENTIFY_TYPE("1"), //身份证
    PASSPORT("2"); //护照
    private IdentifyType(String code){
        this.code = code;
    }
    private String code;
    public String getCode() {
        return code;
    }
}
