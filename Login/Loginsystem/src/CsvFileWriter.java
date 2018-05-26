
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileWriter {
	
	//Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	
	//CSV file header
	private static final String FILE_HEADER = "id,firstName,lastName,gender,age";
	public static void write_csv_ansicht() throws IOException {
		String fileName="sauna.csv";
		
			FileWriter fileWriter = new FileWriter(fileName,true);
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("admin");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("admin");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("admin");
			fileWriter.append(COMMA_DELIMITER);
		//	fileWriter.append(admin.getPasswd());
			fileWriter.append(NEW_LINE_SEPARATOR);
			fileWriter.close();
			System.out.println("CSV file was created successfully !!!");	
		
	}
	public static void csv_schreiben(Zusatzleistungen leistung) throws IOException {
		switch(leistung.getart()) {//1 Zimmer  2 Sauna 3 Schwimmbad 4 Restaurant 5 Kegelbahn
		case 1:
			csv_Zimmer((Zimmer) leistung);
			break;
		case 2:
			csv_Zusatzleistungen(leistung,"sauna.csv");
			break;
		case 3:
			csv_Zusatzleistungen(leistung,"schwimmbad.csv");
			break;
		case 4:
			csv_Zusatzleistungen(leistung,"restaurant.csv");
			break;
		case 5:
			csv_Zusatzleistungen(leistung,"kegelbahn.csv");
			break;
		default:
			System.err.println("Fehler zusatzleistung gibt es nicht!");
		}
	}	private static void csv_Zimmer(Zimmer zimmer) throws IOException {	
		
		String fileName="zimmer.csv";
		FileWriter fileWriter = new FileWriter(fileName,true);//True wird verändert damit die datei nicht überschreibt
		
		fileWriter.append(COMMA_DELIMITER);
		Integer ll=zimmer.gast.getIntGastnummer();
		fileWriter.append(ll.toString());
		fileWriter.append(COMMA_DELIMITER);
		fileWriter.append(zimmer.gast.getStrVorName());
		fileWriter.append(COMMA_DELIMITER);
		fileWriter.append(zimmer.gast.getStrNachName());
		fileWriter.append(COMMA_DELIMITER);
		fileWriter.append(zimmer.gast.getStrSteuernummer());
		fileWriter.append(COMMA_DELIMITER);
		fileWriter.append(zimmer.gast.getStrAdresse());
		fileWriter.append(COMMA_DELIMITER);
		fileWriter.append(zimmer.gast.getStrAusweisnummer());
		fileWriter.append(COMMA_DELIMITER);
		
		fileWriter.append(zimmer.getVon().toString());
		fileWriter.append(COMMA_DELIMITER);
		fileWriter.append(zimmer.getBis().toString());
		fileWriter.append(COMMA_DELIMITER);
		fileWriter.append(zimmer.getZimmerart().toString());
		fileWriter.append(COMMA_DELIMITER);
		if(zimmer.isVollpension())
			fileWriter.append("true");
		else
			fileWriter.append("false");
		fileWriter.append(COMMA_DELIMITER);
		if(zimmer.isZusatzbett())
			fileWriter.append("true");
		else
			fileWriter.append("false");
		fileWriter.append(NEW_LINE_SEPARATOR);
		fileWriter.close();
		System.out.println("CSV file was created successfully !!!");

	}
	
	private static void csv_Zusatzleistungen(Zusatzleistungen leistung,String fileName) throws IOException {	
		
			FileWriter fileWriter = new FileWriter(fileName,true);//True wird verändert damit die datei nicht überschreibt
			fileWriter.append(COMMA_DELIMITER);
			Integer ll=leistung.gast.getIntGastnummer();
			fileWriter.append(ll.toString());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(leistung.gast.getStrVorName());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(leistung.gast.getStrNachName());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(leistung.gast.getStrSteuernummer());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(leistung.gast.getStrAdresse());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(leistung.gast.getStrAusweisnummer());
			fileWriter.append(COMMA_DELIMITER);
			
			fileWriter.append(leistung.getVon().toString());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(leistung.getBis().toString());
			fileWriter.append(NEW_LINE_SEPARATOR);
			fileWriter.close();
			System.out.println("CSV file was created successfully !!!");

		
		
	}
	public static void writeCsvFile(String fileName) {
		
		//Create new students objects
		Student student1 = new Student(1, "Ahmed", "Mohamed", "M", 25);
		Student student2 = new Student(2, "Sara", "Said", "F", 23);
		Student student3 = new Student(3, "Ali", "Hassan", "M", 24);
		Student student4 = new Student(4, "Sama", "Karim", "F", 20);
		Student student5 = new Student(5, "Khaled", "Mohamed", "M", 22);
		Student student6 = new Student(6, "Ghada", "Sarhan", "F", 21);
		
		//Create a new list of student objects
		List<Student> students = new ArrayList<Student>();
		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(student4);
		students.add(student5);
		students.add(student6);
		
		FileWriter fileWriter = null;
				
		try {
			fileWriter = new FileWriter(fileName);

			//Write the CSV file header
			fileWriter.append(FILE_HEADER.toString());
			
			//Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);
			
			//Write a new student object list to the CSV file
			for (Student student : students) {
				fileWriter.append(String.valueOf(student.getId()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(student.getFirstName());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(student.getLastName());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(student.getGender());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(student.getAge()));
				fileWriter.append(NEW_LINE_SEPARATOR);
			}

			
			
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
}
