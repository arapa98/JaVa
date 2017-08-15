package service;

import java.util.Scanner;
import entities.*;
import java.util.ArrayList;

public class SchoolService {
	
	private School _school;
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