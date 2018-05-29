import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Hoteluser extends User{
	public void csv_Zimmer(Zimmer leistung) {
		String fileName = "zimmer.csv";

		String COMMA_DELIMITER = ",";
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
				if (arr.get(i)[1].equals(leistung.id.toString())) {
					String[] ess = new String[5];
					ess[0] = leistung.id.toString();
					ess[1] = leistung.gast.getIntGastnummer().toString();
					ess[2] = leistung.gast.getStrVorName();
					ess[3] = leistung.gast.getStrNachName();
					ess[4] = leistung.gast.getStrAdresse();
					ess[5] = leistung.gast.getStrSteuernummer();
					ess[6] = leistung.gast.getStrAusweisnummer();
					ess[7] = leistung.getVon().toString();
					ess[8] = leistung.getBis().toString();
					ess[9]= leistung.getZimmerart().toString();
					ess[10]=leistung.isVollpension().toString();
					ess[11]=leistung.isZusatzbett().toString();
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

	}
	public void buchungenloschen(Zusatzleistungen leistung) {
		String fileName = null;
		switch (leistung.getart()) {// 1 Zimmer 2 Sauna 3 Schwimmbad 4 Restaurant 5 Kegelbahn

		case 1:
			fileName = "zimmer.csv";
			break;
			//csv_Zimmer((Zimmer) leistung);
			//return;
		case 2:
			fileName = "sauna.csv";
			break;
		case 3:
			fileName = "schwimmbad.csv";
			break;
		case 4:
			fileName = "restaurant.csv";
			break;
		case 5:
			fileName = "kegelbahn.csv";
			break;
		default:
			return;
		}

		String COMMA_DELIMITER = ",";
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
				if (arr.get(i)[1].equals(leistung.id.toString())) {
					String[] ess = new String[1];
					ess[0]="";
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

	}
	public void buchungenbearbeiten(Zusatzleistungen leistung) {
		String fileName = null;
		switch (leistung.getart()) {// 1 Zimmer 2 Sauna 3 Schwimmbad 4 Restaurant 5 Kegelbahn

		case 1:
			csv_Zimmer((Zimmer) leistung);
			return;
		case 2:
			fileName = "sauna.csv";
			break;
		case 3:
			fileName = "schwimmbad.csv";
			break;
		case 4:
			fileName = "restaurant.csv";
			break;
		case 5:
			fileName = "kegelbahn.csv";
			break;
		default:
			return;
		}

		String COMMA_DELIMITER = ",";
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
				if (arr.get(i)[1].equals(leistung.id.toString())) {
					String[] ess = new String[9];
					ess[0] = leistung.id.toString();
					ess[1] = leistung.gast.getIntGastnummer().toString();
					ess[2] = leistung.gast.getStrVorName();
					ess[3] = leistung.gast.getStrNachName();
					ess[4] = leistung.gast.getStrAdresse();
					ess[5] = leistung.gast.getStrSteuernummer();
					ess[6] = leistung.gast.getStrAusweisnummer();
					ess[7] = leistung.getVon().toString();
					ess[8] = leistung.getBis().toString();
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

	}

}
