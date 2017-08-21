package entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.swing.RowFilter.Entry;

import java.util.*;


public class Professor extends Person{
	
	private Map<Integer, Course> _courses;
	private String _notes;
	
	public void setCourses(Map<Integer, Course> courses) { _courses= courses;}
	public void setNotes(String notes) { _notes= notes;}
	
	public Map<Integer, Course> getCourses(){ return _courses;}
	public String getNotes(){ return _notes;}
	
	public Professor(String name) {
		super( name);
	}
	
	public Professor(String name, House house, BloodStatus blood, School school, String day, Map<Integer, Course> courses, String notes) {
		super( name, house, blood, school, day);
		_courses= courses;
		_notes= notes;
	}
	
	public Professor() {
		super();
		_courses= null;
		_notes= "";
	}
	
	public ArrayList<String> _toString(){
		ArrayList<String> prof= new ArrayList<String>();
		prof.add("Professor " + _name);
		prof.add("house is " + _house.getName());
		prof.add("Blood status is " + _bloodStatus.toString(_bloodStatus));  
		prof.add("birthday is " + _birthday);
	
		
		
		Collection<Course> values= _courses.values();
		Course[] kuft = values.toArray(new Course[values.size()]);
		Set<Integer> keys = _courses.keySet();
		Integer[] maraz = keys.toArray(new Integer[keys.size()]);
		
		prof.add("Taught course: '" + kuft[0].getName() + "' in year: '" + maraz[0] + "'");
		prof.add(_notes);
		
		return prof;
		
	}
}
