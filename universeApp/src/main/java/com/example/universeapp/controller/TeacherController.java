package com.example.universeapp.controller;

import com.example.universeapp.model.dto.TeacherDTO;
import com.example.universeapp.model.dto.TeacherDeleteDTO;
import com.example.universeapp.model.dto.TeacherUpdateDTO;
import com.example.universeapp.model.entities.Teacher;
import com.example.universeapp.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public ResponseEntity<Teacher> createTeacher(@RequestBody @Valid TeacherDTO teacherDto) {
        Teacher teacher = teacherService.createTeacher(teacherDto);
        return ResponseEntity.ok().body(teacher);
    }

    @PutMapping
    @ResponseBody
    public Teacher updateTeacher(@RequestBody @Valid TeacherUpdateDTO teacherUpdateDTO) {
        return teacherService.updateTeacher(teacherUpdateDTO);
    }

    @DeleteMapping
    @ResponseBody
    public void deleteTeacher(@RequestBody @Valid TeacherDeleteDTO teacherDeleteDTO) {
        teacherService.deleteTeacher(teacherDeleteDTO);
    }

    @GetMapping("/find")
    public ResponseEntity<List<Teacher>> findAll() {
        return ResponseEntity.ok(teacherService.findAll());
    }
}
