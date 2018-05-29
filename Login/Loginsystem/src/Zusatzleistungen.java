import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Zusatzleistungen {
	private Date von;
	private Date bis;
	private int art;// 1 Zimmer 2 Sauna 3 Schwimmbad 4 Restaurant 5 Kegelbahn
	public Gast gast;
	public static Integer nummer=0;
	public Integer id;

	public Zusatzleistungen(Date von, Date bis, int art, Gast gast, int id) {
		this.von = von;
		this.bis = bis;
		this.id = id;
		this.art = art;
		this.gast = gast;
	}

	public Zusatzleistungen(Date von, Date bis, int art, Gast gast) {
		this.von = von;
		this.bis = bis;
		id=nummer;
		nummer=nummer+1;
		this.art = art;
		this.gast = gast;
		FileWriter fileWriter;
		try {
			
		 fileWriter = new FileWriter("einstellungen.csv");
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
	}catch (IOException e) {
		System.out.println("Error while flushing/closing fileWriter !!!");
        e.printStackTrace();
	}
		}

	public void printall() {
		System.out.println("Der Gast " + gast.getStrVorName() + " " + gast.getStrNachName() + " mit der Steuernummer "
				+ gast.getStrSteuernummer() + " bleibt von " + von.toString() + " bis " + bis.toString()
				+ " und beansprucht Leistung nummer " + art);
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

	public Integer getart() {
		return art;
	}

	public void setart(int art) {
		this.art = art;
	}

}
