package peaksoft.services;

import peaksoft.dao.StudentDao;
import peaksoft.dao.StudentDaoImpl;
import peaksoft.model.Student;

import java.util.List;

/**
 * name : kutman
 **/
public class StudentServicesImpl implements Studentservices {
    StudentDao studentDao = new StudentDaoImpl();
    @Override
    public String createStudentTable() {
        studentDao.createStudentTable();
        return "yes";
    }

    @Override
    public String addStudent(Student student) {
        studentDao.addStudent(student);
        return "yes";
    }

    @Override
    public String dropTable() {
        studentDao.dropTable();
        return null;
    }

    @Override
    public String clearTable() {
        studentDao.clearTable();
        return "yes";
    }

    @Override
    public String updateTable(Long id, Student student) {
        studentDao.updateTable(id,student);
        return null;
    }

    @Override
    public List<Student> getAllStudent() {
       return studentDao.getAllStudent();

    }
}
