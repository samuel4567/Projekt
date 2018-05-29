import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Rezeptionist extends Hoteluser {
	private String passwd;
	private String vorname;
	private String nachname;
	private String benutzername;
	private int id;
	private ArrayList<Integer> gasteliste = new ArrayList<Integer>();
	private static int anzahlrez = 1;
	private Gast gast;

	public Rezeptionist(String benutzername, String vorname, String nachname, String password) throws IOException {
		this.benutzername = benutzername;
		this.vorname = vorname;
		this.nachname = nachname;
		this.passwd = password;
		id = anzahlrez;
		anzahlrez++;
		FileWriter fileWriter = new FileWriter("einstellungen.csv", false);// True wird verändert damit die datei nicht
																			// überschreibt
		Integer ll = Gast.getGaste();
		fileWriter.append(ll.toString());
		fileWriter.append(",");// ID;Vorname;Nachname;Adresse;Steuernummer;Ausweis;Von;Bis
		ll = Rezeptionist.getAnzahlrez();
		fileWriter.append(ll.toString());
		fileWriter.append(",");
		fileWriter.append(Zusatzleistungen.nummer.toString());
		try {
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			System.out.println("Error while flushing/closing fileWriter !!!");
			e.printStackTrace();
		}
	}

	public Rezeptionist(int id, String benutzername, String vorname, String nachname, String password) {
		this.benutzername = benutzername;
		this.vorname = vorname;
		this.nachname = nachname;
		this.passwd = password;
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBenutzername() {
		return benutzername;
	}

	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	public ArrayList<Integer> getGasteliste() {
		return gasteliste;
	}

	public void setGasteliste(ArrayList<Integer> gasteliste) {
		this.gasteliste = gasteliste;

	}

	
	private void listeuberarbeiten() {
		int ruckgabe = 0;
		System.out.println("geat");
		String COMMA_DELIMITER = ",";
		String fileName = "Rezeptionist_gasteliste.csv";
		BufferedWriter filewriter = null;
		String line;
		ArrayList<String[]> arr = null;
		// Create the file reader
		BufferedReader fileReader;
		try {

			// Create a new list of student to be filled by CSV file data

			line = "";
			arr = new ArrayList<String[]>();
			// Create the file reader
			fileReader = new BufferedReader(new FileReader(fileName));

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
				if (arr.get(i)[0].equals(getId().toString())) {
					String[] ess = new String[gasteliste.size() + 1];
					ess[0] = getId().toString();
					ruckgabe = 1;
					for (int j = 1; j < ess.length; j++)
						ess[i] = gasteliste.get(j - 1).toString();
					arr.set(i, ess);
					break;
				}
			}
			if (ruckgabe != 1) {
				String[] ess = new String[gasteliste.size() + 1];
				ess[0] = getId().toString();
				ruckgabe = 1;
				for (int j = 1; j < ess.length; j++)
					ess[j] = gasteliste.get(j - 1).toString();
				arr.add(ess);
			}
			System.out.println();
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("Error while closing fileWriter !!!");
				e.printStackTrace();
			}
		} catch (Exception e) {// Keine Liste Gefunden
			System.out.println(e);
		}

		try {
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
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			System.out.println("Error while flushing/closing fileWriter !!!");
			e.printStackTrace();
		}

	}

	public void addgastebynummer(Integer e) {
		gasteliste.add(e);
		listeuberarbeiten();
		// Mithilfe von CSVFileReader.getgaste() werden alle Gäste zurückgegeben die
	}

	public Gast getGast() {
		return gast;
	}

	public boolean removegast(Gast gast) {
		if (gasteliste.contains(gast.getIntGastnummer())) {
			gasteliste.remove(gasteliste.indexOf(gast.getIntGastnummer()));
			return true;
		}
		return false;
	}

	public boolean setGast(Gast gast) {
		if (gasteliste.contains(gast.getIntGastnummer())) {
			this.gast = gast;
			return true;
		}
		return false;
	}

	public static int getAnzahlrez() {
		return anzahlrez;
	}

	public static void setAnzahlrez(int anzahlrez) {
		Rezeptionist.anzahlrez = anzahlrez;
	}
}
