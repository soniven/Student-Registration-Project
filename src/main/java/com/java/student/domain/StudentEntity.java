package com.java.student.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity (name="student")
public class StudentEntity {

    @Id
    Long id;
    String firstName;
    String lastName;
    String className;
    String nationality;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName;}

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getClassName() { return className; }

    public void setClassName(String className) { this.className = className; }

    public String getNationality() { return nationality; }

    public void setNationality(String nationality) { this.nationality = nationality; }
}