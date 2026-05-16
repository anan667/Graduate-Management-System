package com.javaee.gms_ex.service;

import com.javaee.gms_ex.po.Student;

import java.util.List;

public interface StudentService {
    List<Student> findStudents();
    Student findStudent(String sno);
    int addStudent(Student student);
    int deleteStudent(String sno);
    int updateStudent(Student student);
}