package com.javaee.gms_ex.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaee.gms_ex.po.Student;
import com.javaee.gms_ex.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    public StudentService studentService;

    @RequestMapping("/student_list")
    public String studentList(Model model, @RequestParam(defaultValue = "1") int pageNum){
        PageHelper.startPage(pageNum, 3);
        List<Student> students = studentService.findStudents();
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        model.addAttribute("pageInfo", pageInfo);
        return "student/studentList";
    }
    @RequestMapping("/to_add_student")
    public String toAddStudent(Model model){
        model.addAttribute("studentOper", "0");
        return "student/add_student";
    }
    @RequestMapping("/add_student")
    public String addStudent(Student student, Model model){
        studentService.addStudent(student);
        return "redirect:/student_list";
    }
    @RequestMapping("/to_edit_student")
    public String toEditStudent(String sno, Model model){
        Student student = studentService.findStudent(sno);
        model.addAttribute("student", student);
        model.addAttribute("studentOper", "1");
        return "student/add_student";
    }
    @RequestMapping("/edit_student")
    public String editStudent(Student student, Model model){
        studentService.updateStudent(student);
        return "redirect:/student_list";
    }
    @RequestMapping("/delete_student")
    @ResponseBody
    public String deleteStudent(String sno){
        studentService.deleteStudent(sno);
        return "SUCCESS";
    }
}