package com.example.universeapp.service.impl;

import com.example.universeapp.model.Course;
import com.example.universeapp.model.enums.CourseType;
import com.example.universeapp.repository.CourseRepository;
import com.example.universeapp.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.universeapp.constant.CourseDescriptions.*;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void initCourse() {
            if(courseRepository.count() == 0){

                Course main = new Course();
                main.setName("Main_I");
                main.setDescription(MAIN_DESCRIPTION);
                main.setType(CourseType.MAIN);

                Course secondary = new Course();
                secondary.setName("Secondary_I");
                secondary.setDescription(SECONDARY_DESCRIPTION);
                secondary.setType(CourseType.SECONDARY);

                courseRepository.saveAll(List.of(main,secondary));
            }

    }

    @Override
    public List<Course> findByCourseType(CourseType courseType) {
        return courseRepository.findAllByType(courseType);
    }
}
