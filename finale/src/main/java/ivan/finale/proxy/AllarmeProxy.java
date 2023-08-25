package ivan.finale.proxy;

import ivan.finale.interfaces.Allarme;

public class AllarmeProxy implements Allarme {

	@Override
	public void notifica(String id,int livFumo, double latitudine, double longitudine) {
		System.out.println("http://hostialarm?idsonda="+ id + "&lat=" + latitudine + "&lon=" + longitudine + "&smokelevel=" + livFumo);
	};

}
