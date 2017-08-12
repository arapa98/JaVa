package entities;

public enum Grades {
	O("Outstanding"), E("Exceeds Excpectations"), A("Acceptable"), P("Poor"), D("Dreadfull"), T("Troll");
	
	private String str;
	private Grades(String s) {
		str= s;
	}
	
	public String getStr() { return str;}
	
	
}
