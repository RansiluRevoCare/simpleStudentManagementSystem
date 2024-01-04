package com.studnetMgtsys.Demo.service.impl;

import com.studnetMgtsys.Demo.dto.AddStudentDTO;
import com.studnetMgtsys.Demo.dto.GetStudentDTO;
import com.studnetMgtsys.Demo.entity.Student;
import com.studnetMgtsys.Demo.repository.StudentRepository;
import com.studnetMgtsys.Demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    //---------------------------------------------------
    //find all students details through DTO
    public List<GetStudentDTO> findAllStudent(){
        List<Student> studentList = studentRepository.findAll();

        return studentList.stream()
                .map(this::fromEntityToStudentDTO)
                .collect(Collectors.toList());
    }

    //find student by ID through ID via DTO
    public GetStudentDTO findStudentById(Long id){
        Optional<Student> oneStudent = studentRepository.findById(id);

        return oneStudent.stream()
                .map(this::fromEntityToStudentDTO)
                .findFirst()
                .orElse(null);
    }

    //use this to MAP
    public GetStudentDTO fromEntityToStudentDTO(Student student){
        return new GetStudentDTO(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getAge()
        );
    }

    //-----------------------------------------
    //when register student,filter out
    public AddStudentDTO fromEntityToAddStudentDTO(Student student){
        return new AddStudentDTO(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }

    //to add a student to database through DTO
    public AddStudentDTO addStudent(Student student){
        Student addedStudent = studentRepository.save(student);

        return fromEntityToAddStudentDTO(addedStudent);
    }

    //to update a student in database through DTO
    public AddStudentDTO updateStudent(Long id,Student student){

        student.setId(id);
        Student updateStudent = studentRepository.save(student);

        return fromEntityToAddStudentDTO(updateStudent);
    }
    //------------------------------------------------------
    //to delete a student
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }



}

