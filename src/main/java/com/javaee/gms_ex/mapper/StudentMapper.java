package com.javaee.gms_ex.mapper;

import com.javaee.gms_ex.po.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<Student> findStudents();
    Student findStudent(String sno);
    int addStudent(Student student);
    int deleteStudent(String sno);
    int updateStudent(Student student);
}