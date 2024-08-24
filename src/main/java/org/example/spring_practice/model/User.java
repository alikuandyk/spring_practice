package org.example.spring_practice.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class User {
    private String email;
    private String nickname;
    private LocalDate birthdate;
}
