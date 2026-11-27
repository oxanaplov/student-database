package ru.system.student.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    public static LocalDate formatStringToDate(String date){

        return LocalDate.parse(date);
    }
}
