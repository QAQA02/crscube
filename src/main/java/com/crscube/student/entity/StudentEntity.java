package com.crscube.student.entity;

import com.crscube.student.dto.request.ModifyStudentRequestDto;
import com.crscube.student.dto.response.StudentResponseDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_tbl")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    @Column(name = "student_no", nullable = false, unique = true)
    private int studentNo;

    @Column(name = "name", nullable = false)
    private String name;

    public StudentResponseDto entityToDto() {
        return new StudentResponseDto(this.no, this.studentNo, this.name);
    }

    public StudentEntity update(ModifyStudentRequestDto dto) {
        return StudentEntity.builder()
                .no(this.no)
                .studentNo(dto.getStudentNo())
                .name(dto.getName())
                .build();
    }
}
