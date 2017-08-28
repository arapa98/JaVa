package main;
import entities.*;
import java.util.*;
import service.*;
import test.*;

public class Main {
	
	
	
	
	
	
	

	
	public static void main(String args[]) {
	
		Scanner sc= new Scanner(System.in);
		
		Helper help= new Helper();
		
		System.out.println("**********************************************");
		System.out.println("Hi, Welcome to Harry potter world!");
		System.out.println("My name is Magic Jatterva!:) And i can do some amazing works for you!");
		System.out.println("**********************************************");
		
		while( true ) {
			
			
			
			int answer;
			int houseFlag=0;
			int studentFlag=0;
			int schoolFlag=0;
			int professorFlag =0;
			int personFlag =0;
			int courseFlag=0;
			
			System.out.println( "Please tell me which one do you want to enter the setup!");
			System.out.println("1.House service");
			System.out.println("2.Student service");
			System.out.println("3.School service");
			System.out.println("4.Professor service");
			System.out.println("5.Person service");
			System.out.println("6.Course service");
			
			String buffer= sc.nextLine();
			if( help.check(buffer)) {
				answer= help.getInt(buffer);
			}
			else {
				System.out.println("Are you fool my friend?:) Just enter a number between 1-1");
				continue;
			}
			if(answer == 1) {
				houseFlag=1;
			}
			else if( answer == 2) {
				studentFlag=1;
			}
			else if( answer == 3) {
				schoolFlag=1;
			}
			else if( answer == 4) {
				professorFlag=1;
			}
			else if( answer == 5) {
				personFlag=1;
			}
			else if( answer == 6) {
				courseFlag=1;
			}
			else {
				System.out.println("Are you fool my friend?:) Just enter a number between 1-1");
				continue;
			}
			
		
			
		if( houseFlag == 1) {
			HouseService hs= new HouseService();
			hs.getData("HouseDB.txt");
			hs.HouseUI();
			int buf =help.helpUI();
			if(buf==1) {
				continue;
			}
			else if( buf== 2) {
				break;
			}
			else {
				System.out.println("Are you fool my friend?:) Just enter 1 or 2");
			}
		}
		else if( studentFlag == 1) {
			StudentService ss= new StudentService();
			ss.getData("StudentDB.txt");

			ss.studentUI();
			int buf =help.helpUI();
			if(buf==1) {
				continue;
			}
			else if( buf== 2) {
				break;
			}
			else {
				System.out.println("Are you fool my friend?:) Just enter 1 or 2");
			}
		}
		
		else if( schoolFlag == 1) {
			SchoolService ss= new SchoolService();
			ss.getData("SchoolDB.txt");
			ss.schoolUI();
			int buf =help.helpUI();
			if(buf==1) {
				continue;
			}
			else if( buf== 2) {
				break;
			}
			else {
				System.out.println("Are you fool my friend?:) Just enter 1 or 2");
			}
			
		}
		else if( professorFlag == 1) {
			ProfessorService ps= new ProfessorService();
			ps.getData("ProfessorDB.txt");
			ps.professorUI();
			int buf =help.helpUI();
			if(buf==1) {
				continue;
			}
			else if( buf== 2) {
				break;
			}
			else {
				System.out.println("Are you fool my friend?:) Just enter 1 or 2");
			}
		}
		else if( personFlag == 1) {
			PersonService ps = new PersonService();
			ps.getData("PersonDB.txt");
			ps.personUI();
			int buf =help.helpUI();
			if(buf==1) {
				continue;
			}
			else if( buf== 2) {
				break;
			}
			else {
				System.out.println("Are you fool my friend?:) Just enter 1 or 2");
			}
		}
		else if( courseFlag == 1) {
			CourseService cs= new CourseService();
			cs.getData("CourseDB.txt");
			cs.courseUI();
			int buf =help.helpUI();
			if(buf==1) {
				continue;
			}
			else if( buf== 2) {
				break;
			}
			else {
				System.out.println("Are you fool my friend?:) Just enter 1 or 2");
			}
		}
		
	}
		
		System.out.println("Have a good day my friend *__* ");
		System.out.println("**********************************************");
	}
	
}
	

	
	
