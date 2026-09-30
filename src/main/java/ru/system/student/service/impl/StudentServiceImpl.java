package ru.system.student.service.impl;

import ru.system.student.model.Faculty;
import ru.system.student.model.Passport;
import ru.system.student.model.Student;
import ru.system.student.service.StudentService;

import java.time.LocalDate;

import static ru.system.student.database.Database.FACULTIES;
import static ru.system.student.database.Database.STUDENTS;

public class StudentServiceImpl implements StudentService {
    @Override
    public String getStudent(String seria, String number) {
        Passport passport = STUDENTS.keySet()
                .stream()
                .filter(student -> student.getSeria().equals(seria)&&student.getNumber().equals(number))
                .findFirst().orElse(null);

        if (passport == null){
            return "Студанта с этими данными нет";
        }
        return STUDENTS.get(passport).toString();
    }

    @Override
    public Boolean deleteStudent(String seria, String number) {
       Passport passport = STUDENTS.keySet()
                .stream()
                .filter(student -> student.getSeria().equals(seria)&&student.getNumber().equals(number))
                .findFirst().orElse(null);

        if(passport == null){
            return false;
        } else {
            STUDENTS.remove(passport);
            return true;
        }
    }

    @Override
    public Boolean createStudent(String name, String lastName, String seria, String number, LocalDate birthDate,
                                 String birthPlace, Faculty faculty, String phoneNumber, String email,
                                 String address) {
        Passport passport = new Passport(name, lastName, birthDate, birthPlace, seria, number);

        Student student = new Student(phoneNumber, email, address, faculty);
        STUDENTS.put(passport, student);
        return true;
    }
}
