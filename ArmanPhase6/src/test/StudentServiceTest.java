package test;
import service.*;
import java.util.*;
import entities.*;

public class StudentServiceTest {
	
	
	
	
	
	
	private Helper help= new Helper();
	private Scanner sc= new Scanner(System.in);
	//private StudentService ss= new StudentService();
	
	
	
	public void getStudentByNameTest(StudentService ss) {
		System.out.println("Please enter the student you would like to search: ");
		String name= "";
		name = sc.nextLine();
		if(ss.getStudentByName(name) != null) {
			System.out.println("The student exists!");;
		}
		else
			System.out.println("Sorry! The student doesn't exist!");
	}

	public void showStudentTest(StudentService ss) {
		while(true) {
			System.out.println("Please enter the student name you would like to show: ");
			String name= sc.nextLine();
			if( ss.getStudentByName(name) != null) {
				System.out.println("**********************************************");
				ss.showStudent(name);
				System.out.println("**********************************************");
			}
			else {
				System.out.println("Sorry! The student doesn't exist!");
				break;
			}	
			break;
		}
	}
	
	public void showAllStudentsTest(StudentService ss) {
		ss.showAllStudents();
	}
	
	public void createNewStudentTest(StudentService ss) {
		Scanner sc= new Scanner(System.in);
		String name= "";
		BloodStatus bs= null;
		String birthday="";
		Vector<Course> courses= new Vector<Course>();
		
		while(true) {
			System.out.println("Please enter the name of the student you want to create: ");
			name= sc.nextLine();
			if( ss.getStudentByName(name) != null) {
				System.out.println("The student already exists!");
				break;
			}
			else {
				System.out.println("Please enter the name of the house the student leave in: ");
				String houseName= sc.nextLine();
				House house= new House(houseName);
				while(true) {
					System.out.println("Please enter the student's blood status");
					String blood= sc.nextLine();
					
					if("Halfblood".equals(blood)) 
						bs= BloodStatus.Halfblood;
					else if( "Muggle".equals(blood))
						bs= BloodStatus.Muggle;
					else if( "Muggleborn".equals(blood))
						bs= BloodStatus.Muggleborn;
					else if( "Halfbreed".equals(blood))
						bs= BloodStatus.Halfbreed;
					else if( "Pureblood".equals(blood))
						bs= BloodStatus.Pureblood;
					else if( "Squib".equals(blood))
						bs= BloodStatus.Squib;
					else {
						System.out.println("Sorry! The blood status is not valid!");
						continue;
					}
					break;
				}		
				String schoolName="";
				System.out.println("Please enter the school name");
				schoolName= sc.nextLine();
				School school= new School(schoolName);
				ArrayList<House> houses= new ArrayList<House>();
				houses.add(house);
				school.setHouses(houses);
				System.out.println(school.getHoused());
				while(true) {
					System.out.println("Do you know his/her birthday");
					System.out.println("1) yes");
					System.out.println("2) no");
					String buffer= sc.nextLine();
					int answer;
					if( help.check(buffer)) {
						answer= help.getInt(buffer);
					}
					else {
						System.out.println("Are you fool my friend?:) Just enter 1 or 2");
						continue;
					}
					if( answer == 1) {
						System.out.println("Enter the birthday: ");
						birthday= sc.nextLine();
					}
					else
						birthday= "unknown";
					break;
				}
				
				while( true) {
					System.out.println("Please enter the number of courses that this student has taken");
					String buffer=sc.nextLine();
				
					int answer=0;
					if( help.check(buffer)) {
						answer= help.getInt(buffer);
					}
					else {
						System.out.println("Are you fool my friend?:) Just enter a number between 0-9"); 
						continue;
					}
						
					for( int i=0; i<answer; i++) {
						System.out.println("Please enter the course " + (i+1) + " name");
						String courseName= sc.nextLine();
						Course c= new Course(courseName);
						courses.add(c);
					}	
					break;
				}
				Student student= new Student(name, house, bs, school, birthday, courses);
				ss.createNewStudent(student);
				
				break;
			}
		}
	}
	
	
	public void deleteStudentTest(StudentService ss, Student s) {
		while(true) {
			System.out.println("Please enter the student name you would like to delete");
			String name= sc.nextLine();
			if( ss.getStudentByName(name) != null) {
				s= ss.getStudentByName(name);
				ss.deleteStudent(s);
			}
			else {
				System.out.println("Sorry! The student doesn't exist at all!");
				break;
			}
			break;
		}
		System.out.println("**********************************************");
	}
	
	
	public void editStudentTest( StudentService ss) {
		Student s= null;
		ss.editStudent(s);
	}
	
	public void searchByNameTest(StudentService ss) {
		System.out.println("Please enter the key word of student's name you want to search: ");
		String name= sc.nextLine();
		if( ss.searchByName(name) != null) {
			Vector<Student> students = ss.searchByName(name);
			System.out.println("**********************************************");
			System.out.println("All the students contains the key word: ");
			for( int i=0; i< students.size(); i++) {
				System.out.println("Student(" + (i+1) + "): " + students.get(i).getName());
			}
			System.out.println("**********************************************");
		}
		else
			System.out.println("Sorry! There is no house that contains this key word!");
		
	}
		
}
