package ivan.finale.classes;

import ivan.finale.interfaces.Allarme;
import ivan.finale.interfaces.Observer;

public class CentroControllo implements Allarme, Observer{
	
	@Override
	public void aggiorna(String id,int livFumo, double latitudine, double longitudine) {
		notifica(id,livFumo, latitudine, longitudine);
	}
	
	@Override
	public void notifica(String id,int livFumo, double latitudine, double longitudine) {
		System.out.println("http://hostialarm?idsonda="+ id + "&lat=" + latitudine + "&lon=" + longitudine + "&smokelevel=" + livFumo);
	};

}
