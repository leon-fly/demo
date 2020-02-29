package com.leon.demo.mybatis.po;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2019/12/16
 */
@Setter
@Getter
public class StudentPO {
    private String sid;
    private String password;
    private String name;
    private String email;
    private Date birthday;
    private String classId;
}
