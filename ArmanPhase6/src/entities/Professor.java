package entities;

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
	
	public String toString(){
		String prof= "";
		prof += "Professor " + _name + ", house is " + _house.getName() + ", Blood status is " + _bloodStatus.toString(_bloodStatus) + ", birthday is " + _birthday;
	
		
		
		Collection<Course> values= _courses.values();
		Course[] kuft = values.toArray(new Course[values.size()]);
		Set<Integer> keys = _courses.keySet();
		Integer[] maraz = keys.toArray(new Integer[keys.size()]);
		
		prof += ", Taught course: '" + kuft[0].getName() + "' in year: '" + maraz[0] + "'" + ", " + _notes;
		
		return prof;
		
	}
}
