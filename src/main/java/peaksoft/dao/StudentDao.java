package peaksoft.dao;

import peaksoft.model.Student;

import java.util.List;

/**
 * name : kutman
 **/
public interface StudentDao {
    void createStudentTable();
    void addStudent(Student student);
    void dropTable();
    void clearTable();
    void updateTable(Long id, Student student);
    List<Student>getAllStudent();
}
