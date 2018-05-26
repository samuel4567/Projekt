import java.io.FileWriter;
import java.io.IOException;

public class Admin extends User {
	public String passwd;

	public Admin(String password) {
		this.passwd=password;
		String COMMA_DELIMITER = ",";
		String fileName = "Login.csv";
		String NEW_LINE_SEPARATOR = "\n";
		String FILE_HEADER = "id,benutzername,vorname,nachname,password";
		Admin admin = new Admin(password);
		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter(fileName);
			fileWriter.append(FILE_HEADER.toString());
			fileWriter.append(NEW_LINE_SEPARATOR);

			fileWriter.append(String.valueOf(1));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("admin");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("admin");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("admin");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(admin.getPasswd());
			fileWriter.append(NEW_LINE_SEPARATOR);

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

	}

	private String getPasswd() {
		// TODO Auto-generated method stub
		return passwd;
	}

	public int rezeptionistenhinzufugen(String vorname,String nachname,String password) {
		String COMMA_DELIMITER = ",";
		String fileName = "Login.csv";
		String NEW_LINE_SEPARATOR = "\n";
		String benutzername="";
		benutzername="re"+nachname.substring(0, 2)+vorname.substring(0, 2);
		System.out.println(benutzername);
		Rezeptionist rezeptionist = new Rezeptionist(Rezeptionist.anzahlrez,benutzername,vorname,nachname,password);
		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter(fileName,true);
			/*	fileWriter.append(String.valueOf(rezeptionist.getId()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(rezeptionist.getVorname());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(rezeptionist.getNachname());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(rezeptionist.getPasswd());
			fileWriter.append(NEW_LINE_SEPARATOR);
*/	
			fileWriter.write(String.valueOf(rezeptionist.getId()));
			//fileWriter.write(rezeptionist.getId());
			
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
