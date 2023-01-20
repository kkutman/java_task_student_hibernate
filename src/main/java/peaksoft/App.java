package peaksoft;

import peaksoft.config.Configuration;
import peaksoft.model.Student;
import peaksoft.services.StudentServicesImpl;
import peaksoft.services.Studentservices;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Studentservices studentservices = new StudentServicesImpl();
      // System.out.println(studentservices.createStudentTable());
      //  System.out.println(studentservices.addStudent(new Student("aibek2332323","dss3223",19)));
        //   System.out.println(studentservices.clearTable());
        //System.out.println(studentservices.dropTable());
        studentservices.getAllStudent().forEach(System.out::println);
        System.out.println(studentservices.updateTable(1L, new Student("kuti", "kaseiin", 1)));
    }
}
