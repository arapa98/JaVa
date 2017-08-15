package service;
import entities.*;

public class Course {

	private Student _student;
	
	public Student getStudent() { return _student;}
	public void setStudent(Student student) { _student= student;}
	
	public Course(Student student) {
		_student= student;
	}


}

