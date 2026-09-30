package ru.system.student.database;

import ru.system.student.model.Faculty;
import ru.system.student.model.Passport;
import ru.system.student.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    public final static Map<Passport, Student> STUDENTS = new HashMap<>();
    public final static List<Faculty> FACULTIES =
            List.of(new Faculty("Математический", "+7864537383", "math@mail.ru"),
                    new Faculty("Физический", "+7864537983", "psh@mail.ru"),
                    new Faculty("Экономический", "+7864537111", "econom@mail.ru"));
}
