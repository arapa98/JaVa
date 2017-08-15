package entities;

public class Main {
	public static void main(String[] args) {
		String s= "77/07/01";
		String[] splitted= s.split("/");
		
		if ( splitted[0] == "77") 
			System.out.println("hi");
		
	}
}
