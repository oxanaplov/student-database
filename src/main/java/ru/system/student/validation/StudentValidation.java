package ru.system.student.validation;

public class StudentValidation {
    public static String validateSeriaAndNumber(String seria, String number){
        if(seria.length() != 4){
            return "Введите корректную серию из 4 цифр";
        }  if(number.length() != 6){
            return "Введите корректный номер из 6 цифр";
        }
        return null;
    }
}
