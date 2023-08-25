package ivan.finale.interfaces;

import java.util.UUID;

public interface Allarme {
	public void notifica(int livFumo, double latitudine, double longitudine, UUID id);
}
