package ru.system.student.validation;

public class StudentValidation {
    public static String validateSeriaAndNumber(String seria, String number){
        if(seria == null || !seria.matches("[0-9]{4}")){
            return "Серия паспорта должна состоять из четырёх цифр";
        }  if(number == null || !number.matches("[0-9]{6}")){
            return "Номер паспорта должен состоять из шести цифр";
        }
        return null;
    }
}
