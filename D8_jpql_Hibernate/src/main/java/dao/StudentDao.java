package dao;

import java.util.List;

import pojos.Student;

public interface StudentDao 
{
 String insertStudent(Student stud);
 String loginStudent(String email,String password);
 List<Student> getByCourse(String coursetype);
 
}
