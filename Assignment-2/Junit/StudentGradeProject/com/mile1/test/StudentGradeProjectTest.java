package com.mile1.test;

import com.mile1.main.Student;
import com.mile1.main.StudentReport;
import com.mile1.main.StudentService;
import com.mile1.exception.NullMarksArrayException;
import com.mile1.exception.NullNameException;
import com.mile1.exception.NullStudentException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentGradeProjectTest {

    StudentReport report = new StudentReport();
    StudentService service = new StudentService();

    Student[] students = {
        new Student("Alice", new int[]{90, 85, 80}),  // TC1: A
        new Student("Bob", new int[]{60, 60, 65}),    // TC2: D
        new Student("Charlie", new int[]{40, 50, 45}),// TC3: F
        null,                                         // TC4: Null object
        new Student(null, new int[]{50, 50, 50}),     // TC5: Null name
        new Student("Eve", null),                     // TC6: Null marks
        new Student(null, new int[]{10, 20, 30}),     // Extra null name
        null,                                         // Extra null object
        new Student("John", null)                     // Extra null marks
    };

    @Test
    void testTC1() throws Exception {
        assertTrue(service.validate(students[0]));
        assertEquals("A", report.findGrade(students[0]));
    }

    @Test
    void testTC2() throws Exception {
        assertTrue(service.validate(students[1]));
        assertEquals("D", report.findGrade(students[1]));
    }

    @Test
    void testTC3() throws Exception {
        assertTrue(service.validate(students[2]));
        assertEquals("F", report.findGrade(students[2]));
    }

    @Test
    void testTC4() {
        assertThrows(NullStudentException.class, () -> service.validate(students[3]));
    }

    @Test
    void testTC5() {
        assertThrows(NullNameException.class, () -> service.validate(students[4]));
    }

    @Test
    void testTC6() {
        assertThrows(NullMarksArrayException.class, () -> service.validate(students[5]));
    }

    @Test
    void testTC7_CountNullNames() {
        assertEquals(2, service.findNumberOfNullName(students));
    }

    @Test
    void testTC8_CountNullObjects() {
        assertEquals(2, service.findNumberOfNullObjects(students));
    }

    @Test
    void testTC9_CountNullMarks() {
        assertEquals(2, service.findNumberOfNullMarks(students));
    }
}
