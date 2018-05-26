import java.util.Date;

public class Zusatzleistungen {
	private Date von;
	private Date bis;
	private int art;//1 Zimmer  2 Sauna 3 Schwimmbad 4 Restaurant 5 Kegelbahn
	public Gast gast;
	public Zusatzleistungen(Date von,Date bis,int art,Gast gast) {
		this.von=von;
		this.bis=bis;
		this.art=art;
		this.gast=gast;
	}
	public void printall() {
		System.out.println("Der Gast "+gast.getStrVorName() +" "+gast.getStrNachName()+" mit der Steuernummer "+gast.getStrSteuernummer()+" bleibt von "+von.toString()+" bis "+bis.toString()+ " und beansprucht Leistung nummer "+art);
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
