package ru.system.student.view;

import ru.system.student.controller.StudentController;
import ru.system.student.dto.CreateStudentDTO;
import ru.system.student.dto.DeleteStudentDTO;
import ru.system.student.dto.GetStudentDTO;
import ru.system.student.model.Student;

import java.time.LocalDate;
import java.util.Scanner;

import static ru.system.student.util.DateUtil.formatStringToDate;

public class StudentView {

    private final static StudentController studentController = new StudentController();

    public static void runInterface(){
        System.out.println("-------------------------");
        System.out.println("1 Найти студента");
        System.out.println("2 Удалить студента");
        System.out.println("3 Добавить студента");
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        try {
            choice = scanner.nextInt();
        } catch (NumberFormatException ex) {
            System.out.println("ведите корректное цифровое значение");
            runInterface();
        }
        if (choice == 1){
            String value = getStudent();
            System.out.println(value);
            runInterface();

        } else if (choice == 2) {
            Boolean isDeleted = deleteStudent();
            if (isDeleted){
                System.out.println("Студент удален");
                runInterface();
            }else {
                System.out.println("Не удалось удалить студента, ошибка - перепроверьте данные.");
                runInterface();
            }
        } else if (choice == 3) {
            Boolean isCreated = createStudent();
            if (isCreated){
                System.out.println("Студент создан");
                runInterface();
            }else {
                System.out.println("Не удалось создать студента, ошибка - перепроверьте данные.");
                runInterface();
            }
        } else {
            System.out.println("ведите корректные значения");
            runInterface();
        }
    }
    private static String getStudent(){
        System.out.println("Введите серию паспорта");
        Scanner scanner = new Scanner(System.in);
        String seria = scanner.nextLine();

        System.out.println("Введите номер паспорта");
        scanner = new Scanner(System.in);
        String number = scanner.nextLine();

        GetStudentDTO getStudentDTO = new GetStudentDTO(seria, number);
        return studentController.getStudent(getStudentDTO);
    }

    private static Boolean deleteStudent(){
        System.out.println("Введите серию паспорта");
        Scanner scanner = new Scanner(System.in);
        String seria = scanner.nextLine();

        System.out.println("Введите номер паспорта");
        scanner = new Scanner(System.in);
        String number = scanner.nextLine();

        DeleteStudentDTO deleteStudentDTO = new DeleteStudentDTO(seria, number);
        return studentController.deleteStudent(deleteStudentDTO);
    }

    private static Boolean createStudent(){
        System.out.println("Введите серию паспорта");
        Scanner scanner = new Scanner(System.in);
        String seria = scanner.nextLine();

        System.out.println("Введите номер паспорта");
        scanner = new Scanner(System.in);
        String number = scanner.nextLine();

        System.out.println("Введите адрес");
        scanner = new Scanner(System.in);
        String address = scanner.nextLine();

        System.out.println("Введите Имя");
        scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("Введите Фамилию");
        scanner = new Scanner(System.in);
        String lastName = scanner.nextLine();

        System.out.println("Введите дату рождения");
        scanner = new Scanner(System.in);
        String birthDate = scanner.nextLine();
        LocalDate birthDateFormated = formatStringToDate(birthDate);

        System.out.println("Введите место рождения");
        scanner = new Scanner(System.in);
        String birthPlace = scanner.nextLine();

        System.out.println("Введите название факультета");
        scanner = new Scanner(System.in);
        String facultyName = scanner.nextLine();

        System.out.println("Введите номер телефона");
        scanner = new Scanner(System.in);
        String phoneNumber = scanner.nextLine();

        System.out.println("Введите електронный адрес");
        scanner = new Scanner(System.in);
        String email = scanner.nextLine();

        CreateStudentDTO createStudentDTO = new CreateStudentDTO(name, lastName, seria, number, birthDateFormated, birthPlace,
                facultyName, phoneNumber, email, address);
        return studentController.createStudent(createStudentDTO);
    }
}
