package com.studnetMgtsys.Demo.service;

import com.studnetMgtsys.Demo.dto.StudentDTO;
import com.studnetMgtsys.Demo.entity.Student;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
public interface StudentService {
    List<StudentDTO> findAllStudent();
    StudentDTO findStudentById(Long id);
    StudentDTO addStudent(Student student);
    StudentDTO updateStudent(Long id,Student student);
    String deleteStudent(Long id);
}