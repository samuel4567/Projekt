import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	static Admin a;
	public static void init() {
		Admin a=new Admin("123");
		
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
			return new Gast();
		}
		
		return null;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		User benutzer= einlogen(true,"s","s");
	}

}
