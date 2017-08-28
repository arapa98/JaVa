package service;
import java.util.*;

public class Helper {

	public boolean check( String answer) {

		
		char[] buffer= answer.toCharArray();
		
		if( buffer.length > 1 || (int)(buffer[0])>57 || (int)(buffer[0])<48) {
			//System.out.println("Are you fool my friend? :) please enter a number between 0-9");
			return false;
			
		}
		
		return true;	
	}
	
	public int getInt(String buffer) {
		int answer=0;
		char[] buf= buffer.toCharArray();
		answer= (int) buf[0] - 48; 
		return answer;
	}
	
	public int helpUI() {
		Scanner sc= new Scanner(System.in);
		int answer;
		while(true) {
			System.out.println("Please tell me what would you like to do now:)");
			System.out.println("1) back to main menu");
			System.out.println("2) exit");
			String buffer= sc.nextLine();
			
			if( check(buffer)) {
				answer= getInt(buffer);
			}
			else {
				System.out.println("Are you fool my friend?:) Just enter 1 or 2");
				continue;
			}
			break;
		}
		System.out.println("**********************************************");
		return answer;
	}

}
