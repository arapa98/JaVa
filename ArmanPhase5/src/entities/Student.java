package entities;

import java.util.Date;
import java.util.Vector;

import java.util.ArrayList;

public class Student extends Person{

	private Vector<Course> _courses;
	private Vector<FinishedCourse> _reportCard;
	
	
	
	public void setCourses( Vector<Course> courses) { _courses= courses;}
	
	public Vector<Course> getCourses(){ return _courses;}
	
	
	public Student(String name) {
		super(name);
		_courses= new Vector<Course>();
		_reportCard= new Vector<FinishedCourse>(); 
	}
	
	public Student(String name, School school) {
		this._name= name;
		this._school= school;
	}
	
	public Student(String name, House house, BloodStatus blood, School school, String day, Vector<Course> courses, Vector<FinishedCourse> card) {
		super(name, house, blood, school, day);
		_courses= courses;
		_reportCard= card;
	}
	

	public Student(String name, House house, BloodStatus blood, School school, String day, Vector<Course> courses) {
		super(name, house, blood, school, day);
		_courses= courses;
		_reportCard= new Vector<FinishedCourse>();
	}
	
	public Student() {
		super();
		_courses= new Vector<Course>();
		_reportCard= new Vector<FinishedCourse>();
	}
	
	
	public ArrayList<String> _toString(){
		ArrayList<String> student= new ArrayList<String>();
		student.add("Student " + _name);
		student.add("house is " + _house.getName());
	/*	String bs= "";
		if( BloodStatus.Halfblood.equals(_bloodStatus))
			bs = "Halfblood";
		else if( BloodStatus.Halfbreed.equals(_bloodStatus))
			bs = "Halfbreed";
		else if( BloodStatus.Muggle.equals(_bloodStatus))
			bs = "Muggle";
		else if( BloodStatus.Muggleborn.equals(_bloodStatus))
			bs = "Muggleborn";
		else if( BloodStatus.Pureblood.equals(_bloodStatus))
			bs = "Pureblood";
		else if( BloodStatus.Squib.equals(_bloodStatus))
			bs = "Squib";
		*/
		
		student.add("Blood Status is " + _bloodStatus.toString(_bloodStatus));
		student.add("school is " + _school.getName());
		student.add("birthday is " + _birthday);
		for( int i=0; i< _courses.size(); i++) {
			student.add("course " + (i+1) + " is " + _courses.get(i).getName());
		}
		
		return student;
	}
	
}
