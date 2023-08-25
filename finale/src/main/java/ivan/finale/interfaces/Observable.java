package ivan.finale.interfaces;

public interface Observable {
	public void modObserver(Observer obs); //ho visto che in genere si fa così, potevo anche levare l'interface e l'annotation @Override dai metodi nella classe Sensore
	public void notiObserver();
}
