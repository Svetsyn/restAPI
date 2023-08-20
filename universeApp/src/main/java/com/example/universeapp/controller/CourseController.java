package com.example.universeapp.controller;

import com.example.universeapp.model.Course;
import com.example.universeapp.model.enums.CourseType;
import com.example.universeapp.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("api/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/find")
    public ResponseEntity<List<Course>> findAll(
            @RequestParam(value = "courseType", required = false) CourseType courseType
    ){
        if (courseType != null) {
            return ResponseEntity.ok(courseService.findByCourseType(courseType));
        }
        return ResponseEntity.ok().body(null);
    }
}
