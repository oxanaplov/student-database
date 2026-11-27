package ru.system.student.view;

import ru.system.student.controller.StudentController;
import ru.system.student.dto.CreateStudentDTO;
import ru.system.student.dto.DeleteStudentDTO;
import ru.system.student.dto.GetStudentDTO;
import ru.system.student.model.Student;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import static ru.system.student.util.DateUtil.formatStringToDate;

public class StudentView {

    private final static StudentController studentController = new StudentController();
    private static final Scanner scanner = new Scanner(System.in);

    public static void runInterface(){
        while (true) {
            System.out.println("-------------------------");
            System.out.println("1 Найти студента");
            System.out.println("2 Удалить студента");
            System.out.println("3 Добавить студента");
            System.out.println("0 Выход"); // Показываем пользователю, как закончить работу

            int choice = 0;
            try {
                String enteredChoice = scanner.nextLine(); // Читаем ввод как текст
                choice = Integer.parseInt(enteredChoice);  // Превращаем этот текст в число
            } catch (NumberFormatException ex) {
                System.out.println("Введите номер пункта меню");
                continue;
            }
            if (choice == 0) {
                return;
            }

            if (choice == 1) {
                String value = getStudent();
                System.out.println(value);


            } else if (choice == 2) {
                Boolean isDeleted = deleteStudent();
                if (isDeleted) {
                    System.out.println("Студент удален");

                } else {
                    System.out.println("Не удалось удалить студента, ошибка - перепроверьте данные.");

                }
            } else if (choice == 3) {
                Boolean isCreated = createStudent();
                if (isCreated) {
                    System.out.println("Студент создан");

                } else {
                    System.out.println("Не удалось создать студента, ошибка - перепроверьте данные.");

                }
            } else {
                System.out.println("ведите корректные значения");

            }

        }
    }
    private static String getStudent(){
        System.out.println("Введите серию паспорта");

        String seria = scanner.nextLine();

        System.out.println("Введите номер паспорта");

        String number = scanner.nextLine();

        GetStudentDTO getStudentDTO = new GetStudentDTO(seria, number);
        return studentController.getStudent(getStudentDTO);
    }

    private static Boolean deleteStudent(){
        System.out.println("Введите серию паспорта");

        String seria = scanner.nextLine();

        System.out.println("Введите номер паспорта");

        String number = scanner.nextLine();

        DeleteStudentDTO deleteStudentDTO = new DeleteStudentDTO(seria, number);
        return studentController.deleteStudent(deleteStudentDTO);
    }

    private static Boolean createStudent(){
        System.out.println("Введите серию паспорта");

        String seria = scanner.nextLine();

        System.out.println("Введите номер паспорта");

        String number = scanner.nextLine();

        System.out.println("Введите адрес");

        String address = scanner.nextLine();

        System.out.println("Введите Имя");

        String name = scanner.nextLine();

        System.out.println("Введите Фамилию");

        String lastName = scanner.nextLine();

        LocalDate birthDateFormated;

        while (true) {
            System.out.println("Введите дату рождения в формате ГГГГ-ММ-ДД, например 2001-05-17");
            String birthDate = scanner.nextLine();

            try {
                birthDateFormated = formatStringToDate(birthDate);
                break;
            } catch (DateTimeParseException ex) {
                System.out.println("Не удалось распознать дату. Попробуйте ещё раз.");
            }
        }

        System.out.println("Введите место рождения");

        String birthPlace = scanner.nextLine();

        System.out.println("Введите название факультета");

        String facultyName = scanner.nextLine();

        System.out.println("Введите номер телефона");

        String phoneNumber = scanner.nextLine();

        System.out.println("Введите електронный адрес");

        String email = scanner.nextLine();

        CreateStudentDTO createStudentDTO = new CreateStudentDTO(name, lastName, seria, number, birthDateFormated, birthPlace,
                facultyName, phoneNumber, email, address);
        return studentController.createStudent(createStudentDTO);
    }
}
