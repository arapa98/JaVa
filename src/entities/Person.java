package entities;
import java.util.Date;

public class Person {
	private String _name;
	private String _houseName;
	private String _bloodStatus;
	private String _school;
	private Date _birthday;
	
	public void setName( String name) { _name= name;}
	public void setHouseName( String house) { _houseName= house;}
	public void setBloodStatus( String blood) { _bloodStatus= blood;}
	public void setSchool( String school) { _school= school;}
	public void setBirthday( Date day) { _birthday= day;}
	
	public String getName() { return _name;}
	public String getHouseName() { return _houseName;}
	public String getBloodStatus() { return _bloodStatus;}
	public String getSchool() { return _school;}
	public Date getBirthday() { return _birthday;}
	
	public Person( String name) {
		_name= name;
		_houseName= null;
		_bloodStatus= null;
		_school= null;
	}
	
	public Person(String name, String house, String blood, String school, Date day) {
		_name= name;
		_houseName= house;
		_bloodStatus= blood;
		_school= school;
		_birthday= day;
	}
}