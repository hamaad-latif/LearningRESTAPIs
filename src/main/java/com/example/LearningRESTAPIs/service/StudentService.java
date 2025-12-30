package com.example.LearningRESTAPIs.service;

import com.example.LearningRESTAPIs.dto.AddStudentRequestDto;
import com.example.LearningRESTAPIs.dto.StudentDto;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<StudentDto> getAllStudents();
    StudentDto getStudentById(Long id);
    StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);
    void deleteStudentById(Long id);
    StudentDto updateStudentDataById(Long id, AddStudentRequestDto addStudentRequestDto);

    StudentDto updatePartialStudentById(Long id, Map<String, Object> updates);
}
