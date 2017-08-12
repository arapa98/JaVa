package entities;

import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;

public class House{
	
	private String _name;
	private School _school;
	private Vector<Student> _students;
	private Professor _headTeacher;
	private ArrayList<String> _qualities;
	private Map<Integer, Student> _prefects;
	
	public void setName( String name) { _name= name;}
	public void setSchool( School school) { _school= school;}
	public void setStudents( Vector<Student> students) { _students= students;}
	public void setHeadTeacher( Professor headTeacher) { _headTeacher= headTeacher;}
	public void setQualities( ArrayList<String> qualities) { _qualities= qualities;}
	public void setPrefects( Map<Integer, Student> prefects) { _prefects= prefects;}
	
	public String getName() { return _name;}
	public School getSchool() { return _school;}
	public Vector<Student> getStudents(){ return _students;}
	public Professor getHeadTeacher() { return _headTeacher;}
	public ArrayList<String> getQualities(){ return _qualities;}
	public Map<Integer, Student> getPrefects(){ return _prefects;}
	
	
}