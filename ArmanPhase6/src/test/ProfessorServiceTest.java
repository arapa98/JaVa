package test;
import service.*;
import java.util.*;
import entities.*;

public class ProfessorServiceTest {
	private Scanner sc= new Scanner( System.in);
	private Helper help= new Helper();
	
	public void searchByNameTest(ProfessorService ps) {
		System.out.println("Please enter the professor's name key word you want to search for");
		String name= sc.nextLine();
		
		if( ps.searchByName(name) != null) {
			Vector<Professor> profs= ps.searchByName(name);
			System.out.println("**********************************************");
			System.out.println("All the professors that contains key word are:");
			for( int i=0; i< profs.size(); i++) {
				System.out.println("Professor(" + (i+1) + ") : " + profs.get(i).getName());
			}
			System.out.println("**********************************************");
		}
		else {
			System.out.println("Sorry! There is no professor with this name key word");
		}
		
	}
	
	public void getProfessorByName(ProfessorService ps) {
		System.out.println("Please enter the professor name you would like to search: ");
		String name= "";
		name = sc.nextLine();
		if(ps.getProfessorByName(name) != null) {
			System.out.println("The professor exists!");;
		}
		else
			System.out.println("Sorry! The professor doesn't exist!");
	}
	
	public void showProfessor( ProfessorService ps) {
		System.out.println("Please enter the professor's name you want to show");
		String name= sc.nextLine();
		System.out.println("**********************************************");
		ps.showProfessor(name);
		System.out.println("**********************************************");
	}
	
	public void showAllProfessors(ProfessorService ps) {
		ps.showAllProfessors();
	}
	
	public void editProfessorTest(ProfessorService ps) {
		while( true) {
			System.out.println("Please enter the professor's name you would like to edit");
			String name = sc.nextLine();
			if( ps.getProfessorByName(name) != null) {
				Professor p = ps.getProfessorByName(name);
				ps.editProfessor(p);
			}
			else {
				System.out.println("Sorry! The professor doesn't exist!");
				break;
			}	
			break;
		}
	}

	public void deleteProfessorTest(ProfessorService ps) {
		while( true) {
			System.out.println("Please enter the professor's name you would like to delete");
			String name = sc.nextLine();
			if(ps.getProfessorByName(name) != null) {
				Professor p= ps.getProfessorByName(name);
				ps.deleteProfessor(p);
			}
			else {
				System.out.println("Sorry! The professor doesn't exist at all");
				break;
			}
			break;
		}
	}
	
	public void createProfessorTest(ProfessorService ps) {
		School school= new School("");
		House house = new House("");
		String birthday="";
		int year=0;
		Course course = new Course();
		String notes="";
		BloodStatus bs= null;
		
		while(true) {
			System.out.println("Please enter the professor's name you would like to add to system");
			String name = sc.nextLine();
			if(ps.getProfessorByName(name) != null) {
				System.out.println("Sorry! The professor already exists!");
				break;
			}
			else {
				System.out.println("Please enter the professor's house");
				String houseName= sc.nextLine();
				house = new House(houseName);
				System.out.println("Please enter the professor's school");
				String schoolName= sc.nextLine();
				school= new School(schoolName);
				while(true) {
					System.out.println("Please enter the professor's blood status");
					System.out.println("Valid blood statuses are(Pureblood, Halfblood, Muggle, Muggleborn, Squib, Halfbreed)");
					System.out.println("It is case sensitive :)");
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
					else if( "Parthuman".equals(blood))
						bs= BloodStatus.Parthuman;
					else {
						System.out.println("Please enter a valid blood status!");
						continue;
					}
					break;
				}
				
				while(true) {
					System.out.println("Do you know his/her birthday?");
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
					if( answer == 1 ) {
						System.out.println("Please enter the birthday");
						birthday= sc.nextLine();
					}
					else if( answer == 2) {
						birthday= "unknown";
						break;
					}
					else {
						System.out.println("Are you fool my friend?:) Just enter 1 or 2");
						continue;
					}
					break;
				}
				System.out.println("Please enter the course this professor teaches");
				String courseName= sc.nextLine();
				course= new Course(courseName);
				
				while(true) {
					
					try {
						System.out.println("Please enter the year that this professor taught this course");
						year= Integer.parseInt(sc.nextLine());
						break;
						
					}
					catch( NumberFormatException e) {
						System.out.println("Are you fool my friend?:) Enter a valid year");
					}	
				}
				System.out.println("Please enter some notes about this professor");
				notes= sc.nextLine();
			}
		
			Map<Integer, Course> courses = new HashMap<Integer, Course>();
			courses.put(year, course);
			Professor prof= new Professor( name, house, bs, school, birthday, courses , notes);
			ps.createNewProfessor(prof);
			break;
		}
	}
}
