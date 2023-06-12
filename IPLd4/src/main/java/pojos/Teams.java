package pojos;

public class Teams 
{
private int teamid;
private String name;
private String abbrivation;
private String owener;
private int max_age;
private double batting_avg;
private int minwickets_taken;


public Teams(int teamid,String abbrivation) {
	super();
 this.teamid=teamid;
 this.abbrivation=abbrivation;
}

public Teams(int teamid, String name, String abbrivation, String owener, int max_age, double batting_avg,
		int wickets_taken) 
{
	super();
	this.teamid = teamid;
	this.name = name;
	this.abbrivation = abbrivation;
	this.owener = owener;
	this.max_age = max_age;
	this.batting_avg = batting_avg;
	this.minwickets_taken = wickets_taken;
	
	
}

public int getId()
{
	return teamid;
}

public void setId(int id) 
{
	this.teamid = teamid;
}

public String getName() 
{
	return name;
}

public void setName(String name) 
{
	this.name = name;
}

public String getAbbrivation()
{
	return abbrivation;
}

public void setAbbrivation(String abbrivation) 
{
	this.abbrivation = abbrivation;
}

public String getOwener()
{
	return owener;
}

public void setOwener(String owener) 
{
	this.owener = owener;
}

public int getMax_age()
{
	return max_age;
}

public void setMax_age(int max_age) 
{
	this.max_age = max_age;
}

public double getBatting_avg() 
{
	return batting_avg;
}

public void setBatting_avg(double batting_avg)
{
	this.batting_avg = batting_avg;
}

public int getWickets_taken() 
{
	return minwickets_taken;
}

public void setWickets_taken(int minwickets_taken)
{
	this.minwickets_taken = minwickets_taken;
}

@Override
public String toString() 
{
	return "Teams [id=" + teamid + ", name=" + name + ", abbrivation=" + abbrivation + ", owener=" + owener + ", max_age="
			+ max_age + ", batting_avg=" + batting_avg + ", wickets_taken=" + minwickets_taken + "]";
}

}
