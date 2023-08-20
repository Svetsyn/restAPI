package com.example.universeapp.model.dto;

import com.example.universeapp.model.enums.CourseType;

import javax.validation.constraints.*;

public class StudentUpdateDTO {

    private Long id;
    private String name;
    private Integer age;
    private Integer studentGroup;
    private CourseType courseType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @NotEmpty
    @Size(min = 1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Min(value = 1,message = "Age can not be '0'!")
    @Positive(message = "The value must be positive!")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Min(value = 1,message = "Group can not be '0'!")
    @Positive(message = "The value must be positive!")
    public Integer getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(Integer studentGroup) {
        this.studentGroup = studentGroup;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }
}
