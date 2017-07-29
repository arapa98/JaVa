package entities;

import java.util.ArrayList;
import java.util.Vector;

public class School {
	private String _name;
	private int _numOfStudents;
	private boolean _housed;
	private ArrayList<String> _houseNames;
	private ArrayList<String> _courseNames;
	private Vector<String> _studentNames;
	private Vector<String> _professorNames;
	
	public void setName( String name) { _name= name;}
	public void setNumOfStudents( int num) { _numOfStudents= num;}
	public void setHouseNames( ArrayList<String> houses) { _houseNames= houses;}
	public void setCourseNames( ArrayList<String> courses) { _courseNames= courses;}
	public void setStudentNames( Vector<String> students) { _studentNames= students;}
	public void setProfessorNames( Vector<String> professors) { _professorNames= professors;}
	
	public String getName(){ return _name;}
	public int getNumOfStudents(){ return _numOfStudents;}
	public ArrayList<String> getHouseNames(){ return _houseNames;}
	public ArrayList<String> getCourseNames(){ return _courseNames;}
	public Vector<String> getStudentNames(){ return _studentNames;}
	public Vector<String> getProfessorNames(){ return _professorNames;}
	
	
	public School(String name) {
		_name=name;
		_houseNames= new ArrayList<String>();
		_courseNames= new ArrayList<String>();
		_studentNames= new Vector<String>();
		_professorNames= new Vector<String>();
		_numOfStudents= 0;
		_housed= false;
	}
	public School(String name, ArrayList<String> houses, ArrayList<String> courses, ArrayList<Integer> years, Vector<String> students, Vector<String> professors) {
		_name= name;
		_houseNames= houses;
		_courseNames= courses;
		_studentNames= students;
		_professorNames= professors;
		if( _studentNames != null) 
			_numOfStudents= _studentNames.size();
		else
			_numOfStudents= 0;
		if( houses == null || houses.isEmpty())
			_housed= false;
		else 
			_housed= true;
	}
}
