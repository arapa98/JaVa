package service;

import java.util.*;
import entities.*;

import java.io.*;

import test.*;
public class SchoolService {
	
	private School _school;
	private Vector<School> _allSchools;
	
	
	private Scanner sc= new Scanner(System.in);
	private Helper help= new Helper();
	private SchoolServiceTest sst= new SchoolServiceTest();
	
	public Vector<School> getAllSchools(){ return _allSchools;}
	public SchoolService() {
		_school= null;
		_allSchools= new Vector<School>();
	}
	
	public void getData(String filename) {
		try {
			BufferedReader file= new BufferedReader( new FileReader(filename));
			
			int kuft= 1;
	
				
			while( kuft==1) {
				String buf= file.readLine();
				String name="";
				if( buf.equals("$")) {
					file.close();
					break;
				}
				
				else {
					name = buf;
				}
				
				
				int numberOfHouses= Integer.valueOf(file.readLine());
				ArrayList<House> houses= new ArrayList<House>();
				for(int i=0; i<numberOfHouses; i++) {
				String houseName= file.readLine();
				House house= new House(houseName);
				houses.add(house);
			}
			
			int numOfStudents= Integer.valueOf(file.readLine());
			Vector<Student> students= new Vector<Student>();
			for( int i=0; i<numOfStudents; i++) {
				String studentName= file.readLine();
				Student student= new Student(studentName);
				students.add(student);	
			}
			
			int numOfProfs= Integer.valueOf(file.readLine());
			Vector<Professor> profs= new Vector<Professor>();
			for( int i=0; i<numOfProfs; i++) {
				String profName= file.readLine();
				Professor prof= new Professor(profName);
				profs.add(prof);
			}
			
			int numOfCourses= Integer.valueOf(file.readLine());
			ArrayList<Course> courses= new ArrayList<Course>();
			for(int i=0; i<numOfCourses; i++) {
				String courseName= file.readLine();
				Course course= new Course(courseName);
				courses.add(course);
			}
			
			String location= file.readLine();
			
			School school= new School(name, houses, courses, students, profs, location);
			_allSchools.add(school);
	
			if( file.readLine().equals("*")) {
				continue;
			}
		
			
		
	
			}
	}
		
		catch(IOException e) {
			System.err.format("Exception occured trying to read");
		}
		
}



	public void setData() {
		try {
		//	BufferedReader reader = new BufferedReader(new FileReader("SchoolDB.txt"));
			
			BufferedWriter writer= new BufferedWriter( new FileWriter("SchoolDB.txt"));
			
			for( int i=0; i< _allSchools.size(); i++) {
				
				School s= _allSchools.get(i);
				writer.write(s.getName());
				writer.newLine();
				writer.write(s.getHouses().size() + "");
				writer.newLine();
				for( int j=0; j< s.getHouses().size(); j++) {
					writer.write(s.getHouses().get(j).getName());
					writer.newLine();
				}
				
				writer.write(s.getNumOfStudents() + "");
				writer.newLine();
				for( int k=0; k< s.getNumOfStudents(); k++ ) {
					writer.write(s.getStudents().get(k).getName());
					writer.newLine();
				}
				
				writer.write(s.getProfessors().size() + "");
				writer.newLine();
				for( int l=0; l<s.getProfessors().size(); l++) {
					writer.write(s.getProfessors().get(l).getName());
					writer.newLine();
				}
				
				writer.write(s.getCourses().size() + "");
				writer.newLine();
				for( int m=0; m<s.getCourses().size(); m++) {
					writer.write(s.getCourses().get(m).getName());
					writer.newLine();
				}
				
				writer.write(s.getLocation());
				writer.newLine();
				
				writer.write("*");
				writer.newLine();
			}
			writer.write("$");
			writer.close();
		}
		catch(IOException e){
			System.err.println("error while writing to file");
		}
	}
			
				
	
	
	
	
	public House sortingHat(Student s) {
			int bravery= 0;
			int dedication= 0;
			int intelligence= 0;
			int ambition= 0;
			School sch= s.getSchool();
			if (true) {// i don't know why when i use (getHoused()==true) it doesn't work :-?
			
				System.out.println("1-Which job you are more interested in?\n");
				System.out.println("1.Jet pilot\n");
				System.out.println("2.Bank employee\n");
				System.out.println("3.Office manager\n");
				Scanner sc= new Scanner(System.in);
				int answer= sc.nextInt();
				if( answer==1)
					bravery++;
				else if ( answer==2)
					dedication++;
				else if( answer==3)
					ambition++;
				System.out.println("2-Which one you prefer to study about?\n");
				System.out.println("1.ghosts\n");
				System.out.println("2.Science\n");
				answer= sc.nextInt();
				if( answer == 1)
					bravery++;
				else if( answer== 2)
					intelligence++;
				System.out.println("3-choose a pet!\n");
				System.out.println("1.Snake\n");
				System.out.println("2.Cat\n");
				System.out.println("3.Parrot\n");
				System.out.println("4.Dog\n");
				answer= sc.nextInt();
				if( answer==1)
					ambition++;
				else if( answer==2)
					bravery++;
				else if( answer==3)
					intelligence++;
				else if( answer==4)
					dedication++;
				System.out.println("4-Which color?\n");
				System.out.println("1.Gold\n");
				System.out.println("2.Bronze\n");
				System.out.println("3.Silver\n");
				System.out.println("4.Black\n");
				answer= sc.nextInt();
				if( answer==1)
					bravery++;
				else if( answer==2)
					intelligence++;
				else if( answer==3)
					ambition++;
				else if( answer==4)
					dedication++;
				System.out.println("5-What do you consider to be your best quality?\n");
				System.out.println("1.Loyalty\n");
				System.out.println("2.Intelligence\n");
				System.out.println("3.Bravery\n");
				System.out.println("4.Ambition\n");
				answer= sc.nextInt();
				if( answer==1)
					dedication++;
				else if( answer==2)
					intelligence++;
				else if( answer==3)
					bravery++;
				else if( answer==4)
					ambition++;
			
				int[] qualities= {0,0,0};
				
				qualities[0]= dedication;
				qualities[1]= intelligence;
				qualities[2]= ambition;
				
				int max= bravery;
				for( int i=0; i<2; i++) {
					if(qualities[i]> max) {
						max= qualities[i];
					}
				}
				
				if(max== bravery) {
					House house= new House("Gryyfindor");
					return house;
				}
				
				else if( max== dedication) {
					House house = new House("Hufflepuff");
					return house;
				}
			
				else if( max== intelligence) {
					House house= new House("Ravenclaw");
					return house;
				}
				
				else if( max== ambition) {
					House house= new House("Slytherin");
					return house;
				}
				
			}
			
			House house= new House("");
			return house;
			
	}
	
	
	public Vector<School> searchByName(String name){
		
		Vector<School> schools= new Vector<School>();
		int flag=0;
		for ( int i=0; i<_allSchools.size(); i++) {
			if( _allSchools.get(i).getName().contains(name.toLowerCase()) ||  _allSchools.get(i).getName().contains(name.toUpperCase())){
				schools.add(_allSchools.get(i));
				flag=1;
			}
		}
		if( flag==1)
			return schools;
		
		return null;
	}
	

	public School getSchoolByName(String name) {
		for ( int i=0; i<_allSchools.size(); i++) {
			if( name.equalsIgnoreCase(_allSchools.get(i).getName())){
				//House house= new House(name);
				return _allSchools.get(i);
			}
		}
		return null;
	}
	
	public void showSchool(String name) {
		int flag=0;
		int index=0;
		for( int i=0; i<_allSchools.size(); i++) {

			if( name.equalsIgnoreCase(_allSchools.get(i).getName())) {
				flag =1;
				index=i;
				break;
			}
		}
		if( flag ==1 )
			System.out.println(_allSchools.get(index).toString());
		else 
			System.out.println("Sorry, the school you want to show doesn't exist!");	
	}
	
	public void showAllSchools() {
		System.out.println("**********************************************");
		for(int i=0; i<_allSchools.size(); i++) {
			System.out.println("School(" + (i+1) + "): " + _allSchools.get(i).toString());
		}
		System.out.println("**********************************************");
	}
	
	public void createNewSchool(School s) {
		_allSchools.add(s);
		this.setData();
		
	}
	
	public void deleteSchool(School s) {

		String name= s.getName();
		if( getSchoolByName(name) != null) {
			for( int i=0; i<_allSchools.size(); i++) {
				if( _allSchools.get(i).getName().equalsIgnoreCase(name)) {
					_allSchools.remove(i);
				}
			}
		}
		else {
			System.out.println("Sorry! The school doesn't exist!");
		}	
		this.setData();	
		
	
	}
	
	public void editSchool(School s) {
		
		String name = s.getName();
	
		
		int index = 0;
		for( int i=0; i<_allSchools.size(); i++) {
			if( name.equalsIgnoreCase(_allSchools.get(i).getName())) {
				index=i;
				break;
			}
		}
		
		Vector<Student> schoolStudents = _allSchools.get(index).getStudents();
		ArrayList<House> schoolHouses = _allSchools.get(index).getHouses();
		Vector<Professor> schoolProfessors= _allSchools.get(index).getProfessors();
		ArrayList<Course> schoolCourses = _allSchools.get(index).getCourses();
		
		if( getSchoolByName(name) != null) {
			System.out.println("Please tell me you would like to edit each item or not");
			while(true) {
				System.out.println("1- School's name?");
				System.out.println("1) yes");
				System.out.println("2) no");
				String buffer= sc.nextLine();
				int answer=0;
				if( help.check(buffer)) {
					answer = help.getInt(buffer);
				}
				else {
					System.out.println("Are you fool my friend?:) Just enter 1 or 2");
					continue;
				}
				if(answer == 1) {
					System.out.println("Please enter the new name");
					String newName= sc.nextLine();
					s.setName(newName);
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
				System.out.println("2- The school's students?");
				System.out.println("1) yes");
				System.out.println("2) no");
				String buffer= sc.nextLine();
				int answer=0;
				if( help.check(buffer)) {
					answer = help.getInt(buffer);
				}
				else {
					System.out.println("Are you fool my friend?:) Just enter 1 or 2");
					continue;
				}
				if( answer ==1 ) {
					while(true) {
						System.out.println("Please tell me what should i do for you");
						System.out.println("1) Add a student to school");
						System.out.println("2) Edit a student");
						System.out.println("3) Delete a student from school");
						String buf = sc.nextLine();
						int _answer=0;
						if( help.check(buf)) {
							_answer = help.getInt(buf);
						}
						else {
							System.out.println("Are you fool my friend?:) Just enter 1 or 2");
							continue;
						}
						if(_answer == 1) {
							System.out.println("Please enter the student's name you would like to add");
							String addedName= sc.nextLine();
							int _flag=0;
							for( int i=0; i< schoolStudents.size();i++) {
								if( schoolStudents.get(i).getName().equalsIgnoreCase(addedName)) {
									_flag=1;
									break;
								}
							}
							if( _flag != 1) {
								Student addedStudent = new Student(addedName);
								schoolStudents.add(addedStudent);
							}
							else {
								System.out.println("Sorry! The student already exists!");
								break; //here
							}
							
						}
						else if( _answer == 2) {
							while( true ) {
								System.out.println("Please enter the student's name you would like to edit");
								String editName= sc.nextLine();
								int flag=0;
								int studentIndex=0;
								for( int i=0; i< schoolStudents.size(); i++) {
									if( schoolStudents.get(i).getName().equalsIgnoreCase(editName)) {
										flag=1;
										studentIndex= i;
										break;
									}
								}
								if( flag == 1) {
									System.out.println("Please enter the student's edited name");
									String eName= sc.nextLine();
									schoolStudents.get(studentIndex).setName(eName);
								}
								else {
									System.out.println("Sorry! This school has no student with this name!");
									break; //here
								}
								
								break;
							}
						}
						else if( _answer == 3) {
							while(true) {
								System.out.println("Please enter the student's name you would like to delete");
								String deleteName= sc.nextLine();
								int flag=0;
								int studentIndex= 0;
								for( int i=0; i< schoolStudents.size(); i++) {
									if( schoolStudents.get(i).getName().equalsIgnoreCase(deleteName)) {
										flag=1;
										studentIndex= i;
										break;
									}
								}
								
								if( flag == 1) {
									Student deleted= schoolStudents.get(studentIndex);
									schoolStudents.remove(deleted);
								}
								else {
									System.out.println("Sorry! This school has no student with this name!");
									break; //here
								}
								break;
							}
						}
						else {
							System.out.println("Are you fool my friend?:) Just enter a number between 1-3");
							continue;
						}
						break;
					}
				}
				
				break;
			}
			
			
			while(true) {
				System.out.println("3- The school's houses?");
				System.out.println("1) yes");
				System.out.println("2) no");
				String buffer= sc.nextLine();
				int answer=0;
				if( help.check(buffer)) {
					answer = help.getInt(buffer);
				}
				else {
					System.out.println("Are you fool my friend?:) Just enter 1 or 2");
					continue;
				}
				if( answer ==1 ) {
					while(true) {
						System.out.println("Please tell me what should i do for you");
						System.out.println("1) Add a house");
						System.out.println("2) Edit a house");
						System.out.println("3) Delete a house");
						String buf = sc.nextLine();
						int _answer=0;
						if( help.check(buf)) {
							_answer = help.getInt(buf);
						}
						else {
							System.out.println("Are you fool my friend?:) Just enter 1 or 2");
							continue;
						}
						if(_answer == 1) {
							while(true) {
								System.out.println("Please enter the house name you would like to add");
								String addedName= sc.nextLine();
								int flag=0;
								
								for( int i=0; i< schoolHouses.size(); i++) {
									if(schoolHouses.get(i).getName().equalsIgnoreCase(addedName)) {
										flag=1;
										break;
									}
								}
								if( flag != 1) {
									House house= new House(addedName);
									schoolHouses.add(house);
								}
								else {
									System.out.println("Sorry! The house already exists!");
									break; //here
								}
								break;
							}
						}
						else if(_answer == 2) {
							while(true) {
								System.out.println("Please enter the house name you would like to edit");
								String editName= sc.nextLine();
								int flag=0;
								int _index=0;
								for( int i=0; i<schoolHouses.size(); i++) {
									if( schoolHouses.get(i).getName().equalsIgnoreCase(editName)) {
										flag=1;
										_index=i;
										break;
									}
								}
								if( flag == 1) {
									System.out.println("Please enter the house's new name");
									String newHouseName= sc.nextLine();
									schoolHouses.get(_index).setName(newHouseName);
									
								}
								else {
									System.out.println("Sorry! The house doesn't exist");
									break;
								
								}
								break;
							}
							
						
						}
						else if(_answer == 3) {
							while(true) {
								System.out.println("Please enter the house name you would like to delete");
								String deletedHouse= sc.nextLine();
								int flag = 0;
								int _index=0;
								for( int i=0; i< schoolHouses.size(); i++) {
									if( schoolHouses.get(i).getName().equalsIgnoreCase(deletedHouse)) {
										flag=1;
										_index=i; 
										break;
									}
								}
								if( flag != 1 && _allSchools.get(index).getHoused()) {
									schoolHouses.remove(_index);
								}
								else {
									System.out.println("Sorry! The house doesn't exist at all!");
									break; //here
								}
								break;
							}
						}
					
						break;
					}
						
				}	
				else if( answer == 2) {
					break;
				}
				else {
					System.out.println("Are you fool my friend?:) Just enter a number between 1-3");
					continue;
				
				}
					
				break;
			
			}
				
			while( true) {
				System.out.println("4- The school's professors?");
				System.out.println("1) yes");
				System.out.println("2) no");
				String buffer = sc.nextLine();
				int answer=0;
				if(help.check(buffer)) {
					answer = help.getInt(buffer);
				}
				else {
					System.out.println("Are you fool my friend?:) Just enter a number between 1-3");
					continue;
				}
				if( answer == 1) {
					while(true) {
						System.out.println("Please tell me what should i do for you:");
						System.out.println("1) Add a professor to school");
						System.out.println("2) Edit a professor's informations");
						System.out.println("3) Delete a proffessor's informations");
						String buf= sc.nextLine();
						int _answer=0;
						if(help.check(buf)) {
							_answer= help.getInt(buf);
						}
						else {
							System.out.println("Are you fool my friend?:) Just enter a number between 1-3");
							continue;
						}
						if(_answer == 1) {
							while(true) {
								System.out.println("Please enter the pofessor's name you would like to add");
								String addedName= sc.nextLine();
								int flag=0;
								for( int i=0; i<schoolProfessors.size(); i++) {
									if( schoolProfessors.get(i).getName().equalsIgnoreCase(addedName)) {
										flag=1;
										break;
									}
								}
								if( flag != 1) {
									Professor addedProf= new Professor(addedName);
									schoolProfessors.add(addedProf);
								}
								else {
									System.out.println("Sorry! The professor already exists!");
									break; //here
								}
								break;
							}
						}
						else if(_answer == 2) {
							while(true) {
								System.out.println("Please enter the professor name you would like to edit");
								String editName= sc.nextLine();
								int flag=0;
								int _index=0;
								for( int i=0; i<schoolProfessors.size(); i++) {
									if(schoolProfessors.get(i).getName().equalsIgnoreCase(editName)) {
										flag=1;
										_index=i;
										break;
									}
								}
								if(flag == 1) {
									System.out.println("Please enter the new professor's name");
									String newName=sc.nextLine();
									schoolProfessors.get(_index).setName(newName);
								}
								else {
									System.out.println("Sorry! This school has no professor with this name!");
									break;
								}
								break;
							}
							
						}
						else if(_answer == 3) {
							while(true) {
								System.out.println("Please enter the professor's name you would like to delete");
								String deletedName= sc.nextLine();
								int flag=0;
								int _index=0;
								
								for( int i=0; i<schoolProfessors.size(); i++) {
									if(schoolProfessors.get(i).getName().equalsIgnoreCase(deletedName)) {
										flag=1;
										_index=i;
										break;
									}
								}
								if( flag == 1) {
									schoolProfessors.remove(_index);
								}
								else {
									System.out.println("Sorry! This school has no professor with this name at all");
									break; //here
								}
								break;
							}
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
				System.out.println("5- School's courses?");
				System.out.println("1) yes");
				System.out.println("2) no");
				String buffer= sc.nextLine();
				int answer=0;
				if( help.check(buffer)) {
					answer = help.getInt(buffer);
				}
				else {
					System.out.println("Are you fool my friend?:) Just enter 1 or 2");
					continue;
				}
				
				if( answer == 1) {
					while(true) {
						System.out.println("Please tell me what should i do");
						System.out.println("1) Add a course");
						System.out.println("2) Edit a course");
						System.out.println("3) Delete a course");
						
						String buf= sc.nextLine();
						int _answer =0;
						if( help.check(buf)) {
							_answer= help.getInt(buf);
						}
						else {
							System.out.println("Are you fool my friend?:) Just enter a number between 1-3");
							continue;
						}
						if(_answer == 1) {
							while(true) {
								System.out.println("Please enter the course's name you would like to add");
								String addedName= sc.nextLine();
								int flag=0;
								for( int i=0; i<schoolCourses.size(); i++) {
									if( schoolCourses.get(i).getName().equalsIgnoreCase(addedName)) {
										flag=1;
										break;
									}
								}
								if( flag != 1) {
									Course addedCourse= new Course(addedName);
									schoolCourses.add(addedCourse);
								}
								else {
									System.out.println("Sorry! The course already exists!");
									break; //here
								}
								
								break;
							}
						}
						else if(_answer == 2) {
							while(true) {
								System.out.println("Please enter the course's name you would like to edit");
								String editName= sc.nextLine();
								int flag=0;
								int _index=0;
								
								for( int i=0; i<schoolCourses.size(); i++) {
									if( schoolCourses.get(i).getName().equalsIgnoreCase(editName)) {
										flag=1;
										_index=i;
									}
								}
								if( flag == 1) {
									System.out.println("Please enter the new course's name");
									String newName= sc.nextLine();
									schoolCourses.get(_index).setName(newName);
								}
								else {
									System.out.println("Sorry! The course doesn't exist!");
									break;
									
								}
								break;
							}
						}
						else if(_answer == 3) {
							while(true) {
								System.out.println("Please enter the course's name you would like to delete");
								String deletedName= sc.nextLine();
								int flag=0;
								int _index=0;
								for( int i=0; i< schoolCourses.size(); i++) {
									if(schoolCourses.get(i).getName().equalsIgnoreCase(deletedName)) {
										flag=1;
										_index=i;
									}
								}
								if( flag == 1) {
									schoolCourses.remove(_index);
								}
								else {
									System.out.println("Sorry! the course doesn't exist at all");
									break;    // here
 								}
								
								break;
							}
						}
						
						
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
				System.out.println("6- The school's location?");
				System.out.println("1) yes");
				System.out.println("2) no");
				String buffer = sc.nextLine();
				int answer=0;
				if( help.check(buffer)) {
					answer= help.getInt(buffer);
				}
				else {
					System.out.println("Are you fool my friend?:) Just enter 1 or 2");
					continue;
				}
				
				if( answer == 1) {
					System.out.println("Please enter the new location");
					String newLoc= sc.nextLine();
					_allSchools.get(index).setLocation(newLoc);
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
		}
		else {
			System.out.println("Sorry! The school doesn't exist at all");
		}
	
	this.setData();
		
	}
	public void schoolUI() {
		
		while(true) {
			System.out.println("Please tell me what should i do");
			System.out.println("1) Add a school");
			System.out.println("2) Edit a school");
			System.out.println("3) Delete a school");
			System.out.println("4) Show a specific school");
			System.out.println("5) Show all schools");
			System.out.println("6) Search school");
			String buffer= sc.nextLine();
			int answer=0;
			if( help.check(buffer)) {
				answer = help.getInt(buffer);
			}
			else {
				System.out.println("Are you fool my friend?:) Just enter a number betwee 1-6");
				continue;
			}
			
			if( answer == 1) {
				sst.createNewSchool(this);
			}
			else if( answer == 2) {
				sst.editSchoolTest(this);
			}
			else if( answer == 3) {
				sst.deleteSchoolTest(this);
			}
			else if( answer == 4) {
				sst.showSchoolTest(this);
			}
			else if( answer == 5) {
				sst.showAllSchoolsTest(this);
			}
			else if( answer == 6) {
				sst.searchByNameTest(this);
			}
			else {
				System.out.println("Are you fool my friend?:) Just enter a number between 1-6");
				continue;
			}
			break;
		}	
	}
}