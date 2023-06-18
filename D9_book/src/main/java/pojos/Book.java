package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "Book")
public class Book extends BaseEntity
{
	@Column(name="Book_Name",length =30,unique =true)
private String title;
	@Column(name="Book_Price")
private double price;
	@JoinColumn(name="Author_id")
	@ManyToOne
private Author selectedAuth;
	
	
	public Book(String title, double price) {
		super();
		this.title = title;
		this.price = price;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Author getSelectedAuth() {
		return selectedAuth;
	}

	public void setSelectedAuth(Author selectedAuth) {
		this.selectedAuth = selectedAuth;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + "]";
	}
	
}
