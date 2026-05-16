package com.javaee.gms_ex.service.impl;

import com.javaee.gms_ex.mapper.CourseMapper;
import com.javaee.gms_ex.po.Course;
import com.javaee.gms_ex.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> findCourses() {
        return courseMapper.findCourses();
    }

    @Override
    public Course findCourse(Integer cno) {
        return courseMapper.findCourse(cno);
    }

    @Override
    public int addCourse(Course course) {
        return courseMapper.addCourse(course);
    }

    @Override
    public int deleteCourse(Integer cno) {
        return courseMapper.deleteCourse(cno);
    }

    @Override
    public int updateCourse(Course course) {
        return courseMapper.updateCourse(course);
    }
}