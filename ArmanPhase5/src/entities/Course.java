package entities;

import java.util.*;

public class Course {
	private String _name;
	private Grades _minGrade;
	private Professor _professor;
	private int _year;
	private Vector<Student> _students;

	public void setName( String name) { _name= name;}
	public void setMinGrade( Grades grade) { _minGrade= grade;}
	public void setProfessor( Professor professor) { _professor= professor;}
	public void setYear( int year) { _year= year;}
	public void setStudentNames( Vector<Student> students) { _students= students;}
	
	public String getName() { return _name;}
	public Grades getMinGrade() { return _minGrade;}
	public Professor getProfessor() { return _professor;}
	public int getYear() { return _year;}
	public Vector<Student> getStudent(){ return _students;}
	
	public Course( String name) {
		_name= name;
		_minGrade= null; 
		_professor= null;
		_year= 0;
		_students= new Vector<Student>();
	}
	
	public Course( String name, Professor professor, Grades grade, int year) {
		_name= name;
		_professor= professor;
		_minGrade= grade;
		_year= year;
		_students= new Vector<Student>();
	}
	
	public Course(String name, Grades grade, Professor professor, int year, Vector<Student> students) {
		_name= name;
		_minGrade= grade;
		_professor= professor;
		_year= year;
		_students= students;
	}
	
	public Course() {
		_name= null;
		_minGrade= null;
		_professor= null;
		_year= 0;
		_students= new Vector<Student>();
	}
	
	public ArrayList<String> _toString() {
		ArrayList<String> course= new ArrayList<String>();
		course.add("Course " + _name);
		course.add("min grade to pass the course is: " + _minGrade);
		course.add("Course professor is " + _professor.getName());
		course.add("in year '" + _year + "'") ;
		for( int i=0; i<_students.size(); i++) {
			course.add(_students.get(i).getName());
		}
		return course;
	}
	
}
