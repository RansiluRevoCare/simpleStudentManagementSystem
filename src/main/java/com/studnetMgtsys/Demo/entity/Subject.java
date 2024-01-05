package com.studnetMgtsys.Demo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Subject {

    @Id
    @SequenceGenerator(
            name="sequence_subject",
            sequenceName = "sequence_subject",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,generator = "sequence_subject"
    )
    private Long subjectId;
    private String subjectCode;
    private String subjectName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="student_subject_table",
            joinColumns = {
            @JoinColumn(name="subject_fk_id",referencedColumnName = "subjectId")
            },
            inverseJoinColumns = {
            @JoinColumn(name="student_fk_id",referencedColumnName = "studentId")
            }
    )
    private List<Student> student;

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectId(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
