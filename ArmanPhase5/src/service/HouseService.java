package service;
import entities.*;
import java.util.*;
import java.io.*;

public class HouseService {
	
	private Vector<House> _allHouses;

	public HouseService() {
		_allHouses= new Vector<House>();
	}
	
	public Vector<House> getAllHouses(){ return _allHouses;}
	
	public void setAllHouses(Vector<House> houses) { _allHouses= houses;}
	
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
				String schoolName= file.readLine();
				School school= new School(schoolName);
				int studentsNum= Integer.valueOf(file.readLine());
				Vector<Student> students= new Vector<Student>();
				for( int i=0; i<studentsNum; i++) {
					String studentName= file.readLine();
					Student s= new Student(studentName);
					students.add(s);
				}
				
				House house= new House(name, school, students);
				_allHouses.addElement(house);
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
			File file = new File("HouseDBW.txt");						// Data base written
			FileOutputStream fos= new FileOutputStream(file);
			BufferedWriter writer= new BufferedWriter(new OutputStreamWriter(fos));
			
			for( int i=0; i<_allHouses.size(); i++) {
				House house= _allHouses.get(i);
				writer.write(house.getName());
				writer.newLine();
				writer.write(house.getSchool().getName());
				writer.newLine();
				writer.write(house.getStudents().size() + "");
				writer.newLine();
				for( int j=0; j<house.getStudents().size(); j++) {
					writer.write(house.getStudents().get(j).getName());
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
			System.err.println("error while reading file");
		}
	}	
}
