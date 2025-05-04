package com.crscube.student.service.impl;

import com.crscube.student.dto.request.CreateStudentRequestDto;
import com.crscube.student.dto.request.ModifyStudentRequestDto;
import com.crscube.student.dto.response.StudentResponseDto;
import com.crscube.student.entity.StudentEntity;
import com.crscube.student.repository.StudentRepository;
import com.crscube.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public String register(CreateStudentRequestDto dto) {
        StudentEntity entity = StudentEntity.builder()
                .name(dto.getName())
                .studentNo(dto.getStudentNo())
                .build();

        studentRepository.save(entity);

        return "success";
    }

    @Override
    public StudentResponseDto getStudent(int studentNo) {
        StudentEntity entity = studentRepository.findOneByStudentNo(studentNo);
        if (entity == null) return null;

        return entity.entityToDto();
    }

    @Override
    public List<StudentResponseDto> getStudentList() {
        return studentRepository.findAll().stream()
                .map(StudentEntity::entityToDto)
                .toList();
    }

    @Override
    public String modifyStudent(ModifyStudentRequestDto dto) {
        try {
            StudentEntity entity = studentRepository.findById(dto.getNo()).orElseThrow();
            studentRepository.save(entity.update(dto));

            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }

    @Override
    public String deleteStudent(int no) {
        studentRepository.deleteById(no);

        return "success";
    }


}
