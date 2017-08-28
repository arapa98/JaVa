package test;

import java.util.*;
import service.*;
import entities.*;

public class SchoolServiceTest {
	
	
	private Scanner sc= new Scanner( System.in);
	private Helper help= new Helper();
	
	public void getSchoolByNameTest(SchoolService ss) {
		System.out.println("Please enter the school you would like to search: ");
		String name= "";
		name = sc.nextLine();
		if(ss.getSchoolByName(name) != null) {
			System.out.println("The school exists!");;
		}
		else
			System.out.println("Sorry! The school doesn't exist!");
	}
	
	public void showSchoolTest(SchoolService ss) {
		while(true) {
			System.out.println("Please enter the school name you would like to show: ");
			String name= sc.nextLine();
			if( ss.getSchoolByName(name) != null) {
				System.out.println("**********************************************");
				ss.showSchool(name);
				System.out.println("**********************************************");
			}
			else {
				System.out.println("Sorry! The school doesn't exist!");
				break; //here
			}	
			break;
		}
	}
	
	public void showAllSchoolsTest(SchoolService ss) {
		ss.showAllSchools();
	}
	public void createNewSchool( SchoolService ss) {
		String name="";
		ArrayList<House> houses= new ArrayList<House>();
		ArrayList<Course> courses = new ArrayList<Course>();
		Vector<Student> students= new Vector<Student>();
		Vector<Professor> profs = new Vector<Professor>();
		String loc="";
		
		while( true) {
			
			System.out.println("Please enter the school's name you would like to create");
			name = sc.nextLine();
			if( ss.getSchoolByName(name) != null) {
				System.out.println("The School already exists!");
				break; //here
			}
			while(true) {
				System.out.println("Please enter the number of school's courses");
				String numBuffer= sc.nextLine();
				int courseNumbers = 0;
				if( help.check(numBuffer)) {
					courseNumbers= help.getInt(numBuffer);
				}
				else {
					System.out.println("Are you fool my friend?:) Just enter a number between 0-9");
					continue;
				}
				for( int i=0; i< courseNumbers; i++) {
					System.out.println("Please enter the course (" + (i+1) + ") 's name");
					String courseName= sc.nextLine();
					Course c= new Course(courseName);
					courses.add(c);
				}
				break;
			}
			while(true) {
				System.out.println("Please enter number of school's students");
				String buffer= sc.nextLine();
				int studentNumbers=0;
				if( help.check(buffer)) {
					studentNumbers= help.getInt(buffer);
				}
				else {
					System.out.println("Are you fool my friend?:) Just enter a number between 0-9");
					continue;
				}
				for( int i=0; i< studentNumbers; i++) {
					System.out.println("Please enter the student (" + (i+1) + ") 's name");
					String studentName= sc.nextLine();
					Student s= new Student(studentName);
					students.add(s);
				}
				break;
			}
			while( true) {
				System.out.println("Please enter number of school's professors");
				String buffer= sc.nextLine();
				int profNumbers= 0;
				if( help.check(buffer)) {
					profNumbers= help.getInt(buffer);
				}
				else {
					System.out.println("Are you fool my friend?:) Just enter the number between 0-9");
					continue;
				}
				for( int i=0; i< profNumbers; i++) {
					System.out.println("Please enter the professor(" + (i+1) + ") 's name");
					String profName= sc.nextLine();
					Professor prof= new Professor(profName);
					profs.add(prof);
				}
				break;
			}
			
			while( true) {
				
				System.out.println("Please enter number of school's houses");
				String buffer= sc.nextLine();
				int houseNumbers=0;
				if( help.check(buffer)) {
					houseNumbers= help.getInt(buffer);
				}
				else {
					System.out.println("Are you fool my friend?:) Just enter a number between 1-9");
					continue;
				}
				for( int i=0; i< houseNumbers; i++) {
					System.out.println("Please enter the house ( " + (i+1) + ") 's name");
					String houseName= sc.nextLine();
					House house= new House(houseName);
					houses.add(house);
				}
				break;
			}
			
			System.out.println("Please enter the school's location");
			loc = sc.nextLine();
			
			School school = new School( name, houses, courses, students, profs, loc);
			ss.createNewSchool(school);
			
			break;
		}
		
		
	}
	
	
	public void editSchoolTest(SchoolService ss) {
		while(true) {
			System.out.println("Please enter the school name you would like to edit!");
		
			Scanner sc= new Scanner(System.in);
			String name= sc.nextLine();
			
			if( ss.getSchoolByName(name) != null ) {
				ss.editSchool(ss.getSchoolByName(name));
				break;
			}
			else {
				System.out.println("Sorry, the school doesn't exists!");
				break; //here
			}
		}
	}
	
	
	
	public void deleteSchoolTest(SchoolService ss) {
		
		while( true) {
			System.out.println("Please enter the school's name you would like to delete");
			String name= sc.nextLine();
			if( ss.getSchoolByName(name) != null) {
				School s= ss.getSchoolByName(name);
				ss.deleteSchool(s);
				
			}
			else {
				System.out.println("Sorry! The school doesn't exist at all!");
				break; //here
			}
			break;
		}
		System.out.println("**********************************************");
		
	}
	
	
	public void searchByNameTest(SchoolService ss) {
		System.out.println("Please enter the school's key word you would like to search for");
		String key= sc.nextLine();
		if( ss.searchByName(key) != null) {
			Vector<School> schools= ss.searchByName(key);
			System.out.println("**********************************************");
			System.out.println("All the schools that contains this key word are:");
			for( int i=0; i< schools.size(); i++) {
				System.out.println("School (" + (i+1) + ") : " + schools.get(i).getName());
			}
			System.out.println("**********************************************");
		}
		else {
			System.out.println("Sorry! There is no school that contains this key word!");
		}
	}
}
