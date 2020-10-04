package com.java.student.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class StudentEntity {

    @Id
    Long id;
    String firstName;
    String lastName;
    String className;
    String nationality;

    public Long getId() {
        return id;
    }

    public void setFirstName(String fname) {
        this.firstName = fname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lName) {
        this.lastName = lName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setClassName(String cName) {
        this.className = cName;
    }

    public String getClassName() {
        return className;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    public void setId(Long id) { this.id = id; }
}
