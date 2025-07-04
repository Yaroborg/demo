package com.codewithmosh.afanasiev.repository;
import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Repository
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private LocalDate birthDate;

    private Integer age;

    public User() {

    }

    public User(Long id, String name, String email, LocalDate birthDate, Integer age) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.age = age;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

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

    public LocalDate getBirthDate() {

        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {

        this.birthDate = birthDate;
    }

    public Integer getAge() {

        return age;
    }

    public void setAge(Integer age) {

        this.age = age;
    }

    @Override
    public String toString() {

        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", age=" + age +
                '}';
    }

}
