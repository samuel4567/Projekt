
public class Gast extends User {
	private String strVorName;
	private String strNachName;
	private String strAdresse;
	private String strAusweisnummer;
	private static int gaste=1;
	private int intGastnummer;
	private String strSteuernummer;

	public Gast(String strVorName, String strNachName, String strAdresse, String strAusweisnummer, int intGastnummer,
			String strSteuernummer) {
		setGaste(getGaste() + 1);
		this.strVorName=strVorName;
		this.strNachName=strNachName;
		this.strAdresse=strAdresse;
		this.strAusweisnummer=strAusweisnummer;
		this.intGastnummer=intGastnummer;
		this.strSteuernummer=strSteuernummer;
		
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

	public int getIntGastnummer() {
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

	private static void setGaste(int gaste) {
		Gast.gaste = gaste;
	}
}
