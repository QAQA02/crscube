package com.crscube.student.dto.response;

import lombok.Data;

@Data
public class StudentResponseDto {
    private int no;
    private int studentNo;
    private String name;

    public StudentResponseDto(int no, int studentNo, String name) {
        this.no = no;
        this.studentNo = studentNo;
        this.name = name;
    }
}
