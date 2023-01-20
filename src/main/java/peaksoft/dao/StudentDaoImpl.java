package peaksoft.dao;

import peaksoft.config.Configuration;
import peaksoft.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * name : kutman
 **/
public class StudentDaoImpl implements StudentDao {

    private Connection connection;


    public StudentDaoImpl() {
        this.connection = (Connection) Configuration.getConnection();
    }

    @Override
    public void createStudentTable() {
        try {
            String query = """
                    create table if not exists students(
                    id serial primary key,
                    first_name varchar,
                    last_name varchar,
                    age int);
                    """;
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            System.out.println("table is create!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addStudent(Student student) {
        String query = """
                insert into students (first_name,last_name,age)values(
                ?,?,?);
                """;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.executeUpdate();
            System.out.println("add students!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void dropTable() {
        String sql = """
                drop table students;
                """;
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.execute(sql);
            System.out.println("drop table");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void clearTable() {
        String sql = "delete from students;";
        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
            System.out.println("clear from students");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateTable(Long id, Student student) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update students set first_name = ?,last_name = ?,age ? where id = ?");
            preparedStatement.setString(1,student.getFirstName());
            preparedStatement.setString(2,student.getLastName());
            preparedStatement.setInt(3,student.getAge());
            preparedStatement.setLong(4,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<>();
        String sql = "select * from students;";
        try {
            Statement statement = connection.createStatement();
            statement.executeQuery(sql);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                students.add(new Student(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }
}
