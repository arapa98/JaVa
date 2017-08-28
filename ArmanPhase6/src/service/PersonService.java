package service;
import java.util.*;
import entities.*;
import java.io.*;
import test.*;

public class PersonService {

	private Vector<Person> _allPersons;
	private Scanner sc= new Scanner(System.in);
	private Helper help= new Helper();
	private PersonServiceTest pst= new PersonServiceTest();
	
	public PersonService() {
		_allPersons= new Vector<Person>();
	}
	
	public Vector<Person> getAllPersons(){ return _allPersons;}
	
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
				House house= new House(houseName);
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
				else if( "Parthuman".equals(blood))
					bs= BloodStatus.Parthuman;
				else
					bs= null;
				String schoolName= file.readLine();
				School school= new School(schoolName);
				String birthday= file.readLine();
				Person person= new Person(name, house, bs, school, birthday);
				_allPersons.add(person);
				
				if( "*".equals(file.readLine()))
					continue;
	
			}
			
		}
		
		catch(IOException e){
			System.err.println("error while reading file");
		}


	}

	public void setData() {
		try {
			BufferedWriter writer= new BufferedWriter( new FileWriter("PersonDB.txt"));
		
			for( int i=0; i< _allPersons.size(); i++) {
				Person person= _allPersons.get(i);
				writer.write(person.getName());
				writer.newLine();
				writer.write(person.getHouse().getName());
				writer.newLine();
				writer.write(person.getBloodStatus().toString(person.getBloodStatus()));
				writer.newLine();
				writer.write(person.getSchool().getName());
				writer.newLine();
				writer.write(person.getBirthday());
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
	
	
	
	public Vector<Person> searchByName(String name){
		
		Vector<Person> persons= new Vector<Person>();
		int flag=0;
		for ( int i=0; i<_allPersons.size(); i++) {
			if( _allPersons.get(i).getName().contains(name.toLowerCase()) ||  _allPersons.get(i).getName().contains(name.toUpperCase())){
				persons.add(_allPersons.get(i));
				flag=1;
			}
		}
		if( flag==1)
			return persons;
		
		return null;
	}
	
	public Person getPersonByName(String name) {
		for ( int i=0; i<_allPersons.size(); i++) {
			if( name.equalsIgnoreCase(_allPersons.get(i).getName())){
				//House house= new House(name);
				return _allPersons.get(i);
			}
		}
		return null;
	}
	
	
	public void showPerson(String name) {
		int flag=0;
		int index=0;
		for( int i=0; i<_allPersons.size(); i++) {

			if( name.equalsIgnoreCase(_allPersons.get(i).getName())) {
				flag =1;
				index=i;
				break;
			}
		}
		if( flag ==1 )
			System.out.println(_allPersons.get(index).toString());
		else 
			System.out.println("Sorry, the person you want to show doesn't exist!");	
	}
	
	public void showAllPersons() {
		System.out.println("**********************************************");
		for(int i=0; i<_allPersons.size(); i++) {
			System.out.println("Person(" + (i+1) + "): " + _allPersons.get(i).toString());
		}
		System.out.println("**********************************************");
	}
	
	
	public void createNewPerson(Person p) {
		_allPersons.add(p);
		this.setData();
		
	}
	
	public void deletePerson(Person p) {

		String name= p.getName();
		if( getPersonByName(name) != null) {
			for( int i=0; i<_allPersons.size(); i++) {
				if( _allPersons.get(i).getName().equalsIgnoreCase(name)) {
					_allPersons.remove(i);
				}
			}
		}
		else {
			System.out.println("Sorry! The person doesn't exist at all!");
		}	
		this.setData();	
	}
	
	public void editPerson( Person p) {
		String name = p.getName();
		if( getPersonByName(name) != null) {
			while( true) {
				System.out.println("Please tell me you would like to edit each item or not");
				System.out.println("1- Person's name?");
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
					System.out.println("Please enter the new name");
					String newName= sc.nextLine();
					p.setName(newName);
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
				System.out.println("2- The person's house?");
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
				if( answer ==1 ) {
					System.out.println("Please enter the new house's name");
					String newHouseName= sc.nextLine();
					House house= new House( newHouseName);
					p.setHouse(house);
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
				System.out.println("3- Person's blood status");
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
				if( answer ==1) {
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
				System.out.println("4- Person's school?");
				System.out.println("1) yes");
				System.out.println("2) no");
				String buffer =sc.nextLine();
				int answer =0;
				if( help.check(buffer)) {
					answer = help.getInt(buffer);
				}
				else {
					System.out.println("Are you fool my friend?:) Just enter 1 or 2");
					continue;

				}
				if(answer == 1) {
					System.out.println("Please enter the new school's name");
					String newSchoolName= sc.nextLine();
					School school= new School(newSchoolName);
					p.setSchool(school);
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
				System.out.println("5- Person's birthday?");
				System.out.println("1) yes");
				System.out.println("2) no");
				String buffer= sc.nextLine();
				int answer = 0;
				if( help.check(buffer)) {
					answer = help.getInt(buffer);
				}
				else {
					System.out.println("Are you fool my friend?:) Just enter 1 or 2");
					continue;
				}
				if( answer == 1) {
					System.out.println("Please enter the new birthday");
					String newBirthday= sc.nextLine();
					p.setBirthday(newBirthday);
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
			this.setData();
		}
		else {
			System.out.println("The person doesn't exist!");
		}
		
	}
	
	
	
	public void personUI() {
		while(true) {
			System.out.println("Please tell me what should i do");
			System.out.println("1) Add a person");
			System.out.println("2) Edit a person's informations");
			System.out.println("3) Delete a person");
			System.out.println("4) Show a specific person's informations");
			System.out.println("5) Show all persons");
			System.out.println("6) Search person");
			String buffer=sc.nextLine();
			int answer =0;
			if( help.check(buffer)) {
				answer = help.getInt(buffer);
			}
			else {
				System.out.println("Are you fool my friend?:) Just enter a number between 1-6");
				continue;
			}
			if( answer == 1) {
				pst.createPersonTest(this);
			}
			else if( answer == 2) {
				pst.editPersonTest(this);
			}
			else if( answer == 3) {
				pst.deletePersonTest(this);
			}
			else if( answer == 4) {
				pst.showpersonTest(this);
			}
			else if( answer == 5) {
				pst.showAllPersonsTest(this);
			}
			else if( answer == 6) {
				pst.searchByNameTest(this);
			}
			else {
				System.out.println("Are you fool my friend?:) Just enter a number between 1-6");
				continue;
			}
			break;
		}
	}
	
	
}
	
	
	
	