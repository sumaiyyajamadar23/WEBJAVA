package pojos;

import java.sql.Date;

public class Players 
{
private int playerId;
private String firstname;
private String laname;
private Date dob;
private double batting_avg;
private int wickets_taken;
//fk
private int teamid;
public Players() {
	super();
	// TODO Auto-generated constructor stub
}
public Players(int playerId, String firstname, String laname, Date dob, double batting_avg, int wickets_taken,
		int teamid) {
	super();
	this.playerId = playerId;
	this.firstname = firstname;
	this.laname = laname;
	this.dob = dob;
	this.batting_avg = batting_avg;
	this.wickets_taken = wickets_taken;
	this.teamid = teamid;
}
public int getPlayerId() {
	return playerId;
}
public void setPlayerId(int playerId) {
	this.playerId = playerId;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLaname() {
	return laname;
}
public void setLaname(String laname) {
	this.laname = laname;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
public double getBatting_avg() {
	return batting_avg;
}
public void setBatting_avg(double batting_avg) {
	this.batting_avg = batting_avg;
}
public int getWickets_taken() {
	return wickets_taken;
}
public void setWickets_taken(int wickets_taken) {
	this.wickets_taken = wickets_taken;
}
public int getTeamid() {
	return teamid;
}
public void setTeamid(int teamid) {
	this.teamid = teamid;
}
@Override
public String toString() {
	return "Players [playerId=" + playerId + ", firstname=" + firstname + ", laname=" + laname + ", dob=" + dob
			+ ", batting_avg=" + batting_avg + ", wickets_taken=" + wickets_taken + ", teamid=" + teamid + "]";
}


}
