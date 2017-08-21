package service;
import java.util.*;
import entities.*;
import java.io.*;

public class PersonService {

	private Vector<Person> _allPersons;

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
			File file= new File("PersonDBW.txt");     						// data base written
 			FileOutputStream fos= new FileOutputStream(file);
			BufferedWriter writer= new BufferedWriter( new OutputStreamWriter(fos));
		
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
	
}
	
	
	
	