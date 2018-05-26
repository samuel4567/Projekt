
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ashraf_sarhan
 *
 */
public class CsvFileReader {

	// Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";

	// Student attributes index

	public static void readCsvFile(String fileName) {

		BufferedReader fileReader = null;

		try {

			// Create a new list of student to be filled by CSV file data
			List<Rezeptionist> rezeptionistlist = new ArrayList<Rezeptionist>();

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
				if (tokens.length > 0) {
					Rezeptionist rezeptionist = new Rezeptionist(Integer.parseInt(tokens[0]), tokens[1], tokens[2],
							tokens[3], tokens[4]);

					rezeptionistlist.add(rezeptionist);
				}
			}

			// Print the new student list

			for (Rezeptionist rezeptionist1 : rezeptionistlist) {
				System.out.println(rezeptionist1.getVorname() + " " + rezeptionist1.getNachname() + " "
						+ rezeptionist1.getPasswd());

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

	public static Rezeptionist csvvergleichen(String fileName, String name, String passwd) {

		BufferedReader fileReader = null;

		try {

			// Create a new list of student to be filled by CSV file data
			List<Rezeptionist> rezeptionistlist = new ArrayList<Rezeptionist>();

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

			// Create a new list of student to be filled by CSV file data
			List<Rezeptionist> rezeptionistlist = new ArrayList<Rezeptionist>();

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
