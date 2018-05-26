
public class Rezeptionist extends User{
	private String passwd;
	private String vorname;
	private String nachname;
	private String benutzername;
	private  int id;
	public static int anzahlrez=0;
	public Rezeptionist() {
		
		anzahlrez++;
	}
	public Rezeptionist(int id,String benutzername, String vorname, String nachname, String password) {
		this.id=id;
		this.benutzername=benutzername;
		this.vorname=vorname;
		this.nachname=nachname;
		this.passwd=password;
		anzahlrez++;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		id = id;
	}
	public String getBenutzername() {
		return benutzername;
	}
	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

}
