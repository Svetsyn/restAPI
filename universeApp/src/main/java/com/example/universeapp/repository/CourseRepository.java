package com.example.universeapp.repository;

import com.example.universeapp.model.Course;
import com.example.universeapp.model.enums.CourseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    Course findByType(CourseType type);

    List<Course> findAllByType(CourseType type);
}
