package entities;
import java.util.*;


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
	
	
	public String toString(){
		String student= "";
		student += "Student " + _name + ", house is " + _house.getName() + ", Blood Status is " + _bloodStatus.toString(_bloodStatus) + ", school is " + _school.getName() + ", birthday is " + _birthday + ", ";
		student += "courses(" + _courses.size() + ") : "; 
		for( int i=0; i< _courses.size()-1 ; i++) {
			student += _courses.get(i).getName() + ", ";
		}
		student += _courses.get(_courses.size()-1).getName();
		return student;
	}
	
}
