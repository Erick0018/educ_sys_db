package com.erickjesus.educ_sys_db.dto;

import com.erickjesus.educ_sys_db.domain.Student;

import java.util.Date;

public class StudentDTO {

    private String id;
    private String name;
    private String email;
    private Date birthDate;



    public StudentDTO(Student obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.email = obj.getEmail();
        this.birthDate = obj.getBirthDate();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
