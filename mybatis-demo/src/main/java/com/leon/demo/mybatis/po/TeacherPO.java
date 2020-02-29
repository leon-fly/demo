package com.leon.demo.mybatis.po;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2019/12/16
 */
@Getter
@Setter
public class TeacherPO {
    private long id;
    private String tid;
    private String name;
    private String sex;
    private Date birthday;
}
