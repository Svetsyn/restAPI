package com.example.universeapp.service;

import com.example.universeapp.model.dto.StudentDTO;
import com.example.universeapp.model.dto.StudentDeleteDTO;
import com.example.universeapp.model.dto.StudentUpdateDTO;
import com.example.universeapp.model.entities.Student;
import com.example.universeapp.model.enums.CourseType;

import java.util.List;

public interface StudentService {

    Student createStudent(StudentDTO studentDto);

    Student updateStudent(StudentUpdateDTO studentUpdateDTO);

    void deleteStudent(StudentDeleteDTO studentDeleteDTO);

    List<Student> getAllStudents();

    List<Student> findAll();

    List<Student> findByCourses(CourseType courseType);

    List<Student> findByStudentGroup(Integer group);

}
