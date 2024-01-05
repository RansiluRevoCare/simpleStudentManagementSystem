package com.studnetMgtsys.Demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class StudentAddress {

    @Id
    @SequenceGenerator(name="sequence_studentAddress",
                sequenceName = "sequence_studentAddress",
                allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequence_studentAddress")
    private Long addressId;
    @Column(nullable = false)
    private String houseNo;

    @Column(nullable = false)
    private String streetName;

    @Column(nullable = false)
    private String city;
    private String district;
    private String province;

    @OneToOne(mappedBy = "studentAddress")
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
