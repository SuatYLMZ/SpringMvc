package com.tpe.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Please enter valid first name") //@NotBlank = not emtpty(""), not null, not blank(" ")
    private String firstName;
    @NotEmpty(message = "Please enter valid last name")  //@NotEmpty = not emtpty(""), not null
    private String lastName;
    @NotNull (message = "Please enter grade") //@NotEmpty =  not null
    private Integer grade;
    private LocalDateTime  createDate= LocalDateTime.now();

    //getter - setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

//    public void setCreatedDate(LocalDateTime createdDate) {
//        this.createdDate = createdDate;
//    }

    //toString

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", grade=" + grade +
                ", createdDate=" + createDate +
                '}';
    }
}
