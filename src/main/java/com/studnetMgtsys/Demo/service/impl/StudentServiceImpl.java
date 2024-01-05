package com.studnetMgtsys.Demo.service.impl;

import com.studnetMgtsys.Demo.dto.StudentDTO;
import com.studnetMgtsys.Demo.dto.StudentDTOMapper;
import com.studnetMgtsys.Demo.entity.Student;
import com.studnetMgtsys.Demo.repository.StudentRepository;
import com.studnetMgtsys.Demo.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private StudentDTOMapper studentDTOMapper;

    public StudentServiceImpl(StudentRepository studentRepository, StudentDTOMapper studentDTOMapper){
        this.studentRepository = studentRepository;
        this.studentDTOMapper= studentDTOMapper;
    }

    public List<StudentDTO> findAllStudent(){
        List<Student> studentList = studentRepository.findAll();

        List<StudentDTO> findAllStudentDTO = studentList.stream()
                .map(StudentDTOMapper::findStudent)
                .collect(Collectors.toList());

        return findAllStudentDTO;
    }

    public StudentDTO findStudentById(Long id){
        Optional<Student> oneStudent = studentRepository.findById(id);

        StudentDTO fineOneStudentDTO = oneStudent.stream()
                .map(StudentDTOMapper::findStudent)
                .findFirst()
                .orElse(null);

        return fineOneStudentDTO;
    }

    public StudentDTO addStudent(Student student){
        Student addedStudent = studentRepository.save(student);

        StudentDTO addedstudentDTO = studentDTOMapper.addStudent(addedStudent);

        return addedstudentDTO;
    }

    public StudentDTO updateStudent(Long id,Student student){

        student.setId(id);
        Student updateStudent = studentRepository.save(student);

        StudentDTO updateStudentDTO = studentDTOMapper.addStudent(student);

        return updateStudentDTO;
    }

    public String deleteStudent(Long id) throws EntityNotFoundException{
        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
            return "id found and "+id+" deleted ";
        }else{
            return "id "+ id+ " not found";
        }
    }
}

