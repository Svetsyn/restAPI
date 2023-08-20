package com.example.universeapp.model.entities;

import com.example.universeapp.model.Course;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "teachers")
public class Teacher extends BaseEntity {

    private String name;
    private Integer age;
    private Integer teacherGroup;
    private Course course;

    public Teacher() {
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "teacher_group")
    public Integer getTeacherGroup() {
        return teacherGroup;
    }

    public void setTeacherGroup(Integer teacherGroup) {
        this.teacherGroup = teacherGroup;
    }

    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @ManyToOne
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
