
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ashraf_sarhan
 *
 */
public class CsvFileReader {

	// Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";

	// Student attributes index

	public static void readLeistungCsvFile(String fileName) {
		int art;//1 Zimmer  2 Sauna 3 Schwimmbad 4 Restaurant 5 Kegelbahn
		BufferedReader fileReader = null;
		if(fileName.equalsIgnoreCase("sauna.csv"))
			art=2;
		else if(fileName.equalsIgnoreCase("restaurant.csv"))
			art=4;
		else if(fileName.equalsIgnoreCase("schwimmbad.csv"))
			art=3;
		else if(fileName.equalsIgnoreCase("Kegelbahn.csv"))
			art=5;
		else
			return;
		try {

			// Create a new list of student to be filled by CSV file data
			List<Zusatzleistungen> zusatzleistungen = new ArrayList<Zusatzleistungen>();

			String line = "";

			// Create the file reader
			fileReader = new BufferedReader(new FileReader(fileName));

			// Read the CSV file header to skip it
			System.out.println(fileReader.readLine());

			// Read the file line by line starting from the second line
			while ((line = fileReader.readLine()) != null) {
				String[] tokens = line.split(COMMA_DELIMITER);
				System.out.println(tokens);
				for (int i = 0; i < tokens.length; i++) {
					System.out.println(tokens[i] + " Test17");
				}
				//public Zusatzleistungen(Date von,Date bis,int art,String steuernummer,String vorname,String nachname) {
				/*
		 	fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(sauna.getVorname());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(sauna.getNachname());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(sauna.getSteuernummer());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(sauna.getVon().toString());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(sauna.getBis().toString());
			fileWriter.append(NEW_LINE_SEPARATOR);
				 */
				if (tokens.length > 0) {//Wichtig überarbeiten Funktion umändern dass sie 
					for(int i=0;i<tokens.length;i++) {
						System.out.print(" "+i+"  "+tokens[i]);
					}
					Gast a=new Gast(tokens[2],tokens[3],tokens[4],tokens[5],Integer.parseInt(tokens[1]),tokens[3]);
					Zusatzleistungen zusatzleistung =new Zusatzleistungen(java.sql.Date.valueOf(tokens[4]),java.sql.Date.valueOf(tokens[5]),art,a);
					//Zusatzleistungen(von,bis,gast)
					zusatzleistungen.add(zusatzleistung);
				}
			}

			// Print the new student list

			for (Zusatzleistungen zusatzleistung : zusatzleistungen) {
				zusatzleistung.printall();

			}
		} catch (Exception e) {
			System.out.println("Error in CsvFileReader !!!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("Error while closing fileReader !!!");
				e.printStackTrace();
			}
		}

	}
	public static void readCsvFile(String fileName) {

		BufferedReader fileReader = null;

		try {

			// Create a new list of student to be filled by CSV file data
			

			String line = "";

			// Create the file reader
			fileReader = new BufferedReader(new FileReader(fileName));

			// Read the CSV file header to skip it
	//		System.out.println(fileReader.readLine());

			// Read the file line by line starting from the second line
			while ((line = fileReader.readLine()) != null) {
				String[] tokens = line.split(COMMA_DELIMITER);
				System.out.println(tokens);
				for (int i = 0; i < tokens.length; i++) {
					System.out.println(tokens[i] + " Test17");
				}
				if (tokens.length > 0) {//Wichtig überarbeiten Funktion umändern dass sie 
					for(int i=0;i<tokens.length;i++) {
						System.out.print(tokens[i]+" ");
					}
					System.out.println(" ra ");
				}
			}

			// Print the new student list
		} catch (Exception e) {
			System.out.println("Error in CsvFileReader !!!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("Error while closing fileReader !!!");
				e.printStackTrace();
			}
		}

	}
	public static Rezeptionist csvvergleichen(String fileName, String name, String passwd) {

		BufferedReader fileReader = null;

		try {

			// Create a new list of student to be filled by CSV file data
			List<Rezeptionist> rezeptionistlist = new ArrayList<Rezeptionist>();

			String line = "";

			// Create the file reader
			fileReader = new BufferedReader(new FileReader(fileName));
			System.out.println("after csv opened");
			// Read the CSV file header to skip it
			System.out.println(fileReader.readLine());

			// Read the file line by line starting from the second line
			while ((line = fileReader.readLine()) != null) {
				String[] tokens = line.split(COMMA_DELIMITER);
				System.out.println(tokens);
				for (int i = 0; i < tokens.length; i++) {
					System.out.println(tokens[i] + " Test17");
				}
				if (tokens.length > 0) {
					Rezeptionist rezeptionist = new Rezeptionist(Integer.parseInt(tokens[0]), tokens[1], tokens[2],
							tokens[3], tokens[4]);

					rezeptionistlist.add(rezeptionist);
				}
			}

			// Print the new student list

			for (Rezeptionist rezeptionist1 : rezeptionistlist) {
				if (rezeptionist1.getBenutzername().equals(name)) {
					if (rezeptionist1.getPasswd().equals(passwd)) {
						return rezeptionist1;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Error in CsvFileReader !!!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("Error while closing fileReader !!!");
				e.printStackTrace();
			}
		}
		return null;
	}

	public static Admin csvvergleichenadmin(String fileName, String passwd) {

		BufferedReader fileReader = null;

		try {
			

			String line = "";

			// Create the file reader
			fileReader = new BufferedReader(new FileReader(fileName));

			// Read the CSV file header to skip it
			System.out.println(fileReader.readLine());

			// Read the file line by line starting from the second line
			line = fileReader.readLine();
			String[] tokens = line.split(COMMA_DELIMITER);
			if(passwd.equals(tokens[4])) {
				return new Admin(tokens[4]);
			}

			// Print the new student list

			
			
		} catch (Exception e) {
			System.out.println("Error in CsvFileReader !!!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("Error while closing fileReader !!!");
				e.printStackTrace();
			}
		}
		return null;
	}
}
