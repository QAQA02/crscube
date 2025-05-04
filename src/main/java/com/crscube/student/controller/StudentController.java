package com.crscube.student.controller;

import com.crscube.student.dto.request.CreateStudentRequestDto;
import com.crscube.student.dto.request.ModifyStudentRequestDto;
import com.crscube.student.dto.response.StudentResponseDto;
import com.crscube.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<String> register(@RequestBody CreateStudentRequestDto dto) {
        String result = studentService.register(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping
    public ResponseEntity<StudentResponseDto> getStudent(@RequestParam int studentNo) {
        StudentResponseDto student = studentService.getStudent(studentNo);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/list")
    public ResponseEntity<List<StudentResponseDto>> getStudentList() {
        List<StudentResponseDto> students = studentService.getStudentList();
        return ResponseEntity.ok(students);
    }

    @PutMapping
    public ResponseEntity<String> modify(@RequestBody ModifyStudentRequestDto dto) {
        String result = studentService.modifyStudent(dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam int no) {
        String result = studentService.deleteStudent(no);
        return ResponseEntity.ok(result);
    }
}
