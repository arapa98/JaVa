package service;

import java.util.Scanner;
import entities.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

public class SchoolService {
	
	private School _school;
	private Vector<School> _allSchools;
	
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
			File file= new File("SchoolDBW.txt");
			FileOutputStream fos= new FileOutputStream(file);
			BufferedWriter writer= new BufferedWriter( new OutputStreamWriter(fos));
			
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
}