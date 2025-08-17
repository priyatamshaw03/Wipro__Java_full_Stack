package com.mile1.main;

import com.mile1.exception.NullMarksArrayException;
import com.mile1.exception.NullNameException;
import com.mile1.exception.NullStudentException;

public class StudentService {
    public boolean validate(Student student)
            throws NullStudentException, NullNameException, NullMarksArrayException {
        if (student == null) throw new NullStudentException("Null Student object");
        if (student.getName() == null) throw new NullNameException("Null name in Student object");
        if (student.getMarks() == null) throw new NullMarksArrayException("Null marks array in Student object");
        return true;
    }

    public int findNumberOfNullName(Student[] students) {
        int count = 0;
        for (Student s : students) {
            if (s != null && s.getName() == null) count++;
        }
        return count;
    }

    public int findNumberOfNullObjects(Student[] students) {
        int count = 0;
        for (Student s : students) {
            if (s == null) count++;
        }
        return count;
    }

    public int findNumberOfNullMarks(Student[] students) {
        int count = 0;
        for (Student s : students) {
            if (s != null && s.getMarks() == null) count++;
        }
        return count;
    }
}
