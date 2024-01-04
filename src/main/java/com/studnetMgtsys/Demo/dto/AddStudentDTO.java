package com.studnetMgtsys.Demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddStudentDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
