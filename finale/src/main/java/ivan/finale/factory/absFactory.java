package ivan.finale.factory;

import ivan.finale.classes.Sensore;

public abstract class absFactory {
	public Sensore creaSensore(String id,double latitudine,double longitudine) {
		return new Sensore(id,latitudine, longitudine);
	}
}
