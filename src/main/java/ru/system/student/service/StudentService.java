package ru.system.student.service;

import ru.system.student.model.Faculty;
import ru.system.student.model.Student;

import java.time.LocalDate;

public interface StudentService {
    String getStudent(String seria, String number);

    Boolean deleteStudent (String seria, String number);

    Boolean createStudent (String name, String lastName, String seria, String number,
                           LocalDate birthDate, String birthPlace, Faculty facultyName,
                           String phoneNumber, String email, String address);
}
