package com.example.universeapp.service.impl;

import com.example.universeapp.model.Course;
import com.example.universeapp.model.dto.StudentDTO;
import com.example.universeapp.model.dto.StudentDeleteDTO;
import com.example.universeapp.model.dto.StudentUpdateDTO;
import com.example.universeapp.model.entities.Student;
import com.example.universeapp.model.enums.CourseType;
import com.example.universeapp.repository.CourseRepository;
import com.example.universeapp.repository.StudentRepository;
import com.example.universeapp.service.StudentService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    public StudentServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Student createStudent(StudentDTO studentDto) {
        Student student = new Student();
        Course course = courseRepository.findByType(studentDto.getCourseType());
        if(course == null){
            throw new ResourceNotFoundException("No such course type in DB");
        }
        student.setName(studentDto.getName());
        student.setAge(studentDto.getAge());
        student.setStudentGroup(studentDto.getStudentGroup());
        student.setCourse(course);
        studentRepository.save(student);
        return student;
    }

    @Override
    public Student updateStudent(StudentUpdateDTO studentUpdateDTO) {

        if (studentRepository.findById(studentUpdateDTO.getId()).isEmpty()) {
            throw new ResourceNotFoundException("No such student in DB");
        }

        Course course = courseRepository.findByType(studentUpdateDTO.getCourseType());
        if(course == null){
            throw new ResourceNotFoundException("No such course type in DB");
        }

        Student student = studentRepository.findById(studentUpdateDTO.getId()).get();
        student.setName(studentUpdateDTO.getName());
        student.setAge(studentUpdateDTO.getAge());
        student.setStudentGroup(studentUpdateDTO.getStudentGroup());
        student.setCourse(course);

        studentRepository.save(student);
        return student;
    }

    @Override
    public void deleteStudent(StudentDeleteDTO studentDeleteDTO) {
        if (studentRepository.findById(studentDeleteDTO.getId()).isEmpty()) {
            throw new ResourceNotFoundException("No such student in DB");
        }
        Student student = studentRepository.findById(studentDeleteDTO.getId()).get();

        studentRepository.delete(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findByCourses(CourseType courseType) {
        return studentRepository.findAllByCourse_Type(courseType);
    }

    @Override
    public List<Student> findByStudentGroup(Integer group) {
        return studentRepository.findAllByStudentGroup(group);
    }


}
