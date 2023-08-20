package com.example.universeapp.service;

import com.example.universeapp.model.dto.TeacherDTO;
import com.example.universeapp.model.dto.TeacherDeleteDTO;
import com.example.universeapp.model.dto.TeacherUpdateDTO;
import com.example.universeapp.model.entities.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher createTeacher(TeacherDTO teacherDto);

    Teacher updateTeacher(TeacherUpdateDTO teacherUpdateDTO);

    void deleteTeacher(TeacherDeleteDTO teacherDeleteDTO);

    List<Teacher> findAll();

}
