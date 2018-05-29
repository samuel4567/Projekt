import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Admin extends Hoteluser {
	private String passwd;

	public boolean setpasswd(String passwd, String passwdalt) {
		if (passwd.equals(passwdalt)) {
			this.passwd = passwd;
		}
		return false;
	}

	

	public void buchungbearbeiten() {

	}
	public Admin(String passwd) {
		
	}
	public Admin() {
		init();
		FileWriter fileWriter = null;
		BufferedReader fileReader = null;
		String COMMA_DELIMITER = ",";
		String fileName = "Login.csv";
		String NEW_LINE_SEPARATOR = "\n";
		try {

			String line = "";

			// Create the file reader
			try {
				fileReader = new BufferedReader(new FileReader(fileName));
				line = fileReader.readLine();
				String[] tokens = line.split(COMMA_DELIMITER);
				this.passwd = tokens[4];
			} catch (Exception e) {
				try {
				fileReader.close();
				} catch (Exception ex) {}
				System.err.println("Login.csv erstellt");
				fileWriter = new FileWriter(fileName, true);
				fileWriter.append(String.valueOf(0));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append("admin");
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append("admin");
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append("admin");
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append("123456");//Default Passwd
				fileWriter.append(NEW_LINE_SEPARATOR);
				try {
					fileWriter.flush();
					fileWriter.close();
				} catch (IOException exx) {
					System.out.println("Error while flushing/closing fileWriter !!!");
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			System.out.println("Error in CsvFileReader !!!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (Exception e) {

			}
		}

	}

	private void init() {// Einstellungen laden

		String fileName = "einstellungen.csv";
		BufferedReader fileReader = null;
		String COMMA_DELIMITER = ",";
		try {
			String line = "";
			fileReader = new BufferedReader(new FileReader(fileName));
			while ((line = fileReader.readLine()) != null) {
				String[] tokens = line.split(COMMA_DELIMITER);
				if (tokens.length > 0) {
					Gast.setGaste(Integer.parseInt(tokens[0]));
					Rezeptionist.setAnzahlrez(Integer.parseInt(tokens[1]));
					Zusatzleistungen.nummer = (Integer.parseInt(tokens[2]));
					if (Rezeptionist.getAnzahlrez() == 0)
						Rezeptionist.setAnzahlrez(1);
				} // Anzahl an Gästen wird auf den alten stand gesetzt!

			}
		} catch (Exception e) {
			
		} finally {
			/*
			 * try { fileReader.close(); } catch (IOException e) {
			 * System.out.println("Error while closing fileReader !!!"); }
			 */ }
	}

	private String getPasswd() {
		// TODO Auto-generated method stub
		return passwd;
	}



	public int rezeptionistenbearbeiten(Rezeptionist benutzer) throws IOException {
		int ruckgabe = -1;
		System.out.println("geat");
		String COMMA_DELIMITER = ",";
		String fileName = "Login.csv";
		BufferedWriter filewriter = null;
		try {

			// Create a new list of student to be filled by CSV file data

			String line = "";
			ArrayList<String[]> arr = new ArrayList<String[]>();
			// Create the file reader
			BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

			// Read the CSV file header to skip it
			// System.out.println(fileReader.readLine());

			// Read the file line by line starting from the second line
			while ((line = fileReader.readLine()) != null) {
				String[] tokens = line.split(COMMA_DELIMITER);
				if (tokens.length > 0) {
					arr.add(tokens);
				}
			}
			for (int i = 0; i < arr.size(); i++) {
				if (arr.get(i)[1].equals(benutzer.getBenutzername())) {
					String[] ess = new String[5];
					ess[0] = benutzer.getId().toString();
					ess[1] = benutzer.getBenutzername();
					ess[2] = benutzer.getVorname();
					ess[3] = benutzer.getNachname();
					ess[4] = benutzer.getPasswd();
					ruckgabe = 1;
					arr.set(i, ess);
					break;
				}
			}
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("Error while closing fileWriter !!!");
				e.printStackTrace();
			}
			filewriter = new BufferedWriter(new FileWriter(fileName));

			for (int i = 0; i < arr.size(); i++) {
				if (arr.get(i)[0].equals(""))
					i++;
				for (int j = 0; j < arr.get(i).length; j++) {
					filewriter.write(arr.get(i)[j]);
					filewriter.write(COMMA_DELIMITER);
				}
				filewriter.newLine();

			}

		} catch (Exception e) {
			System.err.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {

			try {
				filewriter.flush();
				filewriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}

		}
		return ruckgabe;
	}

	public int rezeptionistenloschen(String benutzername) throws IOException {
		int ruckgabe = -1;
		String COMMA_DELIMITER = ",";
		String fileName = "Login.csv";
		BufferedWriter filewriter = null;
		try {

			// Create a new list of student to be filled by CSV file data

			String line = "";
			ArrayList<String[]> arr = new ArrayList<String[]>();
			// Create the file reader
			BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

			// Read the CSV file header to skip it
			// System.out.println(fileReader.readLine());

			// Read the file line by line starting from the second line
			while ((line = fileReader.readLine()) != null) {
				String[] tokens = line.split(COMMA_DELIMITER);
				if (tokens.length > 0) {
					arr.add(tokens);
				}
			}
			for (int i = 0; i < arr.size(); i++) {
				if (arr.get(i)[1].equals(benutzername)) {
					String[] ess = new String[1];
					ess[0] = "";
					ruckgabe = 1;
					arr.set(i, ess);
					break;
				}
			}
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("Error while closing fileWriter !!!");
				e.printStackTrace();
			}
			filewriter = new BufferedWriter(new FileWriter(fileName));

			for (int i = 0; i < arr.size(); i++) {
				if (arr.get(i)[0].equals(""))
					i++;
				for (int j = 0; j < arr.get(i).length; j++) {
					filewriter.write(arr.get(i)[j]);
					filewriter.write(COMMA_DELIMITER);
				}
				filewriter.newLine();

			}

		} catch (Exception e) {
			System.err.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {

			try {
				filewriter.flush();
				filewriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}

		}
		return ruckgabe;
	}

	public int rezeptionistenloschen(String vorname, String nachname) throws IOException {
		return rezeptionistenloschen(
				"re" + nachname.substring(0, 3).toLowerCase() + vorname.substring(0, 3).toLowerCase());
	}

	public int rezeptionistenhinzufugen(String vorname, String nachname, String password) throws IOException {
		String COMMA_DELIMITER = ",";
		String fileName = "Login.csv";
		String NEW_LINE_SEPARATOR = "\n";
		String benutzername = "";
		Boolean nameinuse = null;
		int j = 0;
		benutzername = "re" + nachname.substring(0, 3).toLowerCase() + vorname.substring(0, 3).toLowerCase();
		// Schauen ob es einen mit den Gleichen Benutzernamen gibt:

		try {

			// Create the file reader

			do {
				BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
				String line = "";
				ArrayList<String[]> arr = new ArrayList<String[]>();
				nameinuse = false;
				while ((line = fileReader.readLine()) != null) {
					String[] tokens = line.split(COMMA_DELIMITER);
					if (tokens.length > 0) {
						arr.add(tokens);
					}
				}
				for (int i = 0; i < arr.size(); i++) {
					if (arr.get(i)[1].equals(benutzername)) {
						// Name wird schon benutzt
						nameinuse = true;
						benutzername = "re" + nachname.substring(0, 3).toLowerCase()
								+ vorname.substring(0, 3).toLowerCase() + ++j;
						break;
					}
				}
				fileReader.close();
			} while (nameinuse);

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error while closing fileWriter !!!");
			e.printStackTrace();
		}

		Rezeptionist rezeptionist = new Rezeptionist(benutzername, vorname, nachname, password);
		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter(fileName, true);
			/*
			 * fileWriter.append(String.valueOf(rezeptionist.getId()));
			 * fileWriter.append(COMMA_DELIMITER);
			 * fileWriter.append(rezeptionist.getVorname());
			 * fileWriter.append(COMMA_DELIMITER);
			 * fileWriter.append(rezeptionist.getNachname());
			 * fileWriter.append(COMMA_DELIMITER);
			 * fileWriter.append(rezeptionist.getPasswd());
			 * fileWriter.append(NEW_LINE_SEPARATOR);
			 */
			fileWriter.write(String.valueOf(rezeptionist.getId()));
			// fileWriter.write(rezeptionist.getId());

			fileWriter.write(COMMA_DELIMITER);
			fileWriter.write(rezeptionist.getBenutzername());
			fileWriter.write(COMMA_DELIMITER);
			fileWriter.write(rezeptionist.getVorname());
			fileWriter.write(COMMA_DELIMITER);
			fileWriter.write(rezeptionist.getNachname());
			fileWriter.write(COMMA_DELIMITER);
			fileWriter.write(rezeptionist.getPasswd());
			fileWriter.write(NEW_LINE_SEPARATOR);
			System.out.println("CSV file was created successfully !!!");

		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {

			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}

		}

		return rezeptionist.getId();
	}
}
