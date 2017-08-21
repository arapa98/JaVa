package entities;

public class FinishedCourse extends Course{
	
	private Grades _grade;
	private boolean _passed;
	
	public void setGrade(Grades grade) {
		_grade= grade;
	}
	
	public void setPassed( boolean passed) {
		if(passed)
			_passed= true;
		else 
			_passed= false;
	}
	
	public Grades getGrade() { return _grade;}
	public boolean getPassed() { return _passed;}
	
	public FinishedCourse(Grades g, boolean b) {
		_grade= g;
		if(b)
			_passed= true;
		else 
			_passed= false;
	}
	public FinishedCourse(String name) {
		super(name);
		_grade=null;
		_passed= true;
	}
	
	public FinishedCourse() {
		_grade= null;
		_passed= false;
	}
}
