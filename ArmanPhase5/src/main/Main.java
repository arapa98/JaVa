package main;
import entities.*;
import service.*;
import java.util.ArrayList;
import java.util.Vector;
public class Main {
	public static void main(String args[]) {
		
		
	// ****************************************************** test the schoolservice get and set Data methods********************************************************
		
	
		SchoolService ss= new SchoolService();
		ss.getData("SchoolDB.txt");
		Vector<School> schools= ss.getAllSchools();
		for ( int i=0; i<schools.size(); i++) 
			System.out.println(schools.get(i).toString());
		System.out.println("\n");
		ss.setData();
		
		
		// *************************************************** tets the StudentService get and set Data methods *****************************************************
		
		StudentService stus= new StudentService();
		stus.getData("StudentDB.txt");
		Vector<Student> students= stus.getAllStudents();
		for(int i=0; i< students.size(); i++)
			System.out.println(students.get(i).toString());
		System.out.println("\n");
		stus.setData();
	
		
		
		ProfessorService ps= new ProfessorService();
		ps.getData("ProfessorDB.txt");
		Vector<Professor> profs= ps.getAllProfessors();
		for( int i=0; i< profs.size(); i++)
			System.out.println(profs.get(i).toString());
		System.out.println("\n");
		ps.setData();
		
		
		
		
		//*********************************************************** test the StudentService get and set Data methods *************************************************
		PersonService persev= new PersonService();
		persev.getData("PersonDB.txt");
		Vector<Person> persons= persev.getAllPersons();
		for( int i=0; i<persons.size(); i++)						
			System.out.println(persons.get(i).toString());
		System.out.println("\n");
		persev.setData();
	
		//*********************************************************** test the CourseService get and set method ********************************************************
		CourseService cs= new CourseService();
		cs.getData("CourseDB.txt");
		Vector<Course> courses= cs.getAllCourses();
		for(int i=0; i<courses.size(); i++) 
			System.out.println(courses.get(i).toString());
		System.out.println("\n");
		cs.setData();
	
	
		HouseService hs= new HouseService();
		hs.getData("HouseDB.txt");
		Vector<House> houses= hs.getAllHouses();
		for( int i=0; i<houses.size(); i++) 
			System.out.println(houses.get(i).toString());
		System.out.println("\n");
		hs.setData();
	
	
	}
	
	
}