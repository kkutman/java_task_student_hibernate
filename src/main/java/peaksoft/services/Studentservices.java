package peaksoft.services;

import peaksoft.model.Student;

import java.util.List;

/**
 * name : kutman
 **/
public interface Studentservices {
    String createStudentTable();
    String addStudent(Student student);
    String dropTable();
    String clearTable();
    String updateTable(Long id, Student student);
    List<Student> getAllStudent();
}
