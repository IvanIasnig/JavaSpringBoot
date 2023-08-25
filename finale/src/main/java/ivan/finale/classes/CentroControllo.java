package ivan.finale.classes;

import ivan.finale.interfaces.Allarme;
import ivan.finale.interfaces.Observer;

public class CentroControllo implements Allarme, Observer{
	
	@Override
	public void aggiorna(int livFumo, double latitudine, double longitudine) {
		notifica(livFumo, latitudine, longitudine);
	}
	
	@Override
	public void notifica(int livFumo, double latitudine, double longitudine) {
		System.out.println("http://hostialarm?idsonda="  + "&lat=" + latitudine + "&lon=" + longitudine + "&smokelevel=" + livFumo);
	};

}
