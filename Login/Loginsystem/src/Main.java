
import java.io.IOException;
import java.sql.Date;

public class Main {
	public static Admin a=new Admin("1");
	public static void init() {
		
	}
	public static User einlogen(boolean benutzer,String name,String passwd) throws IOException {
		
		
		a.rezeptionistenhinzufugen("Klaus", "Klaus", "Klausi123");
		CsvFileReader.readCsvFile("Login.csv");
		if (benutzer == true) {//csv
		/*	BufferedReader fileReader = new BufferedReader(new FileReader("Login.csv"));
			fileReader.readLine();
			String COMMA_DELIMITER=",";
			String line=fileReader.readLine();
			
			while ((line = fileReader.readLine()) != null) {
				String[] tokens = line.split(COMMA_DELIMITER);
				if (tokens.length > 0) {
					Rezeptionist rezeptionist = new Rezeptionist(Integer.parseInt(tokens[0]), tokens[1], tokens[2],
							tokens[3],tokens[4]);

				
				}
			}*/
			if(name.equals("admin")) {
				return CsvFileReader.csvvergleichenadmin("Login.csv", passwd);
				
			}else {
				return CsvFileReader.csvvergleichen("Login.csv", name, passwd);
			}
		}
		else if(benutzer == false) {//gast keine Überprüfung notwendig
			return new Gast(passwd, passwd, passwd, passwd, 0, passwd);
		}
		
		return null;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Test start");
		User benutzer;
	//	do {
			
			
		 benutzer= einlogen(true,"reklakla","Klausi123");
//		}while(benutzer==null);
		 System.out.println(benutzer+"###perfekt");
		 Gast gast=new Gast("Kevin", "Maier", "Klausen Langreinstraße 5", "*Ausweisnummer*", Gast.getGaste(), null);
		benutzer.restaurant_buchen(Date.valueOf("2018-3-17"), Date.valueOf("2018-3-23"),gast);
		benutzer.restaurant_buchen(Date.valueOf("2018-3-17"), Date.valueOf("2018-3-24"),gast);
		CsvFileReader.readCsvFile("restaurant.csv");
		CsvFileReader.readLeistungCsvFile("restaurant.csv");
	}

}
