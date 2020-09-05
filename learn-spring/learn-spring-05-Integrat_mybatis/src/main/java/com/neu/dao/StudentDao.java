package com.neu.dao;

import com.neu.domain.Student;

import java.util.List;

public interface StudentDao {
    List<Student> selectStudents();
    int insertStudents(Student student);
}
