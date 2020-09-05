package com.neu.service.impl;

import com.neu.dao.StudentDao;
import com.neu.domain.Student;
import com.neu.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    //Dao对象才能调用方法
    private StudentDao studentDao;
    //使用set注入才能赋值
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public int addStudent(Student student) {
        // 返回添加行数
        int addColumnNum = studentDao.insertStudents(student);
        return addColumnNum;
    }

    @Override
    public List<Student> queryStudents() {
        List<Student> students = studentDao.selectStudents();
        return students;
    }
}
