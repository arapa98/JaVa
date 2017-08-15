package entities;

import java.util.ArrayList;
import java.util.Vector;

public class School {
	private String _name;
	private int _numOfStudents;
	private boolean _housed;
	private ArrayList<House> _houses;
	private Vector<Student> _students;
	private Vector<Professor> _professors;
	private ArrayList<Course> _courses;
	private String _location;
	
	
	public void setName( String name) { _name= name;}
	public void setNumOfStudents( int num) { _numOfStudents= num;}
	public void setHouses( ArrayList<House> houses) { _houses= houses;}
	public void setCourses( ArrayList<Course> courses) { _courses= courses;}
	public void setStudents( Vector<Student> students) { _students= students;}
	public void setProfessors( Vector<Professor> professors) { _professors= professors;}
	
	public String getName(){ return _name;}
	public int getNumOfStudents(){ return _numOfStudents;}
	public ArrayList<House> getHouseNames(){ return _houses;}
	public ArrayList<Course> getCourseNames(){ return _courses;}
	public Vector<Student> getStudents(){ return _students;}
	public Vector<Professor> getProfessors(){ return _professors;}
	public boolean getHoused() { return _housed;}
	
	public School(String name) {
		_name=name;
		_houses= new ArrayList<House>();
		_courses= new ArrayList<Course>();
		_students= new Vector<Student>();
		_professors= new Vector<Professor>();
		_numOfStudents= 0;
		_housed= false;
		_location= null;
	}
	public School(String name, ArrayList<House> houses, ArrayList<Course> courses, ArrayList<Integer> years, Vector<Student> students, Vector<Professor> professors) {
		_name= name;
		_houses= houses;
		_courses= courses;
		_students= students;
		_professors= professors;
		_location= null;
		if( _students != null) 
			_numOfStudents= _students.size();
		else
			_numOfStudents= 0;
		if( _houses == null || _houses.isEmpty())
			_housed= false;
		else 
			_housed= true;
	}
	
	public School(String name, ArrayList<House> houses, ArrayList<Course> courses, ArrayList<Integer> years, Vector<Student> students, Vector<Professor> professors, String location) {
		_name= name;
		_houses= houses;
		_courses= courses;
		_students= students;
		_professors= professors;
		_location= location;
		if( _students != null) 
			_numOfStudents= _students.size();
		else
			_numOfStudents= 0;
		if( _houses == null || _houses.isEmpty())
			_housed= false;
		else 
			_housed= true;
	}
	
	public School(String name, ArrayList<House> houses, Vector<Student> students) {
		this._name= name;
		this._houses= houses;
		this._students= students;
	}
	
}
