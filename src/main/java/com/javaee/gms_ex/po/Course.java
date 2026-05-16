package com.javaee.gms_ex.po;

import lombok.Data;

@Data
public class Course {
    private Integer cno;      // 课程号，主键
    private String cname;     // 课程名
    private Integer period;   // 学时
}