package entities;

import java.util.Date;
import java.util.Vector;

public class Student extends Person{

	private Vector<Course> _courses;
	private Vector<FinishedCourse> _reportCard;
	
	
	public Student(String name) {
		super(name);
		_courses= new Vector<Course>();
		_reportCard= new Vector<FinishedCourse>(); 
	}
	
	public Student(String name, House house, BloodStatus blood, School school, String day, Vector<Course> courses, Vector<FinishedCourse> card) {
		super(name, house, blood, school, day);
		_courses= courses;
		_reportCard= card;
	}
	
	public Student() {
		super();
		_courses= new Vector<Course>();
		_reportCard= new Vector<FinishedCourse>();
	}
}
