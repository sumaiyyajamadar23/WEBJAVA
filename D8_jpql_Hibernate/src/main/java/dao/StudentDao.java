package dao;

import java.util.List;

import pojos.Course;
import pojos.Student;

public interface StudentDao 
{
 String insertStudent(Student stud);
 Student loginStudent(String email,String password);
 List<Student> getByCourse(Course coursetype);
 String changeCourse(int id,Course course);
 
}
