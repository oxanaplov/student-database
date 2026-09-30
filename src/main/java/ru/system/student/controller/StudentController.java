package ru.system.student.controller;

import ru.system.student.dto.CreateStudentDTO;
import ru.system.student.dto.DeleteStudentDTO;
import ru.system.student.dto.GetStudentDTO;
import ru.system.student.model.Faculty;
import ru.system.student.model.Student;
import ru.system.student.service.StudentService;
import ru.system.student.service.impl.StudentServiceImpl;

import static ru.system.student.database.Database.FACULTIES;
import static ru.system.student.validation.StudentValidation.validateSeriaAndNumber;

public class StudentController {

    StudentService studentService = new StudentServiceImpl();
    public String getStudent(GetStudentDTO studentDTO){
        String validationMass = validateSeriaAndNumber(studentDTO.getSeria(), studentDTO.getNumber());
        if(validationMass == null){
            return studentService.getStudent(studentDTO.getSeria(), studentDTO.getNumber());
        } else {
            return validationMass;
        }
        //узнать как добавить регулярные выражение на валидацию символов звоздочки воскл знак

    }
    public Boolean deleteStudent(DeleteStudentDTO studentDTO){
        if(studentDTO.getSeria().length() != 4){
            return false;
        }  if(studentDTO.getNumber().length() != 6){
            return false;
        }
        return studentService.deleteStudent(studentDTO.getSeria(), studentDTO.getNumber());

    }
    public Boolean createStudent(CreateStudentDTO createStudentDTO){
        Faculty faculty = FACULTIES.stream()
                .filter(facValue -> facValue.getName().equals(createStudentDTO.getFacultyName()))
                .findFirst().orElse(null);
        if(faculty != null){
            return studentService.createStudent(createStudentDTO.getName(),createStudentDTO.getLastName(),
                    createStudentDTO.getSeria(), createStudentDTO.getNumber(), createStudentDTO.getBirthDate(),
                    createStudentDTO.getBirthPlace(), faculty,
                    createStudentDTO.getPhoneNumber(),
                    createStudentDTO.getEmail(), createStudentDTO.getAddress());
        }else {
            return false;
        }//переписать на строчный вариант? узнать про спринг бут анотации валидация итд
        // плюс диспетчер серулетов что это

    }
}
