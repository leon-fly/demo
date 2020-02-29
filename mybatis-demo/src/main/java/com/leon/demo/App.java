package com.leon.demo;

import com.leon.demo.mybatis.mapper.TeacherMapper;
import com.leon.demo.mybatis.po.TeacherPO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        TeacherPO teacherPO = sqlSession.getMapper(TeacherMapper.class).selectTeacher("001");

        System.out.println(teacherPO==null? "teacher is not exist" : teacherPO.getName());
    }
}
