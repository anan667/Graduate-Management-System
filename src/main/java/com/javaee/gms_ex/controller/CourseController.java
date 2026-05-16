package com.javaee.gms_ex.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaee.gms_ex.po.Course;
import com.javaee.gms_ex.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/course_list")
    public String courseList(Model model, @RequestParam(defaultValue = "1") int pageNum) {
        PageHelper.startPage(pageNum, 3);
        List<Course> courses = courseService.findCourses();
        PageInfo<Course> pageInfo = new PageInfo<>(courses);
        model.addAttribute("pageInfo", pageInfo);
        return "course/courselist";
    }

    @RequestMapping("/to_add_course")
    public String toAddCourse(Model model) {
        model.addAttribute("courseOper", "0");
        return "course/add_course";
    }

    @RequestMapping("/add_course")
    public String addCourse(Course course, Model model) {
        courseService.addCourse(course);
        return "redirect:/course_list";
    }

    @RequestMapping("/to_edit_course")
    public String toEditCourse(Integer cno, Model model) {
        Course course = courseService.findCourse(cno);
        model.addAttribute("course", course);
        model.addAttribute("courseOper", "1");
        return "course/add_course";
    }

    @RequestMapping("/edit_course")
    public String editCourse(Course course, Model model) {
        courseService.updateCourse(course);
        return "redirect:/course_list";
    }

    @RequestMapping("/delete_course")
    @ResponseBody
    public String deleteCourse(Integer cno) {
        courseService.deleteCourse(cno);
        return "SUCCESS";
    }
}