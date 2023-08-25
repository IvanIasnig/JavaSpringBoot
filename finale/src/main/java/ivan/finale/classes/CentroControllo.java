package ivan.finale.classes;

import ivan.finale.interfaces.Observer;
import ivan.finale.proxy.AllarmeProxy;

public class CentroControllo implements Observer{
	
	private AllarmeProxy allarme;
	
	
	
	public CentroControllo() {
		this.allarme = new AllarmeProxy();
	}


	@Override
	public void aggiorna(String id,int livFumo, double latitudine, double longitudine) {
		allarme.notifica(id,livFumo, latitudine, longitudine);
	}
	


}
