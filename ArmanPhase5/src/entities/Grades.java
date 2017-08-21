package entities;

public enum Grades {
	O, E, A, P, D, T;
	

	
	
	
	public String toString(Grades g) {
		String grade= "";
		if(g.equals(A)) {
			grade= "A";
		}
		else if( g.equals(O)) {
			grade= "O";
		}
		else if( g.equals(D)) {
			grade= "D";
		}
		else if( g.equals(T)) {
			grade= "T";
		}
		else if( g.equals(P)) {
			grade= "P";
		}
		else if( g.equals(E)) {
			grade= "E";
		}
		return grade;
	}
	
}
