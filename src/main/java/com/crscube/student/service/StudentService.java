package com.crscube.student.service;

import com.crscube.student.dto.request.CreateStudentRequestDto;
import com.crscube.student.dto.request.ModifyStudentRequestDto;
import com.crscube.student.dto.response.StudentResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    String register(CreateStudentRequestDto dto);
    StudentResponseDto getStudent(int studentNo);
    List<StudentResponseDto> getStudentList();
    String modifyStudent(ModifyStudentRequestDto dto);
    String deleteStudent(int no);
}
