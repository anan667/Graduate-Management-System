package com.javaee.gms_ex.service;

import com.javaee.gms_ex.po.Course;

import java.util.List;

public interface CourseService {
    List<Course> findCourses();
    Course findCourse(Integer cno);
    int addCourse(Course course);
    int deleteCourse(Integer cno);
    int updateCourse(Course course);
}