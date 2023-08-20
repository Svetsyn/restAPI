package com.example.universeapp.repository;

import com.example.universeapp.model.entities.Student;
import com.example.universeapp.model.enums.CourseType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    Page<Student> findAll(Pageable pageable);

    List<Student> findAllByCourse_Type(CourseType courseType);

    List<Student> findAllByStudentGroup(Integer group);
}
