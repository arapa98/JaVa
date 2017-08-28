package test;
import service.*;
import java.util.*;
import entities.*;

public class CourseServiceTest {
	
	private Scanner sc= new Scanner( System.in);
	private Helper help= new Helper();
	
	public void searchByNameTest(CourseService cs) {
		System.out.println("Please enter the course's name key word you want to search for");
		String name= sc.nextLine();
		
		if( cs.searchByName(name) != null) {
			Vector<Course> courses= cs.searchByName(name);
			System.out.println("**********************************************");
			System.out.println("All the courses that contains key word are:");
			for( int i=0; i< courses.size(); i++) {
				System.out.println("Course(" + (i+1) + ") : " + courses.get(i).getName());
			}
			System.out.println("**********************************************");
		}
		else {
			System.out.println("Sorry! There is no course with this name key word");
		}
		
	}

	public void getCourseByNameTest(CourseService cs) {
		System.out.println("Please enter the course's name you would like to search: ");
		String name= "";
		name = sc.nextLine();
		if(cs.getCourseByName(name) != null) {
			System.out.println("The course exists!");;
		}
		else
			System.out.println("Sorry! The course doesn't exist!");
	}
	
	

	public void showCourseTest( CourseService cs) {
		System.out.println("Please enter the course's name you want to show");
		String name= sc.nextLine();
		System.out.println("**********************************************");
		cs.showCourse(name);
		System.out.println("**********************************************");
	}
	
	public void showAllCoursesTest(CourseService cs) {
		cs.showAllCourses();
	}
	
	
	public void editCourseTest(CourseService cs) {
		System.out.println("Please enter thw course's name you would like to edit");
		String name= sc.nextLine();
		if( cs.getCourseByName(name) != null) {
			Course c= cs.getCourseByName(name);
			cs.editCourse(c);
		}
		else {
			System.out.println("The course doesn't exist!");
		}
	}
	
	public void deleteCourseTest(CourseService cs) {
		System.out.println("Please enter the course's name you would like to delete");
		String name= sc.nextLine();
		if( cs.getCourseByName(name) != null) {
			Course c = cs.getCourseByName(name);
			cs.deleteCourse(c);
		}
		else {
			System.out.println("Sorry! The course doesn't exist at all!");
		}
	}
	
	public void createNewCourseTest(CourseService cs) {
		System.out.println("Please enter the course's name you would like to create");
		String name= sc.nextLine();
		Grades minGrade= null;
		Professor prof= new Professor();
		int year=0;
		Vector<Student> students= new Vector<Student>();
		
		if( cs.getCourseByName(name) != null) {
			System.out.println("Sorry! The course already exists!");
		}
		else {
			while(true) {
				System.out.println("Please enter the min grade to pass the course");
				System.out.println("Valid grades are(A, D, E, O, P, T)");
				System.out.println("*It is case sensitive:)");
				String grade= sc.nextLine(); 
				if("O".equals(grade))
					minGrade= Grades.O;
				else if("A".equals(grade))
					minGrade= Grades.A;
				else if("D".equals(grade))
					minGrade= Grades.D;
				else if("E".equals(grade))
					minGrade= Grades.E;
				else if("P".equals(grade))
					minGrade= Grades.P;
				else if("T".equals(grade))
					minGrade= Grades.T;
				else {
					System.out.println("Please enter a valid grade");
					continue;
				}
				break;
			}
			
			System.out.println("Please enter the course professor's name");
			String profName= sc.nextLine();
			prof.setName(profName);
			System.out.println("Please enter the course's year");
			while(true) {
				try {
					year= Integer.parseInt(sc.nextLine());
					break;
				}
				catch(NumberFormatException e) {
					System.out.println("Are you fool my friend?:) Enter a valid year"); 
				}
			}
			System.out.println("Please enter number of the students");
			int numOfStudents=0;
			while(true) {
				String buffer= sc.nextLine();
				
				if( help.check(buffer)) {
					numOfStudents= help.getInt(buffer);
				}
				else {
					System.out.println("Are you fool my friend?:) Just enter a number between 0-9");
					continue;
				}
				break;
			}
			for( int i=0; i<numOfStudents; i++) {
				System.out.println("Please enter the student(" + (i+1) + ") 's name");
				String studentName = sc.nextLine();
				Student s= new Student(studentName);
				students.add(s);
			}
			
			Course c= new Course( name, minGrade, prof, year, students);
			cs.createNewCourse(c);
		}
	}
	
	
	
}
