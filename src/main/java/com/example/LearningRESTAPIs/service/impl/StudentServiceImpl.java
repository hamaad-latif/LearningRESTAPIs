package com.example.LearningRESTAPIs.service.impl;

import com.example.LearningRESTAPIs.dto.AddStudentRequestDto;
import com.example.LearningRESTAPIs.dto.StudentDto;
import com.example.LearningRESTAPIs.entity.Student;
import com.example.LearningRESTAPIs.repository.StudentRepository;
import com.example.LearningRESTAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentsDto = students
                .stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .toList();
        return studentsDto;
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with ID: "+id));
        StudentDto studentDto = modelMapper.map(student, StudentDto.class);
        return studentDto;
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map(addStudentRequestDto, Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if (!(studentRepository.existsById(id))) {
            throw new IllegalArgumentException("Student does not exist with id: " + id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudentDataById(Long id, AddStudentRequestDto addStudentRequestDto) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student does not found with ID: " + id));
        modelMapper.map(addStudentRequestDto, student);
        student = studentRepository.save(student);

        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto updatePartialStudentById(Long id, Map<String, Object> updates) {
        Student student = studentRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student does not found with ID: " + id));

        updates.forEach((field, value) -> {
            switch (field) {
                case "name":
                    student.setName((String) value);
                    break;
                case "email":
                    student.setEmail((String) value);
                    break;
                default:
                    new IllegalArgumentException("Field is not supported");
            }
        });

        Student updatedStudent = studentRepository.save(student);
        return modelMapper.map(updatedStudent, StudentDto.class);
    }
}
