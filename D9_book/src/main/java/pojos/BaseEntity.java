package pojos;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
@MappedSuperclass
public class BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

public BaseEntity() {
	super();
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

}
