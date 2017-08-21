package service;
import entities.*;
import java.util.*;
import java.io.*;

public class CourseService {

	//	private Course _course;
	
	private Vector<Course> _allCourses;
	
	public CourseService() {
		_allCourses= new Vector<Course>();
	}
	public Vector<Course> getAllCourses(){ return _allCourses;}
	
	public void setAllCourses(Vector<Course> courses) { _allCourses= courses;}
	
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
				String grade= file.readLine();
				Grades minGrade= null; 
				if("O".equals(grade))
					minGrade= Grades.O;
				else if("A".equals(grade))
					minGrade= Grades.A;
				else if("D".equals(grade))
					minGrade= Grades.D;
				else if("E".equals(grade))
					minGrade= Grades.E;
				else if("P".equals(grade))
					minGrade= Grades.P;
				else if("T".equals(grade))
					minGrade= Grades.T;
				
				String profName= file.readLine();
				Professor prof= new Professor(profName);
				int year= Integer.valueOf(file.readLine());
				int studentsNum= Integer.valueOf(file.readLine());
				Vector<Student> students= new Vector<Student>();
				for(int i=0; i<studentsNum; i++) {
					String sName= file.readLine();
					Student s= new Student(sName);
					students.add(s);
				}
				Course course= new Course(name, minGrade, prof, year, students);
				_allCourses.add(course);
				
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
			File file= new File("CourseDBW.txt");					// Data base written
			FileOutputStream fos= new FileOutputStream(file);
			BufferedWriter writer= new BufferedWriter( new OutputStreamWriter(fos));
			
			for( int i=0; i< _allCourses.size(); i++) {
				Course course= _allCourses.get(i);
				writer.write(course.getName());
				writer.newLine();
				writer.write(course.getMinGrade().toString(course.getMinGrade()));
				writer.newLine();
				writer.write(course.getProfessor().getName());
				writer.newLine();
				writer.write(course.getYear() + "");
				writer.newLine();
				writer.write(course.getStudent().size() + "");
				writer.newLine();
				for( int j=0; j<course.getStudent().size(); j++) {
					writer.write(course.getStudent().get(j).getName());
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
			System.err.println("error while writing to file");
		}
	}
}
	//	public Course getCourse() { return _course;}

	
	
	
	
	
	//	public void setCourse(Course course) { _course= course;}
	
	/*public CourseService(Course course) {
		_course= course;
	}*/





