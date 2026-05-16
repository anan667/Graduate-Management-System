package com.javaee.gms_ex.service.impl;

import com.javaee.gms_ex.mapper.StudentMapper;
import com.javaee.gms_ex.po.Student;
import com.javaee.gms_ex.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public List<Student> findStudents() {
        return studentMapper.findStudents();
    }

    @Override
    public Student findStudent(String sno) {
        return studentMapper.findStudent(sno);
    }

    @Override
    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

    @Override
    public int deleteStudent(String sno) {
        return studentMapper.deleteStudent(sno);
    }

    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }
}