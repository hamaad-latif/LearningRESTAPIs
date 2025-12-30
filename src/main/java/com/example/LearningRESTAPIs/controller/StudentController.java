package com.example.LearningRESTAPIs.controller;

import com.example.LearningRESTAPIs.dto.AddStudentRequestDto;
import com.example.LearningRESTAPIs.dto.StudentDto;
import com.example.LearningRESTAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>> getStudents() {
        return ResponseEntity
                .ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable long id) {
        return ResponseEntity
                .ok(studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody AddStudentRequestDto addStudentRequestDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(studentService.createNewStudent(addStudentRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public  ResponseEntity<StudentDto> updateAStudentById(@PathVariable Long id, @RequestBody AddStudentRequestDto addStudentRequestDto) {
        return ResponseEntity
                .ok(studentService.updateStudentDataById(id, addStudentRequestDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudentDto> updatePartialStudent(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        return ResponseEntity
                .ok(studentService.updatePartialStudentById(id, updates));
    }

}
