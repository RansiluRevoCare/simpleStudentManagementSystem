package com.studnetMgtsys.Demo.controller;

import com.studnetMgtsys.Demo.dto.StudentDTO;
import com.studnetMgtsys.Demo.entity.Degree;
import com.studnetMgtsys.Demo.entity.Student;
import com.studnetMgtsys.Demo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> findAllStudent(){
        return ResponseEntity.ok(studentService.findAllStudent());
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<StudentDTO> findStudentById(@PathVariable("id")Long id){

        StudentDTO findByIdStudentDTO = studentService.findStudentById(id);
        return ResponseEntity.ok(findByIdStudentDTO);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> addStudent(@RequestBody Student student){
        StudentDTO saveStudentDTO = studentService.addStudent(student);
        return new ResponseEntity<>(saveStudentDTO, HttpStatus.CREATED);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable("id")Long id, @RequestBody Student student){
        StudentDTO updateStudentDTO = studentService.updateStudent(id,student);
        return ResponseEntity.ok(updateStudentDTO);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id")Long id){
        String res = studentService.deleteStudent(id);
        return ResponseEntity.ok(res);
    }

}

