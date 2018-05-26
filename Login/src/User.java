
public abstract class User {

	public int schwimmbad_buchen(int von, int bis) {
		return 3;
	}

	public static Rezeptionist getrezeptionist(String username) {
		
		if(true/*if nothing found*/)
		return null;
		else {
			return new Rezeptionist(); 
		}
	}

	public int sauna_buchen(int von, int bis) {
		return 3;
	}

	public int zimmer_buchen(int von, int bis, boolean vollpension, int zimmerart, boolean zusatzbett) {
		return 3;
	}

	public int kegelbahn_buchen(int von, int bis) {
		return 3;
	}

	public int restaurant_buchen(int von, int bis) {
		return 3;
	}
}
