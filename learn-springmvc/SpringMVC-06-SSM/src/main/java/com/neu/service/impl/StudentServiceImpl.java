package com.neu.service.impl;

import com.neu.dao.StudentDao;
import com.neu.domain.Student;
import com.neu.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    @Override
    public int addStudent(Student student) {
        int addColumnNum=studentDao.insertStudent(student);
        return addColumnNum;
    }

    @Override
    public List<Student> queryStudents() {
        List<Student> students=studentDao.selectStudents();
        return students;
    }
}
