package com.example.universeapp.service.impl;

import com.example.universeapp.model.Course;
import com.example.universeapp.model.dto.TeacherDTO;
import com.example.universeapp.model.dto.TeacherDeleteDTO;
import com.example.universeapp.model.dto.TeacherUpdateDTO;
import com.example.universeapp.model.entities.Teacher;
import com.example.universeapp.model.enums.CourseType;
import com.example.universeapp.repository.CourseRepository;
import com.example.universeapp.repository.TeacherRepository;
import com.example.universeapp.service.TeacherService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    public TeacherServiceImpl(TeacherRepository teacherRepository, CourseRepository courseRepository, ModelMapper modelMapper) {
        this.teacherRepository = teacherRepository;
        this.courseRepository = courseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Teacher createTeacher(TeacherDTO teacherDto) {
        Teacher teacher = new Teacher();

        Course course = courseRepository.findByType(teacherDto.getCourseType());
        if(course == null){
            throw new ResourceNotFoundException("No such course type in DB");
        }
        teacher.setName(teacherDto.getName());
        teacher.setAge(teacherDto.getAge());
        teacher.setTeacherGroup(teacherDto.getTeacherGroup());
        teacher.setCourse(course);


        teacherRepository.save(teacher);
        return teacher;
    }

    @Override
    public Teacher updateTeacher(TeacherUpdateDTO teacherUpdateDTO) {

        if(teacherRepository.findById(teacherUpdateDTO.getId()).isEmpty()){
            throw new ResourceNotFoundException("No such teacher in DB");
        }

        Course course = courseRepository.findByType(teacherUpdateDTO.getCourseType());
        if(course == null){
            throw new ResourceNotFoundException("No such course type in DB");
        }
        Teacher teacher = teacherRepository.findById(teacherUpdateDTO.getId()).get();
        teacher.setName(teacherUpdateDTO.getName());
        teacher.setAge(teacherUpdateDTO.getAge());
        teacher.setTeacherGroup(teacherUpdateDTO.getTeacherGroup());
        teacher.setCourse(course);

        teacherRepository.save(teacher);
        return teacher;
    }

    @Override
    public void deleteTeacher(TeacherDeleteDTO teacherDeleteDTO) {
        if(teacherRepository.findById(teacherDeleteDTO.getId()).isEmpty()){
            throw new ResourceNotFoundException("No such teacher in DB");
        }
        Teacher teacher = teacherRepository.findById(teacherDeleteDTO.getId()).get();

        teacherRepository.delete(teacher);
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }


}
