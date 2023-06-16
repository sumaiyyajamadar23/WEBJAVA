package pojos;

public enum Course
{
DAC(1000),DBDA(500),DITISS(200);
 private  double fees;
Course(double fees)
{
	this.fees=fees;
	// TODO Auto-generated constructor stub
}
public double getFees() {
	return fees;
}


}
