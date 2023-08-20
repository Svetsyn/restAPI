package com.example.universeapp.controller;

import com.example.universeapp.model.dto.StudentDTO;
import com.example.universeapp.model.dto.StudentDeleteDTO;
import com.example.universeapp.model.dto.StudentUpdateDTO;
import com.example.universeapp.model.entities.Student;
import com.example.universeapp.model.enums.CourseType;
import com.example.universeapp.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("api/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody @Valid StudentDTO studentDto) {
        Student student = studentService.createStudent(studentDto);
        return ResponseEntity.ok().body(student);
    }

    @PutMapping
    @ResponseBody
    public Student updateStudent(@RequestBody @Valid StudentUpdateDTO studentUpdateDTO) {
        return studentService.updateStudent(studentUpdateDTO);
    }

    @DeleteMapping
    @ResponseBody
    public void deleteStudent(@RequestBody @Valid StudentDeleteDTO studentDeleteDTO) {
        studentService.deleteStudent(studentDeleteDTO);
    }

    @GetMapping("/find")
    public ResponseEntity<List<Student>> findAllOrNot(
            @RequestParam(value = "studentGroup", required = false) Integer studentGroup,
            @RequestParam(value = "course", required = false) CourseType course
    ) {
        if (studentGroup == null && course == null) {
            return ResponseEntity.ok(studentService.findAll());
        }
        if (course != null) {
            return ResponseEntity.ok(studentService.findByCourses(course));
        }
        if (studentGroup != null) {
            return ResponseEntity.ok(studentService.findByStudentGroup(studentGroup));
        }
        return ResponseEntity.ok().body(null);
    }
}
