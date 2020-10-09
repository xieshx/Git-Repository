package com.neu;

import com.neu.dao.StudentDao;
import com.neu.domain.Student;
import com.neu.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {

    @Test
    public void test01(){

        String config="applicationContext.xml";
        ApplicationContext ac=new  ClassPathXmlApplicationContext(config);
        String[] names = ac.getBeanDefinitionNames();
        for (String name:names){
            System.out.println("对象名称："+name+"|"+ac.getBean(name));
        }
    }

    @Test
    public void testDaoInsert(){
        String config="applicationContext.xml";
        ApplicationContext ac=new  ClassPathXmlApplicationContext(config);
        StudentDao studentDao = (StudentDao) ac.getBean("studentDao");
        Student student = new Student(1015,"马超",17,"13088997766");
        studentDao.insertStudents(student);

    }

    @Test
    public void testServiceInsert(){

        String config="applicationContext.xml";
        ApplicationContext ac=new  ClassPathXmlApplicationContext(config);
        StudentService studentService = (StudentService) ac.getBean("studentService");
        // spring和mybatis整合在一起事务是自动提交的
        Student student = new Student(1015,"马超",17,"13088997766");

    }

    @Test
    public void testServiceSelect(){
        String config="applicationContext.xml";
        ApplicationContext ac=new  ClassPathXmlApplicationContext(config);
        StudentService studentService = (StudentService) ac.getBean("studentService");
        List<Student> students = studentService.queryStudents();
        for (Student student:students){
            System.out.println(student);
        }
    }


}
