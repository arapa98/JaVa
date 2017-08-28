package test;
import entities.*;
import service.*;
import test.*;
import java.util.*;

public class PersonServiceTest {
	
	private Scanner sc= new Scanner( System.in);
	private Helper help= new Helper();
	
	public void searchByNameTest(PersonService ps) {
		System.out.println("Please enter the person's name key word you want to search for");
		String name= sc.nextLine();
		
		if( ps.searchByName(name) != null) {
			Vector<Person> persons= ps.searchByName(name);
			System.out.println("**********************************************");
			System.out.println("All the persons that contains key word are:");
			for( int i=0; i< persons.size(); i++) {
				System.out.println("Person(" + (i+1) + ") : " + persons.get(i).getName());
			}
			System.out.println("**********************************************");
		}
		else {
			System.out.println("Sorry! There is no person with this name key word");
		}
		
	}
	
	
	public void getPersonByNameTest(PersonService ps) {
		System.out.println("Please enter the person's name you would like to search: ");
		String name= "";
		name = sc.nextLine();
		if(ps.getPersonByName(name) != null) {
			System.out.println("The person exists!");;
		}
		else
			System.out.println("Sorry! The person doesn't exist!");
	}
	
	public void showpersonTest( PersonService ps) {
		System.out.println("Please enter the person's name you want to show");
		String name= sc.nextLine();
		System.out.println("**********************************************");
		ps.showPerson(name);
		System.out.println("**********************************************");
	}
	
	public void showAllPersonsTest(PersonService ps) {
		ps.showAllPersons();
	}
	
	public void editPersonTest(PersonService ps) {
		System.out.println("Please enter thw person's name you would like to edit");
		String name= sc.nextLine();
		if( ps.getPersonByName(name) != null) {
			Person p= ps.getPersonByName(name);
			ps.editPerson(p);
		}
		else {
			System.out.println("The person doesn't exist!");
		}
	}
	
	public void deletePersonTest(PersonService ps) {
		System.out.println("Please enter the person's name you would like to delete");
		String name= sc.nextLine();
		if( ps.getPersonByName(name) != null) {
			Person p = ps.getPersonByName(name);
			ps.deletePerson(p);
		}
		else {
			System.out.println("Sorry! The person doesn't exist at all!");
		}
	}
	
	public void createPersonTest(PersonService ps) {
		System.out.println("Please enter the person's name you would like to create");
		String name= sc.nextLine();
		
		if( ps.getPersonByName(name) != null) {
			System.out.println("Sorry! The person already exists!");
		}
		else {
			Person person = new Person(name);
			String birthday="";
			School school = new School("");
			BloodStatus bs= null;
			
			System.out.println("Please enter the person's house");
			String houseName= sc.nextLine();
			House house = new House(houseName);
			while(true) {
				System.out.println("Please enter the professor's blood status");
				
				String blood= sc.nextLine();
				bs= null;
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
			System.out.println("Please enter the person's school");
			String schoolName= sc.nextLine();
			school.setName(schoolName);
			while(true) {
				System.out.println("Do you know his/her birthday?");
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
					System.out.println("Please enter the birthday");
					birthday = sc.nextLine();
					person.setBirthday(birthday);
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
			person.setBloodStatus(bs);
			person.setHouse(house);
			person.setSchool(school);
			ps.createNewPerson(person);
		}
	}
	
	
	
	
}
