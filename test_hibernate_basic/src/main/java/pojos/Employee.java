package pojos;

import java.time.LocalDate;
import javax.persistence.*;//all specifications javaEE supplies
/*emp_id(PK) ,first_name,last_name,email(unique),password,
 * join_date,emp_type(full_time/part_time/contract...)
*/
@Entity//MAndatory to tell hibernate following class is standalone entity
        //life cycle is managed by hibernate
@Table(name="emps")//to specify table name
public class Employee 
{   //Mandetory requirement:-Id property must be Serializable
	//can it be int/long:-yes but not recommended
	
	@Id//madatory,pk constraint,column lvl 
	@GeneratedValue(strategy =GenerationType.IDENTITY)//implies hibernate should generate 
	//ids automatically,as per auto increament strategy
	@Column(name="emp_id")//coloumn name=emp_id
	private Integer empid;
	@Column(name="first_name",length=20)//varchar20
	private String firstname;
	@Column(name="lastst_name",length=20)
	private String lastname;
	@Column(length=30,unique = true)//unique const
	private String email;
	@Column(length=30,nullable = false)//not null cons
	private String password;
	@Transient//skips from persistence//no column generation
	private String confirmpassword;
	private LocalDate joindate;
	@Enumerated(EnumType.STRING)//coltype:
	//varchar:enum const name
	private EmployeeType type;
	private double salary;
	@Lob//large object:def col type:longLob:capacity in mbs
	private byte[]image;
	private Employee()
	{
		
	}
	
	public Employee(String firstname, String lastname, String email, String password,
			String confirmpassword, LocalDate joindate, EmployeeType type, double salary) {
		super();
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.joindate = joindate;
		this.type = type;
		this.salary = salary;
	}

	//setter and getter
	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	public LocalDate getJoindate() {
		return joindate;
	}
	public void setJoindate(LocalDate joindate) {
		this.joindate = joindate;
	}
	public EmployeeType getType() {
		return type;
	}
	public void setType(EmployeeType type) {
		this.type = type;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", joindate=" + joindate + ", type=" + type + ", salary=" + salary + "]";
	}
	
	
}
