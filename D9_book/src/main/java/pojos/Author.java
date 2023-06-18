package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Author")
public class Author extends BaseEntity
{
	@Column(name="First_name")
private String fname;
	@Column(name="Last_name")
private String lname;
	@Column(name="Email",unique = true)
private String email;
	@Column(name="Password",nullable = false)
private String pass;
	@OneToMany(mappedBy ="selectedAuth",cascade=CascadeType.ALL)
private List<Book> bookList=new ArrayList<Book>();
	public Author(String fname, String lname, String email, String pass) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.pass = pass;
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
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public List<Book> getBookList() {
		return bookList;
	}
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	@Override
	public String toString() {
		return "Author [fname=" + fname + ", lname=" + lname + ", email=" + email + ", pass=" + pass + "]";
	}
//	public Author() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
	public void addook(Book b)
	{
	bookList.add(b);
	b.setSelectedAuth(this);
	}
	public void removeBook(Book book)
	{
		bookList.remove(book);
		book.setSelectedAuth(null);
	}

	
}
