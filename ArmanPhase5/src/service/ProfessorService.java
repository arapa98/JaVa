package service;
import entities.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class ProfessorService {
	private Vector<Professor> _allProfessors;
	
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
			File file= new File("ProfessorDBW.txt");						// Data base written
			FileOutputStream fos= new FileOutputStream(file);
			BufferedWriter writer= new BufferedWriter( new OutputStreamWriter(fos));
			
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



} 
