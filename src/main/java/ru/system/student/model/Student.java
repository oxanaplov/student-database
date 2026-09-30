package ru.system.student.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String phoneNumber;
    private String email;
    private String address;
    private Faculty faculty;
}
