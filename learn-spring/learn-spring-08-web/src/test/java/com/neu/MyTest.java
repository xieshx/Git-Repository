package com.neu;

import com.neu.domain.Student;
import com.neu.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {

    @Test
    public void testServiceInsert(){
        String config= "spring.xml";
        ApplicationContext ac=new  ClassPathXmlApplicationContext(config);
        StudentService studentService = (StudentService) ac.getBean("studentService");
        // spring和mybatis整合在一起事务是自动提交的
        Student student = new Student(1015,"马超",17,"13088997766");
        studentService.addStudent(student);
    }

    @Test
    public void testServiceSelect(){
        String config= "spring.xml";
        ApplicationContext ac=new  ClassPathXmlApplicationContext(config);
        StudentService studentService = (StudentService) ac.getBean("studentService");
        List<Student> students = studentService.queryStudents();
        for (Student student:students){
            System.out.println(student);
        }
    }
}
