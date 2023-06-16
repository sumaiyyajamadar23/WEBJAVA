package dao;

import pojos.Student;

public interface StudentDao 
{
 String insertStudent(Student stud);
 String loginStudent(String email,String password);
}
