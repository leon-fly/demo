package com.leon.demo.compare.clazz;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2018/11/6
 */
public class ClassAndInstanceCompare {
    public static void main(String[] args) {
        testIsInstance();

        System.out.println("=======================");

        testInstanceOf();

        System.out.println("=======================");

        testIsAssignableFrom();

    }

    public static void testIsInstance() {
        Student student = createStudent();

        System.out.println("Student.class.isInstance(student):" + (Student.class.isInstance(student)));
        System.out.println("Person.class.isInstance(student):" + (Person.class.isInstance(student)));
        System.out.println("Bean.class.isInstance(student):" + (Bean.class.isInstance(student)));
        System.out.println("Object.class.isInstance(student):" + (Object.class.isInstance(student)));
        System.out.println("Object.class.isInstance(student):" + (String.class.isInstance(student)));

    }

    public static void testInstanceOf() {
        Object obj = createStudent();
        System.out.println("obj instanceof Student:" + (obj instanceof Student));
        System.out.println("obj instanceof Person:" + (obj instanceof Person));
        System.out.println("obj instanceof Bean:" + (obj instanceof Bean));
        System.out.println("obj instanceof Bean:" + (obj instanceof Object));
        System.out.println("obj instanceof Bean:" + (obj instanceof String));
    }

    public static void testIsAssignableFrom() {
        Student student = createStudent();

        System.out.println("Student.class.isAssignableFrom(Student.class):" + (Student.class.isAssignableFrom(Student.class)));
        System.out.println("Person.class.isAssignableFrom(Student.class):" + (Person.class.isAssignableFrom(Student.class)));
        System.out.println("Bean.class.isAssignableFrom(Student.class):" + (Bean.class.isAssignableFrom(Student.class)));
        System.out.println("Object.class.isAssignableFrom(Student.class):" + (Object.class.isAssignableFrom(Student.class)));
        System.out.println("String.class.isAssignableFrom(String.class):" + (String.class.isAssignableFrom(Student.class)));

    }

    public static Student createStudent() {
        Student student = new Student();
        student.setName("林蛋大");
        student.setClassId("1");
        return student;
    }

}

