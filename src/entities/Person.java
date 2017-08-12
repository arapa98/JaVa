package entities;

public class Person {
	protected String _name;
	protected House _house;
	protected BloodStatus _bloodStatus;
	protected School _school;
	protected String _birthday;
	
	public void setName( String name) { _name= name;}
	public void setHouse( House house) { _house= house;}
	public void setBloodStatus( BloodStatus status) { _bloodStatus= status;}
	public void setSchool( School school) { _school= school;}
	public void setBirthday( String day) { _birthday= day;}
	
	public String getName() { return _name;}
	public House getHouse() { return _house;}
	public BloodStatus getBloodStatus() { return _bloodStatus;}
	public School getSchool() { return _school;}
	public String getBirthday() { return _birthday;}
	public Person( String name) {
		_name= name;
		_house= null;
		_bloodStatus= null;
		_school= null;
		_birthday= null;
	}
		
	public Person(String name, House house, BloodStatus status	, School school, String day) {
		_name= name;
		_house= house;
		_bloodStatus= status;
		_school= school;
		_birthday= day;
	}
	
	public Person() {
		_name= null;
		_house= null;
		_bloodStatus= null;
		_school= null;
		_birthday= null;
	}
}