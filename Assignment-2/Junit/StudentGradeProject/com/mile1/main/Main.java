package com.mile1.main;

import com.mile1.exception.NullMarksArrayException;
import com.mile1.exception.NullNameException;
import com.mile1.exception.NullStudentException;

public class Main {
    public static void main(String[] args) {
        StudentReport report = new StudentReport();
        StudentService service = new StudentService();

        Student[] students = {
            new Student("Alice", new int[]{90, 85, 80}),  // A
            new Student("Bob", new int[]{60, 60, 65}),    // D
            new Student("Charlie", new int[]{40, 50, 45}),// F
            null,
            new Student(null, new int[]{50, 50, 50}),
            new Student("Eve", null),
            new Student(null, new int[]{10, 20, 30}),
            null,
            new Student("John", null)
        };

        for (int i = 0; i < students.length; i++) {
            try {
                if (service.validate(students[i])) {
                    System.out.println("Student " + (i+1) + " Grade: " + report.findGrade(students[i]));
                }
            } catch (NullStudentException | NullNameException | NullMarksArrayException e) {
                System.out.println("Student " + (i+1) + " Error: " + e.getMessage());
            }
        }

        System.out.println("Null Name Count: " + service.findNumberOfNullName(students));
        System.out.println("Null Object Count: " + service.findNumberOfNullObjects(students));
        System.out.println("Null Marks Count: " + service.findNumberOfNullMarks(students));
    }
}
