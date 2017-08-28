package service;
import entities.*;

import java.io.*;

import entities.*;
import java.util.*;
import test.*;
import java.io.*;

public class StudentService {


	public void sortToHouse(House house) {
		// i really didn't understand what should this function do! :|
	}
	private Vector<Student> _allStudents;
	private Helper help= new Helper();
	private Scanner sc= new Scanner(System.in);
	private StudentServiceTest sst= new StudentServiceTest();
	
	public StudentService() {
		_allStudents= new Vector<Student>();
	
	}
	public Vector<Student> getAllStudents(){ return _allStudents;}
	
	public void getData(String filename) {
		try {
			BufferedReader file= new BufferedReader( new FileReader(filename));
			int kuft= 1;
			while ( kuft==1) {
				
				String buffer=file.readLine();
				String name= "";
				
				if( ("$").equals(buffer)) {
					file.close();
					break;
				}
				else {
					name= buffer;
				}
			
				
				String houseName= file.readLine();
				
				House house= new House(houseName);
			
				
				String blood = file.readLine();
				BloodStatus bs= null;
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
				String schoolName= file.readLine();
				School school= new School(schoolName);
				String birthday= file.readLine();
			
				int numOfCourses= Integer.valueOf(file.readLine());
				Vector<Course> courses= new Vector<Course>();
				for(int i=0; i<numOfCourses; i++) {
					String _course= file.readLine();
					Course c= new Course(_course);
					courses.add(c);
				}
				
				Student s= new Student(name, house, bs, school, birthday, courses);
				_allStudents.add(s);
				
				if( file.readLine().equals("*"))
					continue;	
			}
		}
			catch( IOException e) {
				System.err.format("error while reading the file");
			}
			
	}
	
	public void setData() {
		try {
		
			BufferedWriter writer= new BufferedWriter(new FileWriter("StudentDB.txt"));
			
			for( int i=0; i<_allStudents.size(); i++) {
				
				Student s= _allStudents.get(i); 
				writer.write(s.getName());
				writer.newLine();
				if(s.getSchool().getHoused()) {
					writer.write(s.getHouse().getName());
					writer.newLine();
				}
				else {
					writer.write("N/A");
					writer.newLine();
				}
				
				writer.write(s.getBloodStatus().toString(s.getBloodStatus()));
				writer.newLine();
				writer.write(s.getSchool().getName());
				writer.newLine();
				writer.write(s.getBirthday());
				writer.newLine();
				writer.write(s.getCourses().size() + "");
				writer.newLine();
				for( int j=0; j< s.getCourses().size(); j++) {
					writer.write(s.getCourses().get(j).getName());
					writer.newLine();
				}
				writer.write("*");
				writer.newLine();
			}
			
			writer.write("$");
			writer.flush();
			writer.close();
		
		
		
		}
		catch( IOException e) {
			System.err.println("error while writing to file");
		}
	}
	
	
	
	public Student getStudentByName(String name) {
		for ( int i=0; i<_allStudents.size(); i++) {
			if( name.equalsIgnoreCase(_allStudents.get(i).getName())){
				//House house= new House(name);
				return _allStudents.get(i);
			}
		}
		return null;
		
	}
	
	public Vector<Student> searchByName(String name){
		Vector<Student> students= new Vector<Student>();
		int flag=0;
		for ( int i=0; i<_allStudents.size(); i++) {
			if( _allStudents.get(i).getName().contains(name.toLowerCase()) ||  _allStudents.get(i).getName().contains(name.toUpperCase())){
				students.add(_allStudents.get(i));
				flag=1;
			}
		}
		if( flag==1)
			return students;
		
		return null;
	}
	
	
	public void showStudent(String name) {
		int flag=0;
		int index=0;
		for( int i=0; i<_allStudents.size(); i++) {

			if( name.equalsIgnoreCase(_allStudents.get(i).getName())) {
				flag =1;
				index=i;
				break;
			}
		}
		if( flag ==1 )
			System.out.println(_allStudents.get(index).toString());
		else 
			System.out.println("Sorry, the student you want to show doesn't exist!");	
	}
	
	public void showAllStudents() {
		System.out.println("**********************************************");
		for(int i=0; i<_allStudents.size(); i++) {
			System.out.println("Student(" + (i+1) + "): " + _allStudents.get(i).toString());
		}
		System.out.println("**********************************************");
	}
	
	public void createNewStudent(Student s) {
		_allStudents.add(s);
		this.setData();
		
	}
	
	
	
	public void deleteStudent(Student s) {
		try {
			BufferedReader reader= new BufferedReader( new FileReader("StudentDB.txt"));
			BufferedWriter writer= new BufferedWriter( new FileWriter("StudentDBW.txt"));
			String currentLine="";
			String name= s.getName();
			if( getStudentByName(name) != null) {
				s= getStudentByName(name);
				while(!(currentLine = reader.readLine().trim()).equals(name)) {
					writer.write(currentLine);
					writer.newLine();
				}
				while(!(currentLine= reader.readLine().trim()).equals("*")) {
					int kuft=1;
				}
				while( (currentLine= reader.readLine()) != null ) {
					writer.write(currentLine);
					writer.newLine();
				}
				writer.flush();
				reader.close();
				writer.close();
				File file= new File("StudentDB.txt");
				file.delete();
				file= new File("StudentDBW.txt");
				File toFile= new File("StudentDB.txt");
				file.renameTo(toFile);
			}
			else
				System.out.println("Sorry! the student doesn't exist at all");
		}
		catch(IOException e) {
			System.err.println("error while deleting the student from file");
		}
		_allStudents.remove(s);
		
	}
	
	
	public void editStudent(Student s) {
		
		String name="";
		String newName="";
		
		while(true) {
			System.out.println("Please enter the student's name you would like to edit");
			name= sc.nextLine();
			
			if( getStudentByName(name) != null) {
				s= getStudentByName(name);
				System.out.println("Please tell me you would like to edit each item or not: ");
				while(true) {
					System.out.println("1- The student's name");
					System.out.println("1) yes");
					System.out.println("2) no");
					String buffer = sc.nextLine();
					int answer;
					if( help.check(buffer)) {
					answer= help.getInt(buffer);
					}
					else {
					System.out.println("Are you fool my friend?:) Just enter 1 or 2");
					continue;
					}
					if( answer == 1) {
						System.out.println("Please enter the new name");
						newName= sc.nextLine();
						s.setName(newName);
					}
					else if ( answer == 2) {
						break;
					}
					else {
						System.out.println("Are you fool my friend?:) Just enter 1 or 2");
						continue;
					}
					
					break;
				}
				ArrayList<House> houses = new ArrayList<House>();
				while( true ) {
					
					System.out.println("2- The house this student leaves in?");
					System.out.println("1) yes");
					System.out.println("2) no");
					String buffer = sc.nextLine();
					int answer;
					if( help.check(buffer)) {
					answer= help.getInt(buffer);
					}
					else {
					System.out.println("Are you fool my friend?:) Just enter 1 or 2");
					continue;
					}
					if( answer == 1) {
						System.out.println("Please enter the new house's name: ");
						String newHouseName = sc.nextLine();
						House house= new House(newHouseName);
						houses.add(house);
						s.setHouse(house);
					}
					else if ( answer == 2) {
						break;
					}
					else {
						System.out.println("Are you fool my friend?:) Just enter 1 or 2");
						continue;
					}
					break;
				}
				
				while(true) {
					System.out.println("3- The student's blood status?");
					System.out.println("1) yes");
					System.out.println("2) no");
					String buffer = sc.nextLine();
					int answer;
					if( help.check(buffer)) {
					answer= help.getInt(buffer);
					}
					else {
					System.out.println("Are you fool my friend?:) Just enter 1 or 2");
					continue;
					}
					if( answer == 1) {
						System.out.println("Please enter the new blood status");
						System.out.println("Valid blood statuses are(Pureblood, Halfblood, Muggle, Muggleborn, Squib, Halfbreed)");
						System.out.println("*It is case sensitive :)");
						String newBlood= sc.nextLine();
						BloodStatus bs= null;
						if("Halfblood".equals(newBlood)) 
							bs= BloodStatus.Halfblood;
						else if( "Muggle".equals(newBlood))
							bs= BloodStatus.Muggle;
					
						else if( "Muggleborn".equals(newBlood))
							bs= BloodStatus.Muggleborn;
						else if( "Halfbreed".equals(newBlood))
							bs= BloodStatus.Halfbreed;
						else if( "Pureblood".equals(newBlood))
							bs= BloodStatus.Pureblood;
						else if( "Squib".equals(newBlood))
							bs= BloodStatus.Squib;
						else {
							System.out.println("Sorry! The blood status is invalid!");
							continue;
						}
						s.setBloodStatus(bs);
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
					System.out.println("4- The school this student study at?");
					System.out.println("1) yes");
					System.out.println("2) no");
					String buffer = sc.nextLine();
					int answer;
					if( help.check(buffer)) {
					answer= help.getInt(buffer);
					}
					else {
					System.out.println("Are you fool my friend?:) Just enter 1 or 2");
					continue;
					}
					if( answer == 1) {
						System.out.println("Please enter the new school's name");
						String newSchool= sc.nextLine();
						School school = new School(newSchool);
						s.setSchool(school);
						school.setHouses(houses);
					}
					else if( answer == 2 ) {
						break;
					}
					else {
						System.out.println("Are you fool my friend?:) Just enter 1 or 2");
						continue;
					}
					break;
				}
				
				while( true ) {
					System.out.println("5-The student's birthday?");
					System.out.println("1) yes");
					System.out.println("2) no");
					String buffer = sc.nextLine();
					int answer;
					if( help.check(buffer)) {
					answer= help.getInt(buffer);
					}
					else {
					System.out.println("Are you fool my friend?:) Just enter 1 or 2");
					continue;
					}
					if( answer == 1) {
						while(true) {
							try {
								System.out.println("Please enter the new birthday");
								String newBirthday= sc.nextLine();
								s.setBirthday(newBirthday);
							}
							catch(NumberFormatException e) {
								System.out.println("Please enter valid birthday");
								continue;
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
				while( true ) {
					System.out.println("6- The courses this student has taken?");
					System.out.println("1) yes");
					System.out.println("2) no");
					String buffer = sc.nextLine();
					int answer;
					if( help.check(buffer)) {
					answer= help.getInt(buffer);
					}
					else {
					System.out.println("Are you fool my friend?:) Just enter 1 or 2");
					continue;
					}
					if( answer == 1 ) {
						CourseService cs= new CourseService();
						cs.getData("CourseDB.txt");
						Vector<Course> courses = s.getCourses();
						while(true) {
							System.out.println("Which one would you like to do?");
							System.out.println("1) Add course");
							System.out.println("2) Delete course");
							System.out.println("3) Edit course");
							String buf= sc.nextLine();
							int _answer;
							if( help.check(buf)) {
								_answer= help.getInt(buf);
							}
							else {
								System.out.println("Are you fool my friend?:) Just enter a number between 1-3");
								continue;
							}
							if( _answer == 1) {
								while( true ) {
									System.out.println("Please enter the course's name you would like to add");
									String courseName= sc.nextLine();
									if(cs.getCourseByName(courseName) != null) {
										System.out.println("Sorry! This student has already taken this course");
										break;
									}
									else {
										Course c= new Course(courseName);
										courses.add(c);
									}
									break;
								}
							}
							else if( _answer == 2) {
								while( true) {
									System.out.println("Please enter the course's name you would like to delete");
									String courseName= sc.nextLine();
									if( cs.getCourseByName(courseName)!= null) {
					
										for( int i=0; i<courses.size(); i++) {
											if( courseName.equals(courses.get(i).getName()) ) {
												courses.remove(i);
											}
										}
									}
									else {
										System.out.println("Sorry! This course doesn't exist at all!");
										break;
									}
									break;
								}
							}
							else if( _answer == 3) {
								while(true) {
									System.out.println("Please enter the course's name you would like to edit");
									String courseName= sc.nextLine();
									if( cs.getCourseByName(courseName) != null ) {
										System.out.println("Please enter the course's new name");
										String newCourseName= sc.nextLine();
										int index;
										for( int i=0; i<courses.size(); i++) {
											if( courses.get(i).getName().equals(courseName)) {
												index = i;
												courses.get(index).setName(newCourseName);
											}
										}
										
									}
									else {
										System.out.println("Sorry! This course doesn't exist!");
										break;
									}
									break;
							
								}
							}
							else {
								System.out.println("Are you fool my friend?:) Just enter a number betwee 1-3");
								continue;
							}
							break;
						}
					}
				break;	
				}
			
			}
			else {
				System.out.println("Sorry! The student doesn't exist in the system!");
				break; //here
			}
			break;
		}
	
	this.setData();
			
	}
	
	
	
	public void studentUI() {
		String buffer="";
		int answer;
		while(true) {
			System.out.println("Please enter which one do you would like to do");
			Scanner sc= new Scanner(System.in);
			System.out.println("1) Add a student to system");
			System.out.println("2) Edit a student's informations");
			System.out.println("3) Delete a student from system");
			System.out.println("4) Show informations of a student");
			System.out.println("5) Show all the students");
			System.out.println("6) Search student");
			buffer= sc.nextLine();
			if(help.check(buffer)) {
				answer= help.getInt(buffer);
			}
			else {
				System.out.println("Are you fool my friend?:) Just enter a number between 1-1");
				continue;
			}
			if( answer == 1) {
				sst.createNewStudentTest(this);
			}
			else if( answer == 2) {
				sst.editStudentTest(this);
			}
			else if( answer == 3) {
				Student s= null;
				sst.deleteStudentTest(this,s);
			}
			else if( answer == 4) {
				sst.showStudentTest(this);
			}
			else if( answer == 5) {
				sst.showAllStudentsTest(this);
			}
			else if( answer == 6) {
				sst.searchByNameTest(this);
			}
			else {
				System.out.println("Are you fool my friend?:) Just enter a number between 1-1");
				continue;
			}
		break;
		}
		
	}
}
