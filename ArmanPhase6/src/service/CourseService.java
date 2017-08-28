package service;
import entities.*;
import java.util.*;
import java.io.*;
import test.*;

public class CourseService {

	//	private Course _course;
	
	private Vector<Course> _allCourses;
	private Scanner sc= new Scanner(System.in);
	private Helper help= new Helper();
	private CourseServiceTest cst= new CourseServiceTest();
	
	public CourseService() {
		_allCourses= new Vector<Course>();
	}
	public Vector<Course> getAllCourses(){ return _allCourses;}
	
	public void setAllCourses(Vector<Course> courses) { _allCourses= courses;}
	
	public void getData(String filename) {
		
		try {
			BufferedReader file= new BufferedReader( new FileReader(filename));
			int kuft =1;
			while( kuft ==1) {
				String buffer= file.readLine();
				String name= "";
				if( "$".equals(buffer)) {
					file.close();
					break;
				}
				else
					name= buffer;
				String grade= file.readLine();
				Grades minGrade= null; 
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
				
				String profName= file.readLine();
				Professor prof= new Professor(profName);
				int year= Integer.valueOf(file.readLine());
				int studentsNum= Integer.valueOf(file.readLine());
				Vector<Student> students= new Vector<Student>();
				for(int i=0; i<studentsNum; i++) {
					String sName= file.readLine();
					Student s= new Student(sName);
					students.add(s);
				}
				Course course= new Course(name, minGrade, prof, year, students);
				_allCourses.add(course);
				
				if("*".equals(file.readLine()))
					continue;
			}
		}
		catch(IOException e) {
			System.err.println("error while reading file");
		}
	}
	
	
	
	public void setData() {
		try {
			
			BufferedWriter writer= new BufferedWriter( new FileWriter("CourseDB.txt"));
			
			for( int i=0; i< _allCourses.size(); i++) {
				Course course= _allCourses.get(i);
				writer.write(course.getName());
				writer.newLine();
				writer.write(course.getMinGrade().toString(course.getMinGrade()));
				writer.newLine();
				writer.write(course.getProfessor().getName());
				writer.newLine();
				writer.write(course.getYear() + "");
				writer.newLine();
				writer.write(course.getStudent().size() + "");
				writer.newLine();
				for( int j=0; j<course.getStudent().size(); j++) {
					writer.write(course.getStudent().get(j).getName());
					writer.newLine();
				}
				writer.write("*");
				writer.newLine();
			}
			writer.write("$");
			writer.flush();
			writer.close();
		}
		catch(IOException e) {
			System.err.println("error while writing to file");
		}
	}
	
	
	
	public Course getCourseByName(String s) {
		for( int i=0; i<_allCourses.size(); i++) {
			if( s.equalsIgnoreCase(_allCourses.get(i).getName())) {
				return _allCourses.get(i);
			}
		}
		return null;
	}
	
	

	public Vector<Course> searchByName(String name){
		
		Vector<Course> courses= new Vector<Course>();
		int flag=0;
		for ( int i=0; i<_allCourses.size(); i++) {
			if( _allCourses.get(i).getName().contains(name.toLowerCase()) ||  _allCourses.get(i).getName().contains(name.toUpperCase())){
				courses.add(_allCourses.get(i));
				flag=1;
			}
		}
		if( flag==1)
			return courses;
		
		return null;
	}
	

	
	public void showCourse(String name) {
		int flag=0;
		int index=0;
		for( int i=0; i<_allCourses.size(); i++) {

			if( name.equalsIgnoreCase(_allCourses.get(i).getName())) {
				flag =1;
				index=i;
				break;
			}
		}
		if( flag ==1 )
			System.out.println(_allCourses.get(index).toString());
		else 
			System.out.println("Sorry, the course you want to show doesn't exist!");	
	}
	
	public void showAllCourses() {
		System.out.println("**********************************************");
		for(int i=0; i<_allCourses.size(); i++) {
			System.out.println("Course(" + (i+1) + "): " + _allCourses.get(i).toString());
		}
		System.out.println("**********************************************");
	}
	
	
	public void createNewCourse(Course c) {
		_allCourses.add(c);
		this.setData();
		
	}
	
	public void deleteCourse(Course c) {

		String name= c.getName();
		if( getCourseByName(name) != null) {
			for( int i=0; i<_allCourses.size(); i++) {
				if( _allCourses.get(i).getName().equalsIgnoreCase(name)) {
					_allCourses.remove(i);
				}
			}
		}
		else {
			System.out.println("Sorry! The course doesn't exist at all!");
		}	
		this.setData();	
	}
	
	public void editCourse( Course c) {
		String name= c.getName();
		if( getCourseByName(name) != null) {
			while(true) {
				System.out.println("Please tell me you would like to edit");
				System.out.println("1- Course's name?");
				System.out.println("1) yes");
				System.out.println("2) no");
				String buffer= sc.nextLine();
				int answer =0;
				if( help.check(buffer)) {
					answer = help.getInt(buffer);
				}
				else {
					System.out.println("Are you fool my friend?:) Just enter 1 or 2");
					continue;
				}
				if( answer == 1) {
					System.out.println("Please enter the new course's name");
					String newName= sc.nextLine();
					c.setName(newName);
				}
				else if( answer == 2) {
					break;
				}
				else {
					System.out.println("Are you fool my friend?:) Just enter 1 or 2");
					continue;
				}
				break;
			}
			while( true) {
				System.out.println("2- Course's min grade to pass?");
				System.out.println("1) yes");
				System.out.println("2) no");
				String buffer = sc.nextLine();
				int answer = 0;
				if( help.check(buffer)) {
					answer = help.getInt(buffer);
				}
				else {
					System.out.println("Are you fool my friend?:) Just enter 1 or 2");
					continue;
				}
				if(answer == 1) {
					while(true) {
						System.out.println("Please enter the new min grade");
						System.out.println("Valid min grades are(A, O, D, E, P, T)");
						String grade= sc.nextLine();
						Grades minGrade= null; 
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
						c.setMinGrade(minGrade);
						break;
					}
				}
				else if( answer == 2) {
					break;
				}
				else {
					System.out.println("Are you fool my friend?:) Just enter 1 or 2");
					continue;
				}
				break;
			}
			while(true) {
				System.out.println("3- Course's professor?");
				System.out.println("1) yes");
				System.out.println("2) no");
				String buffer = sc.nextLine();
				int answer =0;
				if( help.check(buffer)) {
					answer = help.getInt(buffer);
				}
				else {
					System.out.println("Are you fool my friend?:) Just enter 1 or 2");
					continue;
				}
				if( answer == 1) {
					System.out.println("Please enter the new professor's name");
					String profName= sc.nextLine();
					Professor prof= new Professor( profName);
					c.setProfessor(prof);
				}
				else if( answer == 2) {
					break;
				}
				else {
					System.out.println("Are you fool my friend?:) Just enter 1 or 2");
					continue;
				}
				break;
			}
			while(true) {
				System.out.println("4- Course's year?");
				System.out.println("1) yes");
				System.out.println("2) no");
				String buffer = sc.nextLine();
				int answer= 0;
				if(help.check(buffer)) {
					answer = help.getInt(buffer);
				}
				else {
					System.out.println("Are you fool my friend?:) Just enter 1 or 2");
					continue;
				}
				if( answer == 1) {
					System.out.println("Please enter the new year");
					while(true) {
						try {
							int year= sc.nextInt();
							c.setYear(year);
							break;
						}
						catch(NumberFormatException e) {
							System.out.println("Are you fool my friend?:) Just enter a valid year");
						}
						break;
					}
				}
				else if( answer ==2) {
					break;
				}
				else {
					System.out.println("Are you fool my friend?:) Just enter 1 or 2");
					continue;
				}
				break;
			}
			while(true) {
				System.out.println("5- Course's students?");
				System.out.println("1) yes");
				System.out.println("2) no");
				String buffer= sc.nextLine();
				int answer =0;
				if( help.check(buffer)) {
					answer = help.getInt(buffer);
				}
				else {
					System.out.println("Are you fool my friend?:) Just enter 1 or 2");
					continue;
				}
				if( answer == 1) {
					System.out.println("Please tell me what should i do");
					while(true) {
						System.out.println("1) Add a student");
						System.out.println("2) Edit a student's informations");
						System.out.println("3) Delete a student from course");
						String buf = sc.nextLine();
						int _answer = 0;
						if( help.check(buf)) {
							_answer = help.getInt(buf);
						}
						else {
							System.out.println("Are you fool my friend?:) Just enter 1 or 2");
							continue;
						}
						if(_answer == 1) {
							while( true) {
								System.out.println("Please enter the student's name you would like to add");
								String addName= sc.nextLine();
								int flag=0;
								for( int i=0; i<c.getStudent().size(); i++) {
									if( addName.equalsIgnoreCase(c.getStudent().get(i).getName())) {
										flag=1;
										break;
									}
								}
								if( flag != 1) {
									Student s= new Student(addName);
									c.getStudent().add(s);
								}
								else {
									System.out.println("Sorry! The student already exists!");
									break;
								}
								break;
							}
							
						}
						else if(_answer == 2) {
							while(true) {
								System.out.println("Please enter the student you would like to edit");
								String editName= sc.nextLine();
								int flag=0;
								int index=0;
								for( int i=0; i<c.getStudent().size(); i++) {
									if( c.getStudent().get(i).getName().equalsIgnoreCase(editName)){
										flag=1;
										index=i;
										break;
									}
								}
								if( flag == 1) {
									System.out.println("Please enter the new name");
									String newName= sc.nextLine();
									c.getStudent().get(index).setName(newName);
								}
								else {
									System.out.println("Sorry! There is no student with this name!");
									break;
								}
								break;
							}
							
						}
						else if(_answer == 3) {
							while(true) {
								System.out.println("Please enter the student's name you would like to delete");
								String deleteName= sc.nextLine();
								int flag=0;
								int index=0;
								for( int i=0; i< c.getStudent().size(); i++) {
									if( c.getStudent().get(i).getName().equalsIgnoreCase(deleteName)){
										flag=1;
										index=i;
										break;
									}
								}
								if( flag == 1) {
									c.getStudent().remove(index);
								}
								else {
									System.out.println("Sorry! There is no student with this name at all!");
									break;
								}
								break;
							}
						}
						break;
					}
					
				}
				this.setData();
				break;
			}
		}
		else {
			System.out.println("Sorry! The course doesn't exists!");
		}
	}
	
	
	public void courseUI() {
		while(true) {
			System.out.println("Please tell me what should i do");
			System.out.println("1) Add a course");
			System.out.println("2) Edit a course's informations");
			System.out.println("3) Delete a course");
			System.out.println("4) Show a specific course's informations");
			System.out.println("5) Show all courses");
			System.out.println("6) Search course");
			String buffer= sc.nextLine();
			int answer=0;
			if( help.check(buffer)) {
				answer = help.getInt(buffer);
			}
			else {
				System.out.println("Are you fool my friend?:) Just enter a number between 1-6");
				continue;
			}
			if( answer == 1) {
				cst.createNewCourseTest(this);
			}
			else if( answer == 2) {
				cst.editCourseTest(this);
			}
			else if( answer == 3) {
				cst.deleteCourseTest(this);
			}
			else if( answer == 4) {
				cst.showCourseTest(this);
			}
			else if( answer == 5) {
				cst.showAllCoursesTest(this);
			}
			else if( answer == 6) {
				cst.searchByNameTest(this);
			}
			else {
				System.out.println("Are you fool my friend?:) Just enter a number between 1-6");
				continue;
			}
			break;
		}
	}
	
	
	
	
	
	
	
	
	
	
}






