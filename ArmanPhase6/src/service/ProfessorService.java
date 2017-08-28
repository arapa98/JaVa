package service;
import entities.*;

import java.io.*;

import java.util.*;
import test.*;

public class ProfessorService {
	private Vector<Professor> _allProfessors;
	private Helper help= new Helper();
	private Scanner sc= new Scanner(System.in);
	private ProfessorServiceTest pst= new ProfessorServiceTest();
	
	public ProfessorService() {
		_allProfessors= new Vector<Professor>();
	}
	
	public Vector<Professor> getAllProfessors(){ return _allProfessors;}
	
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
				
				String houseName= file.readLine();
				House house= new House( houseName);
				String blood= file.readLine();
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
				School school = new School( schoolName);
				String birthday= file.readLine();
				String courseName= file.readLine();
				Course course= new Course(courseName);
				int year= Integer.valueOf(file.readLine());
				Map<Integer, Course> courses= new HashMap<Integer, Course>();
				courses.put(year, course);
				String note= file.readLine();
				Professor prof= new Professor(name, house, bs, school, birthday, courses, note);
				_allProfessors.add(prof);
				
				if( "*".equals(file.readLine()))
						continue;
			}
	}
	catch( IOException e) {
		System.err.println("error while reading file " + filename);
	}
	}
	
	public void setData() {
		try {
	
			BufferedWriter writer= new BufferedWriter( new FileWriter("ProfessorDB.txt"));
			
			for( int i=0; i< _allProfessors.size(); i++) {
				Professor prof= _allProfessors.get(i);
				writer.write(prof.getName());
				writer.newLine();
				writer.write(prof.getHouse().getName());
				writer.newLine();
				writer.write(prof.getBloodStatus().toString(prof.getBloodStatus()));
				writer.newLine();
				writer.write(prof.getSchool().getName());
				writer.newLine();
				writer.write(prof.getBirthday());
				writer.newLine();
				

				Collection<Course> values= prof.getCourses().values();
				Course[] course = values.toArray(new Course[values.size()]);
				Set<Integer> keys = prof.getCourses().keySet();
				Integer[] year = keys.toArray(new Integer[keys.size()]);
				
				
				
				
				writer.write(course[0].getName());
				writer.newLine();
				writer.write(year[0] + "");
				writer.newLine();
				writer.write(prof.getNotes());
				writer.newLine();
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

	public Vector<Professor> searchByName(String name){
		
		Vector<Professor> profs= new Vector<Professor>();
		int flag=0;
		for ( int i=0; i<_allProfessors.size(); i++) {
			if( _allProfessors.get(i).getName().contains(name.toLowerCase()) ||  _allProfessors.get(i).getName().contains(name.toUpperCase())){
				profs.add(_allProfessors.get(i));
				flag=1;
			}
		}
		if( flag==1)
			return profs;
		
		return null;
	}
	
	

	public Professor getProfessorByName(String name) {
		for ( int i=0; i<_allProfessors.size(); i++) {
			if( name.equalsIgnoreCase(_allProfessors.get(i).getName())){
				//House house= new House(name);
				return _allProfessors.get(i);
			}
		}
		return null;
	}
	
	public void showProfessor(String name) {
		int flag=0;
		int index=0;
		for( int i=0; i<_allProfessors.size(); i++) {

			if( name.equalsIgnoreCase(_allProfessors.get(i).getName())) {
				flag =1;
				index=i;
				break;
			}
		}
		if( flag ==1 )
			System.out.println(_allProfessors.get(index).toString());
		else 
			System.out.println("Sorry, the professor you want to show doesn't exist!");	
	}
	
	public void showAllProfessors() {
		System.out.println("**********************************************");
		for(int i=0; i<_allProfessors.size(); i++) {
			System.out.println("Professor(" + (i+1) + "): " + _allProfessors.get(i).toString());
		}
		System.out.println("**********************************************");
	}
	
	public void createNewProfessor(Professor p) {
		_allProfessors.add(p);
		this.setData();
		
	}
	
	public void deleteProfessor(Professor p) {

		String name= p.getName();
		if( getProfessorByName(name) != null) {
			for( int i=0; i<_allProfessors.size(); i++) {
				if( _allProfessors.get(i).getName().equalsIgnoreCase(name)) {
					_allProfessors.remove(i);
				}
			}
		}
		else {
			System.out.println("Sorry! The professor doesn't exist at all!");
		}	
		this.setData();	
	}
	
	
	public void editProfessor( Professor p) {
		while( true) {
			String name = p.getName();
			if( getProfessorByName(name) != null) {
				p= getProfessorByName(name);
				
				while (true) {
					System.out.println("Please tell me wold you like to edit each item or not");
					System.out.println("1- The professor's name?");
					System.out.println("1) yes");
					System.out.println("2) no");
					String buffer= sc.nextLine();
					int answer=0;
					if( help.check(buffer)) {
						answer= help.getInt(buffer);
					}
					else {
						System.out.println("Are you fool my friend?:) Just enter 1 or 2");
						continue;
					}
					if( answer == 1) {
						System.out.println("Please enter the professor's new name");
						String newName= sc.nextLine();
						p.setName(newName);
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
					System.out.println("2- Professor's house");
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
					if( answer == 1) {
						System.out.println("Please enter the house's new name");
						String newHouseName = sc.nextLine();
						House newHouse = new House(newHouseName);
						p.setHouse(newHouse);
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
					System.out.println("3- Professor's blood status");
					System.out.println("1) yes");
					System.out.println("2) no");
					String buffer= sc.nextLine();
					int answer=0;
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
						System.out.println("It is case sensitive :)");
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
							System.out.println("Sorry! The blood status is invalid, try again!");
							continue;
						}
						p.setBloodStatus(bs);
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
					System.out.println("4- The school that professor teaches in?");
					System.out.println("1) yes");
					System.out.println("2) no");
					String buffer= sc.nextLine();
					int answer =0;
					if( help.check(buffer)) {
						answer= help.getInt(buffer);
					
					}
					else {
						System.out.println("Are you fool my friend?:) Just enter 1 or 2");
						continue;
					}
					if( answer == 1) {
						System.out.println("Please enter the new school's name");
						String newSchoolName= sc.nextLine();
						School newSchool= new School( newSchoolName);
						p.setSchool(newSchool);
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
					System.out.println("5- The professor's birthday?");
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
					if(answer==1) {
						System.out.println("Please enter the new birthday");
						String birthday = sc.nextLine();
						p.setBirthday(birthday);
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
					System.out.println("6- The professor's note?");
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
						System.out.println("Current professor's note is: '" + p.getNotes() + "'");
						System.out.println("Change it if you want and enter edited note");
						String editedNote= sc.nextLine();
						p.setNotes(editedNote);
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
				
			}
			else {
				System.out.println("Sorry! The professor doesn't exist!");
				break;
			}
			
			break;
			
		}
		this.setData();
	}
	
	
	public void professorUI() {
		while(true) {
			System.out.println("Please tell me what should i do");
			System.out.println("1) Add a professor");
			System.out.println("2) Edit a professor's informations");
			System.out.println("3) Delete a professor");
			System.out.println("4) Show a specific professor's informations");
			System.out.println("5) Show all professors");
			System.out.println("6) Search professor");
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
				pst.createProfessorTest(this);
			}
			else if( answer == 2) {
				pst.editProfessorTest(this);
			}
			else if( answer == 3) {
				pst.deleteProfessorTest(this);
			}
			else if( answer == 4) {
				pst.showProfessor(this);
			}
			else if( answer ==5) {
				pst.showAllProfessors(this);
			}
			else if( answer == 6) {
				pst.searchByNameTest(this);
			}
			else {
				System.out.println("Are you fool my friend?:) Just enter a number betwee 1-6");
				continue;
			}
			break;
		}
	}
	
} 
