package entities;

import java.util.ArrayList;

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
	public void setBirthday( String day) { 
		if(checkDate(day)) 
			_birthday= day;
		else
			System.out.println("date is not valid");
	}
	
	public String getName() { return _name;}
	public House getHouse() { return _house;}
	public BloodStatus getBloodStatus() { return _bloodStatus;}
	public School getSchool() { return _school;}
	public String getBirthday() { return _birthday;}
	private boolean checkDate( String date) {
		String[] splitted= date.split("/");
		int year= Integer.valueOf( splitted[0]);
		int month= Integer.valueOf( splitted[1]);
		int day= Integer.valueOf( splitted[2]);
		if ( month>12 || (month<6 && day>31) || (month>6 && day>30))
			return false;
		else 
			return true;
		
	}
	
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
	
	public ArrayList<String> _toString(){
		ArrayList<String> person= new ArrayList<String>();
		person.add("Person " + _name);
		person.add("house is " + _house.getName());
		person.add("blood status is " + _bloodStatus.toString(_bloodStatus));
		person.add("school is " + _school.getName());
		person.add("birthday is " + _birthday);
		return person;
		
	}
}