import java.io.IOException;
import java.util.Date;

public abstract class User {
	//1 Zimmer  2 Sauna 3 Schwimmbad 4 Restaurant 5 Kegelbahn
	public int schwimmbad_buchen(Date von, Date bis,Gast a) {
		Zusatzleistungen leistung=new Zusatzleistungen(von,bis,3,a);
		try {
			CsvFileWriter.csv_schreiben(leistung);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		return 1;
	}
	//Date von,Date bis,int art,String steuernummer,String vorname,String nachname) {
		


	public int sauna_buchen(Date von, Date bis,Gast a) {
		Zusatzleistungen leistung=new Zusatzleistungen(von,bis,2,a);
		try {
			CsvFileWriter.csv_schreiben(leistung);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		return 1;
	}
	public int zimmer_buchen(Date von, Date bis, boolean vollpension, int zimmerart, boolean zusatzbett, Gast a) {
		Zimmer leistung=new Zimmer(von,bis, zimmerart,vollpension,zusatzbett,a);
		try {
			CsvFileWriter.csv_schreiben(leistung);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

	public int kegelbahn_buchen(Date von, Date bis,Gast a) {
		Zusatzleistungen leistung=new Zusatzleistungen(von,bis,5,a);
		try {
			CsvFileWriter.csv_schreiben(leistung);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

	public int restaurant_buchen(Date von, Date bis,Gast a) {
		Zusatzleistungen leistung=new Zusatzleistungen(von,bis,4,a);
		try {
			CsvFileWriter.csv_schreiben(leistung);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		return 1;
	}
}
