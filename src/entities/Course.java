package entities;

import java.util.Vector;

public class Course {
	private String _name;
	private char _minGrade;
	private String _professorName;
	private int _year;
	private Vector<String> _studentNames;

	public void setName( String name) { _name= name;}
	public void setMinGrade( char grade) { _minGrade= grade;}
	public void setProfessorName( String professor) { _professorName= professor;}
	public void setYear( int year) { _year= year;}
	public void setStudentNames( Vector<String> students) { _studentNames= students;}
	
	public String getName() { return _name;}
	public char getMinGrade() { return _minGrade;}
	public String getProfessorName() { return _professorName;}
	public int getYear() { return _year;}
	public Vector<String> getStudentNames(){ return _studentNames;}
	
	public Course( String name) {
		_name= name;
		_minGrade= 0;
		_professorName= null;
		_year= 0;
		_studentNames= new Vector<String>();
	}
	
	public Course( String name, String professor, char min, int year) {
		_name= name;
		_professorName= professor;
		_minGrade= min;
		_year= year;
		_studentNames= new Vector<String>();
		
		
	}
	public Course(String name, char grade, String professor, int year, Vector<String> students) {
		_name= name;
		_minGrade= grade;
		_professorName= professor;
		_year= year;
		_studentNames= students;
	}
}
