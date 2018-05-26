import java.util.Date;

public class Zimmer {
	private Date von;
	private Date bis;
	private int zimmerart;//1einzelzimmer 2Dopperzimmer 0 Suite
	private boolean vollpension; //0=Halb 1=Vollpension
	private boolean zusatzbett;
	private String  steuernummer;
	private  String vorname;
	private String nachname;
	public Zimmer(Date von,Date bis,int zimmerart,boolean vollpension, boolean zusatzbett,String steuernummer,String vorname,String nachname) {
		this.von=von;
		this.bis=bis;
		this.zimmerart=zimmerart;
		this.vollpension=vollpension;
		this.zusatzbett=zusatzbett;
		this.steuernummer=steuernummer;
		this.vorname=vorname;
		this.nachname=nachname;
	}
	public boolean isZusatzbett() {
		return zusatzbett;
	}
	public void setZusatzbett(boolean zusatzbett) {
		this.zusatzbett = zusatzbett;
	}
	public Date getVon() {
		return von;
	}
	public void setVon(Date von) {
		this.von = von;
	}
	public Date getBis() {
		return bis;
	}
	public void setBis(Date bis) {
		this.bis = bis;
	}
	public Integer getZimmerart() {
		return zimmerart;
	}
	public void setZimmerart(int zimmerart) {
		this.zimmerart = zimmerart;
	}
	public boolean isVollpension() {
		return vollpension;
	}
	public void setVollpension(boolean vollpension) {
		this.vollpension = vollpension;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getSteuernummer() {
		return steuernummer;
	}
	public void setSteuernummer(String steuernummer) {
		this.steuernummer = steuernummer;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
}
