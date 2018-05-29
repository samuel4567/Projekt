import java.io.FileWriter;
import java.io.IOException;

public class Gast extends User {
	private String strVorName;
	private String strNachName;
	private String strAdresse;
	private String strAusweisnummer;
	private static int gaste=0;
	private int intGastnummer;
	private String strSteuernummer;

	public Gast(String strVorName, String strNachName, String strAdresse, String strAusweisnummer, int gastnummer,
			String strSteuernummer) {
		this.intGastnummer=gastnummer;
//		setGaste(getGaste() + 1);
		this.strVorName=strVorName;
		this.strNachName=strNachName;
		this.strAdresse=strAdresse;
		this.strAusweisnummer=strAusweisnummer;
		
		this.strSteuernummer=strSteuernummer;
		
	}
	public Gast(String strVorName, String strNachName, String strAdresse, String strAusweisnummer,
			String strSteuernummer) throws IOException {
		this.intGastnummer=getGaste();
		setGaste(getGaste() + 1);
		this.strVorName=strVorName;
		this.strNachName=strNachName;
		this.strAdresse=strAdresse;
		this.strAusweisnummer=strAusweisnummer;
		this.strSteuernummer=strSteuernummer;
		FileWriter fileWriter = new FileWriter("einstellungen.csv");
		Integer gl=Gast.getGaste();
		fileWriter.append(gl.toString());
		fileWriter.append(",");//ID;Vorname;Nachname;Adresse;Steuernummer;Ausweis;Von;Bis
		Integer rl=Rezeptionist.getAnzahlrez();
		fileWriter.append(rl.toString());
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
	public void printinfo() {
		System.out.println("Herr"+strNachName+" mit den Vorname "+strVorName+" steuer "+strSteuernummer+" Ausweis: "+strAusweisnummer+" wohnhaft in "+strAdresse);
	}
	public void buchung_abschlieﬂen() {
	}

	public void aufs_zimmer_buchen() {
	}

	public void bar_bezahlen() {
	}

	public void kreditkarte_benutzen() {
	}

	public void ueberweisung() {
	}

	public String getStrVorName() {
		return strVorName;
	}

	public void setStrVorName(String strVorName) {
		this.strVorName = strVorName;
	}

	public String getStrNachName() {
		return strNachName;
	}

	public void setStrNachName(String strNachName) {
		this.strNachName = strNachName;
	}

	public String getStrAusweisnummer() {
		return strAusweisnummer;
	}

	public void setStrAusweisnummer(String strAusweisnummer) {
		this.strAusweisnummer = strAusweisnummer;
	}

	public Integer getIntGastnummer() {
		return intGastnummer;
	}

	public void setIntGastnummer(int intGastnummer) {
		this.intGastnummer = intGastnummer;
	}

	public String getStrSteuernummer() {
		return strSteuernummer;
	}

	public void setStrSteuernummer(String strSteuernummer) {
		this.strSteuernummer = strSteuernummer;
	}

	public String getStrAdresse() {
		return strAdresse;
	}

	public void setStrAdresse(String strAdresse) {
		this.strAdresse = strAdresse;
	}

	public static int getGaste() {
		return gaste;
	}

	public static void setGaste(int gaste) {
		Gast.gaste = gaste;
	}
}
