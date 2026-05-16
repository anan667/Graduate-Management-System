package com.javaee.gms_ex.mapper;

import com.javaee.gms_ex.po.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {
    List<Course> findCourses();
    Course findCourse(Integer cno);
    int addCourse(Course course);
    int deleteCourse(Integer cno);
    int updateCourse(Course course);
}
