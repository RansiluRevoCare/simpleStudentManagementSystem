package com.studnetMgtsys.Demo.service;

import com.studnetMgtsys.Demo.dto.AddStudentDTO;
import com.studnetMgtsys.Demo.dto.GetStudentDTO;
import com.studnetMgtsys.Demo.entity.Student;

import java.util.List;

public interface StudentService {

    List<GetStudentDTO> findAllStudent();
    GetStudentDTO findStudentById(Long id);

    // add
    AddStudentDTO addStudent(Student student);
    //update
    AddStudentDTO updateStudent(Long id,Student student);
    public void deleteStudent(Long id);
}