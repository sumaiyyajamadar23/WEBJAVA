package pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import pojos.Course;
@Entity
@Table(name="students")
public class Student
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Stud_Id")
private Integer sid;
	@Column(length = 20,name="first_name")
private String fname;
	@Column(length = 20,name="last_name")
private String lname;
	@Column(length = 20,name="email",unique = true)
private String email;
	@Column(length = 20,name="password",nullable =false)
private String password;
	@Enumerated(EnumType.STRING)
	@Column(length = 20,name="course")
private Course course;
	@Column(name = "Date_of_Birth",nullable =false)
private LocalDate dob;
	@Override
	public String toString() {
		return "Student [fname=" + fname + ", lname=" + lname + ", email=" + email + ", course=" + course + ", dob="
				+ dob + "]";
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String fname, String lname, String email, String password, Course course, LocalDate dob) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.course = course;
		this.dob = dob;
	}
	
	
	
}
