package com.mile1.main;

public class StudentReport {
    public String findGrade(Student student) {
        int totalMarks = 0;
        for (int m : student.getMarks()) {
            totalMarks += m;
        }
        if (totalMarks >= 240) return "A";
        else if (totalMarks >= 180) return "D";
        else return "F";
    }
}
