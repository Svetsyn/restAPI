package com.example.universeapp.service;

import com.example.universeapp.model.Course;
import com.example.universeapp.model.enums.CourseType;

import java.util.List;

public interface CourseService {

    void initCourse();

    List<Course> findByCourseType(CourseType courseType);
}
