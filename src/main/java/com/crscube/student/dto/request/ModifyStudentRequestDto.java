package com.crscube.student.dto.request;

import lombok.Data;

@Data
public class ModifyStudentRequestDto {
    private int no;
    private int studentNo;
    private String name;
}
