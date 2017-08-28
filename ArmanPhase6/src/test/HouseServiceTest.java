package test;
import entities.*;
import service.*;
import java.util.*;

public class HouseServiceTest {
	
	public void editHouseTest(HouseService hs) {
		while(true) {
			System.out.println("Please enter the house name you would like to edit!");
		
			Scanner sc= new Scanner(System.in);
			String name= sc.nextLine();
			
			if( hs.getHouseByName(name) != null ) {
				hs.editHouse(hs.getHouseByName(name));
				break;
			}
			else {
				System.out.println("Sorry, the house doesn't exists!");
				break;
			}
		}
	}
	
	public void showHouseTest(HouseService hs) {
		Scanner sc= new Scanner(System.in);
		while(true) {
			System.out.println("Please enter the house name you want to show: ");
			String name = sc.nextLine();
			if( hs.getHouseByName(name) != null) {
				System.out.println("**********************************************");
				hs.showHouse(hs.getHouseByName(name).getName());
				System.out.println("**********************************************");
				break;
			}
			else { 
				System.out.println("Sorry, the house doesn't exist!");
				break;
			}
		}
	}
	
	public void showAllHouseTest(HouseService hs) {
		hs.showAllHouse();
	}
	
	public void deleteHouseTest(HouseService hs, House house) {
		System.out.println("Please enter the name of the house you would like to delete");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();	
		if( hs.getHouseByName(name) != null ) {
			house = hs.getHouseByName(name);
			hs.deleteHouse(house);
		}
		else 
			System.out.println("Sorry! The house doesn't exist at all!");
	}
	
	
	
	public void getHouseByNameTest(HouseService hs) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Please enter the house name you would like to search: ");
		String name= sc.nextLine();
		if(hs.getHouseByName(name) != null ) {
			System.out.println("The house exists!");
		}
		else
			System.out.println("Sorry, the house doesn't exist!");
	}

	public void createNewHouseTest(HouseService hs) {
		Scanner sc= new Scanner(System.in);
		String name= "";
		while(true) {
			System.out.println("Please enter the name of the house you want to create: ");
			name= sc.nextLine();
			if( hs.getHouseByName(name) != null) {
				System.out.println("The house already exists!");
				break;
			}
			else {
				
				System.out.println("Please enter the name of the house school ");
				String schoolName= sc.nextLine();
				School school= new School(schoolName);
				Vector<Student> students= new Vector<Student>();
				
				while( true) {
					System.out.println("Please enter the number of students leave in the house: ");
					
					String buffer= sc.nextLine();
					char[] numBuffer= buffer.toCharArray();
					
					if( numBuffer.length > 1 || (int)(numBuffer[0])>57 || (int)(numBuffer[0])<48) {
						System.out.println("Are you fool my friend? :) please enter a number between 0-9");
						continue;
					}
					
					else {
						int numOfStudents = numBuffer[0] - 48;
						for( int i=0; i< numOfStudents; i++ ) {
							System.out.println("Please enter the student(" + (i+1) + ") name: " );
							String studentName= sc.nextLine();
							Student s= new Student(studentName);
							students.add(s);
							}
						break;
					}
					
				}
				
				House house= new House(name, school, students);
				hs.createNewHouse(house);
			}
				break;
		}
	
	}
	
	
	public void searchByNameTest(HouseService hs) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Please enter the key word of house: ");
		String name= sc.nextLine();
		if( hs.searchByName(name) != null) {
			Vector<House> houses = hs.searchByName(name);
			System.out.println("**********************************************");
			System.out.println("All the houses contains the key word: ");
			for( int i=0; i< houses.size(); i++) {
				System.out.println("House(" + (i+1) + "): " + houses.get(i).getName());
			}
			System.out.println("**********************************************");
		}
		else
			System.out.println("Sorry! There is no house that contains this key word!");
		
	}
	
	
	
	
}
