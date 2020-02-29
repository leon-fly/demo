package com.leon.demo.mybatis.mapper;

import com.leon.demo.mybatis.po.TeacherPO;
import org.apache.ibatis.annotations.Select;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2019/12/20
 */
public interface TeacherMapper {
    @Select("select * from teacher where id=#{id}")
    TeacherPO selectTeacher(String tid);
}
