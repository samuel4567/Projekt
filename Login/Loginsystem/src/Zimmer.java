import java.util.Date;

public class Zimmer extends Zusatzleistungen{
	private int zimmerart;//1einzelzimmer 2Dopperzimmer 0 Suite
	private boolean vollpension; //0=Halb 1=Vollpension
	private boolean zusatzbett;

	public Zimmer(Date von,Date bis,int zimmerart,boolean vollpension, boolean zusatzbett,Gast gast) {
		super(von,bis,1,gast);
		this.zimmerart=zimmerart;
		this.vollpension=vollpension;
		this.zusatzbett=zusatzbett;
	}
	public boolean isZusatzbett() {
		return zusatzbett;
	}
	public void setZusatzbett(boolean zusatzbett) {
		this.zusatzbett = zusatzbett;
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
}
