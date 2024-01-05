package com.studnetMgtsys.Demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dob;
    private String aboutME;
    private String password;

    private Integer age;

    public StudentDTO(Long id,String firstName,String lastName,String email){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email = email;
    }

    public StudentDTO(String firstName,String lastName,String email,Integer age){
        this.firstName=firstName;
        this.lastName=lastName;
        this.email = email;
        this.age = age;
    }
}
