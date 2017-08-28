package service;
import entities.*;
import java.util.*;
import java.io.*;
import test.*;
public class HouseService {
	
	private Vector<House> _allHouses;
	private Helper help = new Helper();
	private Scanner sc= new Scanner(System.in);
	
	public HouseService() {
		_allHouses= new Vector<House>();
	}
	
	public Vector<House> getAllHouses(){ return _allHouses;}
	
	public void setAllHouses(Vector<House> houses) { _allHouses= houses;}
	
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
				String schoolName= file.readLine();
				School school= new School(schoolName);
				int studentsNum= Integer.valueOf(file.readLine());
				Vector<Student> students= new Vector<Student>();
				for( int i=0; i<studentsNum; i++) {
					String studentName= file.readLine();
					Student s= new Student(studentName);
					students.add(s);
				}
				
				House house= new House(name, school, students);
				_allHouses.addElement(house);
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

			BufferedWriter writer= new BufferedWriter(new FileWriter("HouseDBW.txt"));
			
			for( int i=0; i<_allHouses.size(); i++) {
				House house= _allHouses.get(i);
				writer.write(house.getName());
				writer.newLine();
				writer.write(house.getSchool().getName());
				writer.newLine();
				writer.write(house.getStudents().size() + "");
				writer.newLine();
				for( int j=0; j<house.getStudents().size(); j++) {
					writer.write(house.getStudents().get(j).getName());
					writer.newLine();
				}
				writer.write("*");
				writer.newLine();
			}
			writer.write("$");
			writer.flush();
			writer.close();
			File file= new File("HouseDB.txt");
			file.delete();
			file= new File("HouseDBW.txt");
			File toFile= new File("HouseDB.txt");
			file.renameTo(toFile);
		}
		
		catch(IOException e) {
			System.err.println("error while reading file");
		}
	}
	
	
	public Vector<House> searchByName(String name) {
		Vector<House> houses= new Vector<House>();
		int flag=0;
		for ( int i=0; i<_allHouses.size(); i++) {
			if( _allHouses.get(i).getName().contains(name.toLowerCase()) ||  _allHouses.get(i).getName().contains(name.toUpperCase())){
				//House house= new House(name);
				houses.add(_allHouses.get(i));
				flag=1;
			}
		}
		if( flag==1)
			return houses;
		
		return null;
	}
	
	
	public void showAllHouse() {
		System.out.println("**********************************************");
		for(int i=0; i<_allHouses.size(); i++) {
			System.out.println("House(" + (i+1) + "): " + _allHouses.get(i).toString());
		}
		System.out.println("**********************************************");
	}
	
	public void showHouse(String name) {
		
		int flag=0;
		int index=0;
		for( int i=0; i<_allHouses.size(); i++) {

			if( name.equals(_allHouses.get(i).getName())) {
				flag =1;
				index=i;
				break;
			}
		}
		if( flag ==1 )
			System.out.println(_allHouses.get(index).toString());
		else 
			System.out.println("Sorry, the house you want to show doesn't exist!");	
	}
	
	
	
	public void deleteHouse(House house) {
		
		//if( searchByName(house.getName()) != null ) {
			try {
				BufferedReader reader= new BufferedReader( new FileReader("HouseDB.txt"));
				BufferedWriter writer= new BufferedWriter( new FileWriter("HouseDBW.txt"));
				String currentLine="";
				String name= house.getName();
				
				while( !(currentLine = reader.readLine()).trim().equals(name)) {
						writer.write(currentLine);
						writer.newLine();
					}
				
				while( !(currentLine =reader.readLine()).trim().equals("*")) {
					
					int i=0;
				}
				
				while ( (currentLine =reader.readLine()) != null) {
					writer.write(currentLine);
					writer.newLine();
				}
				writer.flush();
			
				reader.close();
				writer.close();
				
				
			}
			catch(IOException e) {
				System.err.println("error while reading file");
			}
			File file= new File("HouseDB.txt");
			file.delete();
			file= new File("HouseDBW.txt");
			File toFile= new File("HouseDB.txt");
			file.renameTo(toFile);
			_allHouses.remove(house);
		
	
	}

	
	public void editHouse( House house) {
		
		String name = house .getName();
		Vector<Student> houseStudents= house.getStudents();
		if( getHouseByName( name ) != null) {
			House editedHouse= getHouseByName(name);
			while( true) {
				System.out.println("Please tell me you want to edit each item or not");
				System.out.println("1- House's name?");
				System.out.println("1) yes");
				System.out.println("2) no");
				String buffer= sc.nextLine();
				int answer = 0;
				if( help.check(buffer)) {
					answer = help.getInt(buffer);
				}
				else {
					System.out.println("Are you fool my friend?:) Just enter 1 or 2");
					continue;
				}
				if( answer == 1) {
					System.out.println("Please enter the house's new name");
					String newName= sc.nextLine();
					editedHouse.setName(newName);
				}
				else if(answer == 2){
					break;
				}
				else {
					System.out.println("Are you fool my friend?:) Just enter 1 or 2");
					continue;
				}
			}
				while(true) {
					System.out.println("2- The school owns the house?");
					System.out.println("1) yes");
					System.out.println("2) no");
					String buf= sc.nextLine();
					int _answer=0;
					if( help.check(buf)) {
						_answer = help.getInt(buf);
					}
					else {
						System.out.println("Are you fool my friend?:) Just enter 1 or 2");
						continue;
					}
					if(_answer == 1) {
						System.out.println("Please enter the new school's name");
						String newSchool = sc.nextLine();
						School school = new School (newSchool);
						editedHouse.setSchool(school);
					}
					else if(_answer == 2) {
						break;
					}
					else {
						System.out.println("Are you fool my friend?:) Just enter 1 or 2");
						continue;
					}
					break;
				}
				
				while( true) {
					System.out.println("3- Students leave in this house?");
					System.out.println("1) yes");
					System.out.println("2) no");
					String buf= sc.nextLine();
					int _answer = 0;
					if( help.check(buf)) {
						_answer = help.getInt(buf);
					}
					else {
						System.out.println("Are you fool my friend?:) Just enter 1 or 2");
						continue;
					}
					if(_answer == 1) {
						while( true) {
							System.out.println("Please tell me what should i do");
							System.out.println("1) Add a student to house");
							System.out.println("2) Edit a student");
							System.out.println("3) Delete a student");
							String _buffer= sc.nextLine();
							int response= 0;
							if( help.check(_buffer)) {
								response = help.getInt(_buffer);
							}
							else {
								System.out.println("Are you fool my friend?:) Just enter 1 or 2");
								continue;
							}
							if( response == 1) {
								while( true ) {
									System.out.println("Please enter the student's name you would like to add");
									String addedName = sc.nextLine();
									int flag =0;
									for( int i=0; i< houseStudents.size(); i++) {
										if( addedName.equalsIgnoreCase(houseStudents.get(i).getName())) {
											flag = 1;
											break;
										}
									}
									if( flag != 1) {
										Student s= new Student( addedName);
										houseStudents.add(s);
									}
									else {
										System.out.println("Sorry! The student already exists!");
										break;
									}
							
									break;
								}
							}
							
							else if( response == 2) {
								while( true) {
									System.out.println("Please enter the student's name you would like to edit");
									String editName= sc.nextLine();
									int flag=0; 
									int index =0;
									for(int i=0; i< houseStudents.size(); i++) {
										if( editName.equalsIgnoreCase(houseStudents.get(i).getName())) {
											flag=1;
											index=i;
											break;
										}
									}
									if( flag == 1) {
										System.out.println("Please enter the student's new name");
										String newName= sc.nextLine();
										houseStudents.get(index).setName(newName);
									}
									else {
										System.out.println("Sorry! This house has no student with this name!");
										break; //here
									}
									break;
								}
							}
							
							else if( response == 3) {
								while(true) {
									System.out.println("Please enter the student's name you would like to delete");
									String deleteName = sc.nextLine();
									int flag=0;
									int index=0;
									
									for( int i=0; i<houseStudents.size(); i++) {
										if(deleteName.equalsIgnoreCase(houseStudents.get(i).getName())){
											flag =1;
											index = i;
											break;
										}
									}
									if( flag == 1) {
										houseStudents.remove(index);
									}
									else {
										System.out.println("Sorry! This house has no student with this name at all!");
										break;
									}
									break;
								}
							}
							else {
								System.out.println("Are you fool my friend?:) Just eneter a number between 1-3");
								continue;
							}
							break;
						}
						
					}
					else if(_answer == 2) {
						break;
					}
				break;
				}
				
			}
			
		
		else {
			System.out.println("Sorry! The house doesn't exist!");
		}
		this.setData();
	
	}	
	public void createNewHouse(House house) {
		
					_allHouses.add(house);
					setData();
		
	}
	
	public House getHouseByName(String name) {
		for ( int i=0; i<_allHouses.size(); i++) {
			if( name.equalsIgnoreCase(_allHouses.get(i).getName())){
				//House house= new House(name);
				return _allHouses.get(i);
			}
		}
		return null;
		
		
	}
	
	
	public void HouseUI() {
		
		int answer=0;
		Helper help= new Helper();
		Scanner sc= new Scanner(System.in);
		HouseServiceTest hst= new HouseServiceTest();
		while( true) {
			System.out.println("Please tell me which one you would like to do!");
			System.out.println("1) Create new house");
			System.out.println("2) Edit house");
			System.out.println("3) Delete house");
			System.out.println("4) Show a specific house");
			System.out.println("5) Show all houses");
			System.out.println("6) Search house");

			String buffer = sc.nextLine();
			if(help.check(buffer)) {
				answer= help.getInt(buffer);
			}
			else {
				System.out.println("Are you fool my friend?:) Just enter a number between 1-6");
				continue;
			}
			if(answer == 1 ) {
				hst.createNewHouseTest(this);
			}
			else if( answer == 2) {
				hst.editHouseTest(this);
			}
			else if( answer ==3 ) {
				House house= null;
				hst.deleteHouseTest(this, house);
			}
			else if( answer == 4) {
				hst.showHouseTest(this);
			}
			else if( answer == 5) {
				hst.showAllHouseTest(this);
			}
			else if( answer == 6) {
				hst.searchByNameTest(this);
			}
			else {
				System.out.println("Are you fool my friend?:) Just enter a number between 1-6");
				continue;
			}
			break;
		}
	}

}
