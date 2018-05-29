import java.io.IOException;
import java.util.Date;

public abstract class User {
	//1 Zimmer  2 Sauna 3 Schwimmbad 4 Restaurant 5 Kegelbahn

	public int leistung_buchen(Date von, Date bis,Gast a,int art) {
		Zusatzleistungen leistung=new Zusatzleistungen(von,bis,art,a);
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

	
}
