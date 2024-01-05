package com.studnetMgtsys.Demo.dto;

import com.studnetMgtsys.Demo.entity.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentDTOMapper {

    public StudentDTO addStudent(Student student) {
        return new StudentDTO(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }

    public static StudentDTO findStudent(Student student){

        return new StudentDTO(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getAge()
        );
    }
}
