package service;
import entities.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Vector;

import entities.*;


public class StudentService {

//	private Student _student;
	public void sortToHouse(House house) {
		// i really didn't understand what should this function do! :|
	}
	private Vector<Student> _allStudents;
	
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
				//House house= new House("");
				/*if( ("N/A").equals(houseName)) {
					System.out.println("doesnt have house");
				}
				else {*/
				House house= new House(houseName);
				//}
				
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
			File file = new File("StudentDBW.txt");						// DBW: Data base written
			FileOutputStream fos= new FileOutputStream(file);
			BufferedWriter writer= new BufferedWriter(new OutputStreamWriter(fos));
			
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
	
}

