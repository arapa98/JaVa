package main;
import entities.*;
import service.*;
import java.util.ArrayList;
import java.util.Vector;
public class Main {
	public static void main(String args[]) {
		
		House gryf= new House ("Gryffindor");
		House raven= new House ("Ravenclaw");
		House sly= new House ("Slytherin");
		House huff= new House ("Hufflepuff");
		Vector<Student> students= new Vector<>();
		ArrayList<House> houses= new ArrayList<House>();
		houses.add(gryf);
		houses.add(raven);
		houses.add(sly);
		houses.add(huff);
		School hogwarts= new School("Hogwarts", houses, students);
		Student s= new Student("arman", hogwarts);
		SchoolService ss= new SchoolService();
		System.out.println(ss.sortingHat(s).getName());
	}
}
