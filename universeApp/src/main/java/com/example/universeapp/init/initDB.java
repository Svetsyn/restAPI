package com.example.universeapp.init;

import com.example.universeapp.service.CourseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class initDB implements CommandLineRunner {

    private final CourseService courseService;

    public initDB(CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    public void run(String... args) throws Exception {
        courseService.initCourse();
    }
}
