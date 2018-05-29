
import java.io.IOException;
import java.sql.Date;

public class Main {
	public static Admin a = new Admin();// Admin wird inizialisiert

	public static void main(String[] args) throws IOException {
		System.out.println("###############Start###############");
		Rezeptionist res = new Rezeptionist(15, "rekevkev2", "Kevin", "Kevin", "666test");
		System.out.println("res erstellt");
		// a.rezeptionistenhinzufugen("Kevin", "Kevin", "123");
		// a.rezeptionistenhinzufugen("Kevin", "Kevin", "123");
		// a.rezeptionistenhinzufugen("Simon", "Unterhofer", "123");
		// a.rezeptionistenloschen("rekevkev1");
		// System.out.println(benutzer+"###perfekt");
		Gast gast = new Gast("Kevin", "Maier", "Klausen Langreinstraﬂe 5", "*Ausweisnummer*", "*Steuernummer*");
		Gast gast1 = new Gast("Michel", "Bauer", "Klausen Langreinstraﬂe 2", "*Ausweisnummer*", "*Steuernummer*");
		Gast gast2 = new Gast("Jonas", "Nusser", "Klausen Langreinstraﬂe 2", "*Ausweisnummer*", "*Steuernummer*");
		Gast gast3 = new Gast("Philipp", "Leitner", "Klausen Langreinstraﬂe 2", "*Ausweisnummer*", "*Steuernummer*");

		gast.leistung_buchen(Date.valueOf("2018-3-17"), Date.valueOf("2018-3-30"), gast, 2);
		gast.leistung_buchen(Date.valueOf("2018-3-17"), Date.valueOf("2018-3-23"), gast, 4);
		gast3.leistung_buchen(Date.valueOf("2018-3-17"), Date.valueOf("2018-3-30"), gast3, 2);
		gast1.leistung_buchen(Date.valueOf("2018-3-17"), Date.valueOf("2018-3-24"), gast1, 3);
		gast2.leistung_buchen(Date.valueOf("2018-3-17"), Date.valueOf("2018-3-23"), gast2, 5);
		gast.leistung_buchen(Date.valueOf("2018-3-17"), Date.valueOf("2018-3-23"), gast, 4);
		gast2.leistung_buchen(Date.valueOf("2018-3-17"), Date.valueOf("2018-3-23"), gast2, 2);
		gast3.zimmer_buchen(Date.valueOf("2018-3-17"), Date.valueOf("2018-3-23"), true, 1, true, gast3);
		// CsvFileReader.readCsvFile("restaurant.csv");
		CsvFileReader.readLeistungCsvFile("restaurant.csv");
		System.out.println("restaurant auslesen");
		Gast[] gaste = CsvFileReader.getgaste();
		System.out.println("Benutzer:");
		System.out.println(Gast.getGaste());
		System.out.println("Rezeptionisten:");
		res.setVorname("Michael");
		System.out.println(Rezeptionist.getAnzahlrez());
		System.out.println(a.rezeptionistenbearbeiten(res));
		System.out.println(res.getId());
		/*
		 * for(int i=0;i<gaste.length;i++) { gaste[i].printinfo(); }
		 */
		System.out.println("###############Ende################");
		return;
	}

}
